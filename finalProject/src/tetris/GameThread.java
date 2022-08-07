package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;

import tetris.TetrisPartIII.ControlPanel;
import tetris.TetrisPartIII.UIPanel;

public class GameThread extends Thread {
	
	private UIPanel ui;
	private ControlPanel control;
	private int score;
	private TetrisPartIII tetris;
	private boolean init = true;

    protected static volatile boolean running = true;
    
	public GameThread(UIPanel ui, TetrisPartIII tetris, ControlPanel control) {
		this.ui = ui;
		this.tetris = tetris;
		this.control = control;
	}

	@Override 
	public void run() {
		
		while(true) {
			while(init) {
				
				try {
					tetris.spawnBlock();
					tetris.previousBlock = tetris.block;
					tetris.previousBlocks = tetris.blocks;
					tetris.previousBg = tetris.background;
				
					init = false;
					
					Thread.sleep(500);
					
				} catch(InterruptedException ex) {
					Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
				}
			}

			tetris.spawnBlock();
			control.repaint();
			
			while(ui.moveBlockDown()) {
				try {
					
					while(!running) {
						Thread.sleep(10);
					}
					
					Thread.sleep(TetrisPartIII.speed);
					
				} catch(InterruptedException ex) {
					Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			
			if(ui.isBlockOutOfBounds()) {
				System.out.println("Game Over");
				break;
			}
			
			ui.turnBlockToBackground();
			
			score += ui.clearLine();
			tetris.updateScore(score);
			
		}
	}
}
