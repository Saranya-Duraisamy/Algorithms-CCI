import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/*
 * Implement Stack with min, push, pop operations in O(1) time
 */
class MyStack {
    static class StackNode {
        int data;
        StackNode next;
        StackNode(int data){
            this.data = data;
        }
    }
    StackNode top;

    boolean isEmpty(){
        return (top == null)? true: false;
    }
    void push(int value){
        StackNode node = new StackNode(value);
        int min_value = value;
        if(!isEmpty()) {
            node.next = top;
        }
        else {
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

    String printStack(StackNode head) {
        if(head == null)
            return "";
        return printStack(head.next)+ " " + head.data;
    }

    int peek() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    @Override
    public String toString() {
        return "Stack Data:" +printStack(top);
    }
}
class MinStacks extends MyStack {
    MyStack minStack = new MyStack();
    void push(int value){
        if(minStack.isEmpty() || value < minStack.peek()){
            minStack.push(value);
        }
        super.push(value);
    }
    int pop() throws EmptyStackException {
        if(minStack.isEmpty())
            throw new EmptyStackException();
        int value = super.pop();
        if(value == minStack.peek()) {
            minStack.pop();
        }
        return value;
    }
    int min() throws NoSuchElementException {
        if(minStack.isEmpty()){
            throw new NoSuchElementException();
        }
        return minStack.top.data;
    }
}
class Solution {
    public static void main(String args[]) {
        try {
            MinStacks myStack = new MinStacks();
            myStack.push(1000);
            System.out.println("Min: " + myStack.min());
            myStack.push(10);
            System.out.println("Min: " + myStack.min());
            myStack.push(100);
            System.out.println("Min: " + myStack.min());
            myStack.push(1);
            System.out.println("Min: " + myStack.min());
            System.out.println(myStack);
            myStack.push(-1);
            System.out.println("Min: " + myStack.min());
            System.out.println(myStack);
            System.out.println("Pop: " + myStack.pop());
            System.out.println(myStack);
            System.out.println("Min: " + myStack.min());
            System.out.println(myStack);
            System.out.println("Pop: " + myStack.pop());
            System.out.println(myStack);
            System.out.println("Min: " + myStack.min());
            System.out.println(myStack);
            System.out.println("Pop: " + myStack.pop());
            System.out.println("Pop: " + myStack.pop());
            System.out.println("Pop: " + myStack.pop());
            System.out.println("Pop: " + myStack.pop());
            myStack.push(1000);
            System.out.println(myStack);
        }
        catch(Exception e){
            System.out.println("Exception: "+ e);
        }
    }
}