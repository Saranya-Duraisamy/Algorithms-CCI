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
}

public class Test {
    //Time Complexity-O(1); Last node can't be deleted
    static void partitionList(LinkedListNode head, int pivot) {
        LinkedListNode small = head;
        LinkedListNode big = head;
        int smallIndex = 0;
        int bigIndex = 0;
        int temp;
        while(small!= null && big!= null) {
            while (small.next != null && small.data >= pivot) {
                small = small.next;
                smallIndex++;
            }
            while (big.next != null && big.data < pivot) {
                big = big.next;
                bigIndex++;
            }
            if(smallIndex > bigIndex) {
                temp = small.data;
                small.data = big.data;
                big.data = temp;
                big = big.next;
            }
            small = small.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(5);
        head.addToListEnd( 2);
        head.addToListEnd( 3);
        head.addToListEnd( 8);
        head.addToListEnd( 5);
        head.addToListEnd( 10);
        head.addToListEnd( 8);
        head.addToListEnd( 2);
       /* LinkedListNode head = new LinkedListNode(3);
        head.addToListEnd( 5);
        head.addToListEnd( 8);
        head.addToListEnd( 5);
        head.addToListEnd( 10);
        head.addToListEnd( 2);
        head.addToListEnd( 1);*/
        System.out.println("Original Linked List:");
        System.out.println(head.toString());

        partitionList(head, 5);
        System.out.println("Linked List after partitioning");
        System.out.println(head.toString());
    }
}
