import java.util.List;
import java.util.ArrayList;

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
    //Time Complexity-O(N); N-#Nodes in Linked List
    static void removeDuplicatesUsingArrayList(LinkedListNode head){
        LinkedListNode node = head;
        LinkedListNode prev = head;
        List<Integer> list = new ArrayList<Integer>();
        while(node != null){
            if(list.contains(node.data)){
                prev.next = node.next;
            }
            else {
                list.add(node.data);
                prev = node;
            }
            node = node.next;
        }
    }
    //Time Complexity-O(N^2); N-#Nodes in Linked List
    /*static void removeDuplicatesWithTwoPtrs(LinkedListNode head){
        LinkedListNode slow = head;
        while(slow != null){
            LinkedListNode fast = slow;
            while(fast != null){
                if(fast.next != null && fast.next.data == slow.data) {
                    fast.next = fast.next.next;
                }
                fast = fast.next;
            }
            slow = slow.next;
        }
    }*/
    static void removeDuplicatesWithTwoPtrs(LinkedListNode head){
        LinkedListNode slow = head;
        while(slow != null){
            LinkedListNode fast = slow;
            while(fast.next != null){
                if( fast.next.data == slow.data) {
                    fast.next = fast.next.next;
                }
                else {
                    fast = fast.next;
                }
            }
            slow = slow.next;
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
        System.out.println("Original Linked List:");
        System.out.println(head.toString());

        //removeDuplicatesUsingArrayList(head);

        //System.out.println("Linked List after Duplicates Removal:");
        //System.out.println(head.toString());

        removeDuplicatesWithTwoPtrs(head);

        System.out.println("Linked List after Duplicates Removal:");
        System.out.println(head.toString());

    }
}
