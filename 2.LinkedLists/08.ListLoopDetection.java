class LinkedListNode{
    int data;
    LinkedListNode next;
    LinkedListNode(int data){
        this.data = data;
        this.next = null;
    }
    void addToListEnd(int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        LinkedListNode node = this;
        while(node.next != null) {
            node = node.next;
        }
        node.next = newNode;
    }
    LinkedListNode addToListHead(int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        newNode.next = this;
        return newNode;
    }
    public String toString() {
        LinkedListNode node = this;
        StringBuilder str = new StringBuilder();
        while(node != null){
            if(this != node){
                str.append("->");
            }
            str.append(node.data);
            node = node.next;
        }
        return str.toString();
    }
    int getListLength(){
        LinkedListNode node = this;
        int length = 0;
        while(node!= null){
            node = node.next;
            length++;
        }
        return length;
    }
}

public class Test {
    static LinkedListNode loopDetection(LinkedListNode head ){
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        if(slow != fast){
            return null;
        }
        fast = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(3);
        head.addToListEnd( 1);
        head.addToListEnd( 5);
        head.addToListEnd( 9);
        head.addToListEnd( 7);
        head.addToListEnd( 2);
        head.addToListEnd( 1);
        head.addToListEnd( 4);
        head.addToListEnd( 6);
        head.addToListEnd( 7);
        head.addToListEnd( 2);
        head.addToListEnd( 1);
        LinkedListNode tail = head;
        while(tail.next != null) tail = tail.next;
        tail.next = head.next.next.next;

        LinkedListNode loopStart = loopDetection(head);
        if(loopStart != null) {
            System.out.println("Loop is detected in list at "+ loopStart.data);
        }
        else{
            System.out.println("No loop is detected in the given list");
        }
    }
}
