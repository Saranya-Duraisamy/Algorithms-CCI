import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/*
 * Implement Stack with min, push, pop operations in O(1) time
 */
class MyStack {
    private static class StackNode {
        int data;
        int min;
        StackNode next;
        StackNode(int data, int min){
            this.data = data;
            this.min = min;
        }
    }
    private StackNode top;

    boolean isEmpty(){
        return (top == null)? true: false;
    }
    void push(int value){
        StackNode node;
        if(!isEmpty()) {
            node = new StackNode(value, Math.min(value, top.min));
            node.next = top;
        }
        else {
            node = new StackNode(value, value);
            node.next = null;
        }
        top = node;
    }
    int pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int value = top.data;
        top = top.next;
        return value;
    }
    int min() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return top.min;
    }

    String printStack(StackNode head) {
        if(head == null)
            return "";
        return printStack(head.next)+ " " + head.data;
    }

    @Override
    public String toString() {
        return printStack(top);
    }
}
class Solution {
    public static void main(String args[]) {
        MyStack myStack = new MyStack();
        myStack.push(1000);
        System.out.println("Min: "+ myStack.min());
        myStack.push(10);
        System.out.println("Min: "+ myStack.min());
        myStack.push(100);
        System.out.println("Min: "+ myStack.min());
        myStack.push(1);
        System.out.println("Min: "+ myStack.min());
        System.out.println(myStack);
        myStack.push(-1);
        System.out.println("Min: "+ myStack.min());
        System.out.println(myStack);
        System.out.println("Pop: "+ myStack.pop());
        System.out.println(myStack);
        System.out.println("Min: "+ myStack.min());
        System.out.println(myStack);
        System.out.println("Pop: "+ myStack.pop());
        System.out.println(myStack);
        System.out.println("Min: "+ myStack.min());
        System.out.println(myStack);
    }
}