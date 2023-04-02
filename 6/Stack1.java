package OOP.DataStructures;

public class Stack1 extends SLL {

    public Stack1() {
    }

    public void push(int x) {
        insertAtFront(x);
    }

    public int top() {
        if (this.head==null) {
            return -1;
        }else
        return head.data;
    }

    public int pop() {
        if (this.head==null) {
            return -1;
        } else {
            int result = top();
            deleteFront();
            return result;
        }
    }

    public int pickPop() {
        return top();
    }

    public static void main(String[] args) {
        Stack1 stack = new Stack1();
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
