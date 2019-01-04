import java.util.EmptyStackException;

/*
 * Implement Queue with two Stacks
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

    public String printStack(StackNode top){
        if(top == null)
            return "";
        return printStack(top.next) + " " + top.data;
    }
    public String toString(){
        return printStack(top);
    }
}
class Queue extends MyStack {
    MyStack addStack;
    MyStack removeStack;

    Queue(){
        addStack = new MyStack();
        removeStack = new MyStack();
    }

    void add(int value){
        addStack.push(value);
    }
    int remove() throws EmptyStackException {
        int value;
        if(removeStack.isEmpty()) {
            while(!addStack.isEmpty()){
                value = addStack.pop();
                removeStack.push(value);
            }
        }
        if(removeStack.isEmpty()){
            throw new EmptyStackException();
        }
        value = removeStack.pop();
        return value;
    }
    public String toString(){
        return "\nAddStack: "+addStack.toString()+"\nRemoveStack: "+removeStack.toString();
    }
}
class Solution {
    public static void main(String args[]) {
        try {
            Queue queue = new Queue();
            queue.add(1000);
            queue.add(10);
            queue.add(100);
            queue.add(1);
            queue.add(-1);
            System.out.println(queue);
            System.out.println("Remove: " + queue.remove());
            System.out.println(queue);
            System.out.println("Remove: " + queue.remove());
            System.out.println("Remove: " + queue.remove());
            queue.add(2);
            System.out.println(queue);
            System.out.println("Remove: " + queue.remove());
            System.out.println("Remove: " + queue.remove());
            queue.add(3);
            System.out.println(queue);
            System.out.println("Remove: " + queue.remove());
            System.out.println(queue);
            System.out.println("Remove: " + queue.remove());
        }
        catch(Exception e){
            System.out.println("Exception: "+ e);
        }
    }
}