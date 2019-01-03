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
    static LinkedListNode KtoLastElement(LinkedListNode head, int k){
        LinkedListNode newHead = head;
        LinkedListNode runner = head;
        for(int i=1; i<=k; i++) {
            runner = runner.next;
        }
        while(runner != null){
            runner = runner.next;
            newHead = newHead.next;
        }
        return newHead;
    }

    //Wrapper class to pass integer by reference
    static class Index {
        public int value;
        Index() {
            value = 0;
        }
    }
    //Time Complexity-O(N); N-#Nodes in Linked List
    static LinkedListNode KtoLastElementRecursive(LinkedListNode head, int k, Index cur) {
        if (head == null) {
            return null;
        }
        LinkedListNode ret = KtoLastElementRecursive(head.next, k, cur);
        cur.value += 1;
        if (cur.value == k) {
            System.out.print(head.data);
            return head;
        }
        return ret;
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

        int k = 2;
        LinkedListNode newHead = KtoLastElement(head, k);
        System.out.println("Linked List "+ k + "th element from last");
        System.out.println(newHead.toString());

        System.out.println("Original Linked List:");
        System.out.println(head.toString());

        Index current = new Index();
        LinkedListNode node  = KtoLastElementRecursive(head, k, current);
        System.out.println("Linked List "+ k + "th element from last");
        System.out.println(node.toString());
    }
}
