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

    boolean compareLists(LinkedListNode head) {
        LinkedListNode curHead = this;
        LinkedListNode cmpHead = head;
        while(curHead!=null && cmpHead!=null){
            if(curHead.data != cmpHead.data) {
                return false;
            }
            curHead = curHead.next;
            cmpHead = cmpHead.next;
        }
        if(curHead == null && cmpHead == null){
            return true;
        }
        return false;
    }

    LinkedListNode cloneList(){
        LinkedListNode node = this;
        LinkedListNode newHead = null;
        while(node!= null){
            if(newHead == null){
                newHead = new LinkedListNode(node.data);
            }
            else {
                newHead.addToListEnd(node.data);
            }
            node= node.next;
        }
        return newHead;
    }
}

public class Test {
    static LinkedListNode reverseList(LinkedListNode head ){
        LinkedListNode cur = head;
        LinkedListNode next = null;
        LinkedListNode prev = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {

        LinkedListNode head = new LinkedListNode(3);
        head.addToListEnd( 1);
        head.addToListEnd( 5);
        head.addToListEnd( 1);
        head.addToListEnd( 2);
        System.out.println("Original Linked List:");
        System.out.println(head.toString());

        LinkedListNode reverseHead = head.cloneList();
        reverseHead = reverseList(reverseHead);
        System.out.println("Reversed Linked List:");
        System.out.println(reverseHead.toString());
        /*LinkedListNode reverseHead = new LinkedListNode(3);
        reverseHead.addToListEnd( 1);
        reverseHead.addToListEnd( 5);
        reverseHead.addToListEnd( 1);
        reverseHead.addToListEnd( 3);
        */

        if(head.compareLists(reverseHead)) {
            System.out.println("Given lists are palindrome");
        }
        else {
            System.out.println("Given lists are not palindrome");
        }
    }
}
