package OOP.DataStructures;

class Node {
    int data;
    Node next;

    public Node(int x) {
        // data=x; next=null;
        this(x, null);
    }

    public Node(int x, Node nextNode) {
        data = x;
        next = nextNode;
    }
}
