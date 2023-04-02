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
        if (head != null)
            head.prev = newNode;
        head = newNode;
    }

    public void sort(){
        if (isEmpty()) return;
        Node node = head.next;
        Node tmp;
        int x;
        for(; node != null; ) {
            x = node.data;
            tmp = node.prev;
            while (tmp != null && x < tmp.data){
                tmp.next.data = tmp.data;
                tmp = tmp.prev;
            }
            if (tmp == null){
                head.data = x;
            } else {
                tmp.next.data = x;
            }
            node = node.next;
        }
    }

//    public void sort() {
//        if (isEmpty()) return;
//        Node tmp,k;
//        Node key = head.next;
//        if (key.prev == null || key.next == null) return;
//        while (key != null) {
//            k = key;
//            key = key.next;
//            tmp = k.prev;
//            tmp.next = k.next;
//            if (tmp.next != null)
//                tmp.next.prev = tmp;
//            while (tmp != null && key.data < tmp.data)
//            {
//                tmp=tmp.prev;
//            }
//            if (tmp == null) {
//                head.prev = k;
//                k.prev = null;
//                k.next = head.next;
//                head = key;
//            } else {
//                tmp.next = key;
//            }
//            key = key.next;
//        }
//        return;
//    }

    public void printAll() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertAtFront(6);
        dll.insertAtFront(7);
        dll.insertAtBack(1);
        dll.insertAtBack(4);
        dll.insertAtBack(8);
        dll.sort();
        //   dll.InsertBefore(dll.head.next.next, 5);
        dll.printAll();
    }
}