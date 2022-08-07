package LinkedList;

public class LinkedList<T> extends ListAbstract<T> implements ListInterface<T> {

    @Override
    public void add(int index, T value) throws IndexOutOfBoundsException {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException("illegal index");
        }
        Node node = new Node(value);
        if (this.size() == 0 || index == 0) {
            addfront(value);
        }
        else {
            Node ref = head;
            for (int i = 0; i < index - 1; ++i) {
                ref = ref.next;
            }
            node.next = ref.next;
            ref.next = node;
        }
    }

    @Override
    public void addfront(T value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    @Override
    public void addback(T value) {
        Node node = new Node(value);
        if (this.size() == 0) {
            addfront(value);
        }
        else {
            Node ref = head;
            for (int i = 0; i < this.size() - 1; ++i) {
                ref = ref.next;
            }
            ref.next = node;
        }
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("illegal index");
        }
        Node ref = head;
        for (int i = 0; i < index; ++i) {
            ref = ref.next;
        }

        return (T)ref.value;
    }

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("illegal index");
        }
        if (this.size() == 0) {
            return null;
        }
        else if (this.size() == 1) {
            return this.removefront();
        }
        else {
            Node ref = head;
            for (int i = 0; i < index - 1; ++i) {
                ref = ref.next;
            }
            Node remove = ref.next;
            ref.next = remove.next;
            return (T)remove.value;
        }
    }

    @Override
    public T removefront() {
        if (this.size() == 0) {
            return null;
        }
        else {
            Node ref = head;
            head = head.next;
            return (T) ref.value;
        }
    }

    @Override
    public T removeback() {
        if (this.size() == 0) {
            return null;
        }
        else if (this.size() == 1) {
            return this.removefront();
        }
        else {
            Node ref = head;
            for (int i = 0; i < this.size() - 2; ++i) {
                ref = ref.next;
            }
            Node remove = ref.next;
            ref.next = null;
            return (T)remove.value;
        }
    }

    @Override
    public boolean contains(T value) {
        Node ref = head;
        for (int i = 0; i < this.size(); ++i) {
            if (ref.equals(value)) {
                return true;
            }
            ref = ref.next;
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        Node ref = head;
        for (int i = 0; i < this.size(); ++i) {
            if (ref.equals(value)) {
                return i;
            }
            ref = ref.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        Node ref = head;
        int foundat = -1;
        for (int i = 0; i < this.size(); ++i) {
            if (ref.equals(value)) {
                foundat = i;
            }
            ref = ref.next;
        }
        return foundat;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        int size = 0;
        Node ref = head;
        while (ref != null) {
            ++size;
            ref = ref.next;
        }
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        LinkedList<?> otherLinkedList = (LinkedList<?>) o;
        if (this.size() != otherLinkedList.size()) return false;
        Node tlist = this.head;
        Node olist = otherLinkedList.head;
        while (tlist != null) {
            if (!tlist.value.equals(olist.value)) {
                return false;
            }
            tlist = tlist.next;
            olist = olist.next;
        }
        return true;
    }
}
