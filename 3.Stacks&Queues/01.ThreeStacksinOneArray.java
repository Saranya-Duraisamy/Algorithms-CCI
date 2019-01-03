/*
 * Implement 3 stacks using a single array
 * Naive implementation- split arary into three divisions
 */
class Solution {
    static class Stack{
        int[] array;
        int[] stackStart;
        int[] stackTop;
        int[] stackCapacity;
        Stack(int arraySize, int stackCount){
            array = new int[arraySize];
            stackTop = new int[stackCount];
            stackStart = new int[stackCount];
            stackCapacity = new int[stackCount];
            stackStart[0] = 0;
            for(int i=0; i<stackCount; i++){
                stackCapacity[i] = arraySize/stackCount;
                if(arraySize%stackCount > i) {
                    stackCapacity[i]++;
                }
                if(i < stackCount-1) {
                    stackStart[i + 1] = stackStart[i] + stackCapacity[i];
                }
                stackTop[i] = -1;
            }
        }
        void push(int stackNum, int value) {
            if(isFull(stackNum)) {
                System.out.print("Stack full!!!");
                return;
            }
            if(isEmpty(stackNum)) {
                stackTop[stackNum] = stackStart[stackNum];
            }
            else{
                stackTop[stackNum]++;
            }
            array[stackTop[stackNum]] = value;
        }
        int pop(int stackNum) {
            int value;
            if(isEmpty(stackNum)) {
                System.out.print("Stack is Empty!!!");
            }
            value = array[stackTop[stackNum]];
            if(stackTop[stackNum] == stackStart[stackNum]) {
                stackTop[stackNum] = -1;
            }
            else {
                stackTop[stackNum]--;
            }
            return value;
        }
        int peek(int stackNum){
            if(isEmpty(stackNum)) {
                System.out.print("Stack is Empty!!!");
            }
            return array[stackTop[stackNum]];
        }
        boolean isEmpty(int stackNum) {
            return (stackTop[stackNum] == -1)? true: false;
        }
        boolean isFull(int stackNum) {
            return (stackTop[stackNum]-stackStart[stackNum] == stackCapacity[stackNum]-1)? true: false;
        }

        @Override
        public String toString() {
            StringBuilder sbr = new StringBuilder();
            for(int i=0; i<stackTop.length; i++) {
                sbr.append("\nStack "+ i + ":\n");
                for(int j=stackStart[i]; j<=stackTop[i]; j++) {
                    sbr.append(array[j]+ " ");
                }
            }
            return sbr.toString();
        }
    }

    public static void main(String args[]) {
        int stackCount = 3;
        int arraySize = 10;
        Stack stack = new Stack(arraySize, stackCount);
        stack.push(0,1);
        stack.push(1,2);
        stack.push(2,3);
        stack.push(0,4);
        stack.push(1,5);
        stack.push(2,6);
        stack.push(0,7);
        stack.push(1,8);
        stack.push(2,9);
        stack.push(0,10);
        System.out.println(stack);
        System.out.println(stack.peek(0));
        System.out.println(stack.peek(1));
        System.out.println(stack.peek(2));
        stack.pop(0);
        stack.pop(1);
        System.out.println(stack);
    }
}