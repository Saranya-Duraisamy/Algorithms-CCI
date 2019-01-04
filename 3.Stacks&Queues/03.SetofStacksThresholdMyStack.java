import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

/*
 * Implement SetofStacks with push, pop operations in O(1) time
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
    int size;

    int stackSize(){
        return size;
    }
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
        size++;
    }
    int pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int value = top.data;
        top = top.next;
        size--;
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
class SetofStacks extends MyStack {
    int threshold;
    int count;
    List<MyStack> stacksSet = new ArrayList<MyStack>();

    SetofStacks(int threshold){
        this.threshold = threshold;
        this.count = 0;
    }

    void push(int value){
        int index = stacksSet.size();
        MyStack stack;
        if(index > 0 && stacksSet.get(index-1).stackSize() < threshold ) {
            stack = stacksSet.get(index-1);
        }
        else {
            stack = new MyStack();
            stacksSet.add(stack);
            count++;
        }
        stack.push(value);
    }
    int pop() throws EmptyStackException {
        if(stacksSet.isEmpty())
            throw new EmptyStackException();
        MyStack stack = stacksSet.get(count-1);
        int value = stack.pop();
        if(stack.stackSize() == 0) {
            stacksSet.remove(count-1);
            count--;
        }
        return value;
    }
    int popAt(int stackIndex) throws EmptyStackException {
        if(stacksSet.isEmpty() || (stackIndex > count))
            throw new EmptyStackException();
        MyStack stack = stacksSet.get(stackIndex-1);
        int value = stack.pop();
        if(stack.stackSize() == 0) {
            stacksSet.remove(count-1);
            count--;
        }
        return value;
    }
    @Override
    public String toString() {
        StringBuilder sbr= new StringBuilder();
        for(int loop=0; loop<stacksSet.size(); loop++){
            sbr.append("\nStack "+ loop +"\n");
            sbr.append(stacksSet.get(loop).toString());
        }
        return sbr.toString();
    }
}
class Solution {
    public static void main(String args[]) {
        try {
            SetofStacks setofStacks = new SetofStacks(2);
            setofStacks.push(1000);
            setofStacks.push(10);
            setofStacks.push(100);
            setofStacks.push(1);
            setofStacks.push(-1);
            System.out.println(setofStacks);
            System.out.println("Pop: " + setofStacks.posp());
            System.out.println(setofStacks);
            System.out.println("Pop: " + setofStacks.pop());
            System.out.println(setofStacks);
            System.out.println("PopAt: " + setofStacks.popAt(1));
            System.out.println(setofStacks);
            //System.out.println("Pop: " + setofStacks.pop());
            setofStacks.push(2);
            System.out.println(setofStacks);
            System.out.println("Pop: " + setofStacks.pop());
            System.out.println("Pop: " + setofStacks.pop());
            setofStacks.push(3);
            System.out.println(setofStacks);
        }
        catch(Exception e){
            System.out.println("Exception: "+ e);
        }
    }
}