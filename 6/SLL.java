package OOP.DataStructures;

public class SLL {
    Node head;

    SLL() {
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
        }
    }

    public void insertAtFront(int x) {
//        Node newNode = new Node(x);
//        newNode.next = head;
//        head = newNode;

        head = new Node(x, head);
    }

    public void insert(int x) {
        //chen vao vi tri thich hop de ds tang dan

        if (isEmpty()) {
            head = new Node(x, head);
            return;
        } else {
            Node curNode = head;
            Node next = curNode.next;
            Node newNode = new Node(x);
            if (next != null) {
                if(newNode.data<head.data){
                    insertAtFront(newNode.data);
                    return;
                }
                while (!(next.data >= newNode.data && curNode.data <= newNode.data)) {
                    curNode = next;
                    next = next.next;
                    if (next == null) {
                        insertAtBack(x);
                        curNode.next = newNode;
                        newNode.next = null;
                        return;
                    }
                }
            }
            curNode.next = newNode;
            newNode.next = next;
            return;
        }
    }


    public void delete(int y) {
        Node tmp = head;
        Node pri = null;
        while (tmp != null && tmp.data != y) {
            pri = tmp;
            tmp = tmp.next;
        }
        if (tmp == null) {
            return;
        } else {
            if (pri == null) head = head.next;
            else pri.next = tmp.next;
        }
    }

    public void deleteFront() {
        head = head.next;
    }

    public void deleteBack() {
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = null;
    }

    public void insertionSort() {
        //
        if (isEmpty() || head.next == null) return;
        while (head != null) {
            Node tmp = head.next;
            while (tmp != null && tmp.data < head.data) {
                Node next_node = head.next;
                head.next = tmp.next;
                tmp.next = head;
                head = next_node;
            }
        }

    }


    public void printAll() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        SLL sll = new SLL();
        sll.insertAtFront(10);
        sll.insert(70);
        sll.insert(30);
//        sll.insert(100);

        sll.insert(5);
        sll.insert(1);


        sll.insert(100);
        sll.insert(80);


        sll.printAll();
    }
}

