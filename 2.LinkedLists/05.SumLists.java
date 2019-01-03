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
}

public class Test {

    static LinkedListNode sumListIterative(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode sum = null;
        int result = 0;
        int carryforward = 0;
        while (head1 != null && head2 != null) {
            result = head1.data + head2.data+carryforward;
            carryforward = result / 10;
            result %= 10;
            if (sum == null) {
                sum = new LinkedListNode(result);
            } else {
                sum.addToListEnd(result);
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        LinkedListNode head = (head1 != null)? head1: ((head2 != null)? head2: null);
        while (head != null) {
            if (sum == null) {
                sum = new LinkedListNode(head.data);
            } else {
                result = head.data+carryforward;
                carryforward = result / 10;
                result %= 10;
                sum.addToListEnd(result);
            }
            head = head.next;
        }
        if(carryforward != 0) {
            sum.addToListEnd(carryforward);
        }
        return sum;
    }

    static LinkedListNode sumListRecursive(LinkedListNode head1, LinkedListNode head2, int carryForward){
        if(head1 == null && head2 == null && carryForward == 0){
            return null;
        }
        int result = carryForward;
        LinkedListNode sum = null;
        if(head1 != null) {
            result += head1.data;
            head1 = head1.next;
        }
        if(head2 != null){
            result += head2.data;
            head2 = head2.next;
        }
        if(result != carryForward) {
            carryForward = result / 10;
            result %= 10;
        }
        else {
            carryForward = 0;
        }

        LinkedListNode ret = sumListRecursive(head1, head2, carryForward);

        if(ret == null){
            sum = new LinkedListNode(result);
        }
        else {
            sum = ret.addToListHead(result);
        }
        return sum;
    }

    public static void main(String[] args) {
        LinkedListNode head1 = new LinkedListNode(7);
        head1.addToListEnd( 1);
        //head1.addToListEnd( 6);
        LinkedListNode head2 = new LinkedListNode(3);
        head2.addToListEnd( 9);
        head2.addToListEnd( 9);
        System.out.println("Original Linked List:");
        System.out.println(head1.toString());
        System.out.println(head2.toString());

        //LinkedListNode sum = sumListIterative(head1, head2);

        LinkedListNode sum = sumListRecursive(head1, head2, 0);
        System.out.println("Linked List after sum");
        System.out.println(sum.toString());
    }
}
