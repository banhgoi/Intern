package OOP.DataStructures;

public class Stack2  {
    SLL sll=new SLL();
    public Stack2() {
    }

    public void push(int x) {
        sll.insertAtFront(x);
    }

    public int top() {
        if (sll.head==null) {
            return -1;
        }else
            return sll.head.data;
    }

    public int pop() {
        if (this.sll==null) {
            return -1;
        } else {
            int result = top();
            sll.deleteFront();
            return result;
        }
    }

    public int pickPop() {
        return top();
    }

    public static void main(String[] args) {
        Stack2 stack = new Stack2();
        stack.push(10);
        stack.push(100);
        stack.push(70);
        stack.push(5);
        stack.push(1);
        stack.push(70);
        stack.push(30);
        stack.pop();
        System.out.println(stack.pickPop());

    }
}