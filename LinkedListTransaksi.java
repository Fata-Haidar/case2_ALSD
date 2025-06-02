public class LinkedListTransaksi {
    private Node head;
    private int size = 0;

    public void add(TransaksiLayanan data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public TransaksiLayanan get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node current = head;
        int count = 0;
        while (count < index) {
            current = current.next;
            count++;
        }
        return current.data;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
}
