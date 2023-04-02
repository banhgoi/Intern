package OOP.DataStructures;

public class DLL {
    Node head;

    class Node {
        int data;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(int x) {
            this(x, null, null);
        }

        public Node(int x, Node nextNode, Node prevNode) {
            data = x;
            next = nextNode;
            prev = prevNode;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtBack(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node tmp = head;
            while (tmp.next != null) tmp = tmp.next;
            tmp.next = newNode;
            newNode.prev = tmp;
        }
    }

    public void insert(int x) {
        if (isEmpty()) {
            head = new Node(x);
        } else {
            Node tmp = head;
            while (tmp.next != null && tmp.data < x) {
                tmp = tmp.next;
            }

            if (tmp.prev == null && tmp.data > x) {
                head = new Node(x, tmp, null);
                tmp.prev = head;
            } else if (tmp.data < x)
                tmp.next = new Node(x, null, tmp);
            else
                tmp.prev = new Node(x, tmp, tmp.prev);
        }
    }

    public void delete(int y) {
        if (!isEmpty()) {
            Node tmp = head;
            while (tmp.next != null && tmp.data != y) {
                tmp = tmp.next;
            }
            if (tmp.prev == null && tmp.data == y)
                head = head.next;
            else
                tmp.prev.next = tmp.next;
        }
    }

    public void insertAtFront(int x) {
        Node newNode = new Node(x, head, null);
        head.prev = newNode;
        head = newNode;
    }
    
    public void printAll() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insert(6);
        dll.insert(7);
        dll.insert(1);
        dll.insert(4);
        dll.insertAtBack(8);
        //   dll.InsertBefore(dll.head.next.next, 5);
        dll.printAll();
    }
}