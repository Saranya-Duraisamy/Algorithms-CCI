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
    //Time Complexity-O(1); Last node can't be deleted
    static void removeMiddleElement(LinkedListNode middle) {
        if(middle.next != null) {
            middle.data = middle.next.data;
            middle.next = middle.next.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(5);
        head.addToListEnd( 2);
        head.addToListEnd( 3);
        head.addToListEnd( 8);
        head.addToListEnd( 5);
        head.addToListEnd( 10);
        //head.addToListEnd( 8);
        //head.addToListEnd( 2);
        System.out.println("Original Linked List:");
        System.out.println(head.toString());

        LinkedListNode middle = head.next.next.next.next; //head;
        removeMiddleElement(middle);
        System.out.println("Linked List after removing the middle element");
        System.out.println(head.toString());
    }
}
