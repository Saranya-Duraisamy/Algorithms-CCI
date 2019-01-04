import java.util.EmptyStackException;

/*
 * Sorting Stack with an additional Stack
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
    int peek() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
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
class Solution {
    static void sortStack(MyStack originalStack){
        MyStack additionalStack = new MyStack();
        while(!originalStack.isEmpty()){
            int value = originalStack.pop();
            int count = 0;
            while(!additionalStack.isEmpty() && additionalStack.peek() > value) {
                originalStack.push(additionalStack.pop());
                count++;
            }
            additionalStack.push(value);
            while(count>0){
                additionalStack.push(originalStack.pop());
                count--;
            }
        }
        while(!additionalStack.isEmpty()){
            originalStack.push(additionalStack.pop());
        }
    }
    public static void main(String args[]) {
        try {
            MyStack originalStack = new MyStack();
            originalStack.push(10);
            originalStack.push(1);
            originalStack.push(100);
            originalStack.push(1000);
            originalStack.push(-1);
            System.out.println(originalStack);
            sortStack(originalStack);
            System.out.println(originalStack);
            originalStack.push(3);
            originalStack.push(2);
            System.out.println(originalStack);
            sortStack(originalStack);
            System.out.println(originalStack);
        }
        catch(Exception e){
            System.out.println("Exception: "+ e);
        }
    }
}