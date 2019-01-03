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
    static LinkedListNode listIntersection(LinkedListNode head1, LinkedListNode head2){
        int len1 = head1.getListLength();
        int len2 = head2.getListLength();
        int diff = Math.abs(len1-len2);
        if(len1 > len2) {
            while(diff >0) {
                head1 = head1.next;
                diff--;
            }
        }
        if(len2 > len1) {
            while(diff >0) {
                head2 = head2.next;
                diff--;
            }
        }
        while((head1!=null) && (head2!=null)) {
            if(head1 == head2){
                return head1;
            }
            head1= head1.next;
            head2= head2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedListNode head1 = new LinkedListNode(3);
        head1.addToListEnd( 1);
        head1.addToListEnd( 5);
        head1.addToListEnd( 9);
        head1.addToListEnd( 7);
        head1.addToListEnd( 2);
        head1.addToListEnd( 1);
        LinkedListNode head2 = new LinkedListNode(4);
        head2.addToListEnd( 6);
        head1.addToListEnd( 7);
        head1.addToListEnd( 2);
        head1.addToListEnd( 1);
        //head2.next.next = head1.next.next.next.next;
        System.out.println("Original Linked List:");
        System.out.println(head1.toString());
        System.out.println(head2.toString());

        LinkedListNode intersection = listIntersection(head1, head2);
        if(intersection != null) {
            System.out.println("Linked List after intersection");
            System.out.println(intersection.toString());
        }
        else{
            System.out.println("Given lists doesn't intersect");
        }
    }
}
