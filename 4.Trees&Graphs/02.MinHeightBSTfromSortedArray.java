// Construct Binary Search Tree with minimum height from Sorted array
class Node{
    private int data;
    private Node left;
    private Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    void addLeft(Node node){
        this.left = node;
    }
    void addRight(Node node){
        this.right = node;
    }
    Node getLeft(){
        return this.left;
    }
    Node getRight(){
        return this.right;
    }
    int getData(){
        return this.data;
    }
}
class BST{
    void inorderTraversal(Node node) {
        if(node == null) return;
        System.out.println(node.getData());
        inorderTraversal(node.getLeft());
        inorderTraversal(node.getRight());
    }

    void addNode(Node root, int value){
        Node newNode = new Node(value);
        if(root == null){
            return;
        }
        Node current = root;
        Node parent = root;

        while(current != null){
            parent = current;
            if(current.getData() > value) {
                //Traverse left
                current = current.getLeft();
            }
            else {
                //Traverse right
                current = current.getRight();
            }
        }
        if(parent.getData() > value){
            //Add to left
            parent.addLeft(newNode);
        }
        else {
            //Add to right
            parent.addRight(newNode);
        }
    }

    void constructRecursiveBST(Node root, int[] array, int start, int end){
        if(start > end) {
            return;
        }
        int mid = start+(end-start)/2;
        addNode(root, array[mid]);
        constructRecursiveBST(root, array, start, mid-1 );
        constructRecursiveBST(root, array, mid+1, end );
    }

    Node constructBSTWithMinHeight(int[] array, int start, int end){
        int mid = (end-start)/2;
        Node root = new Node(array[mid]);
        constructRecursiveBST(root, array, start, mid-1);
        constructRecursiveBST(root, array, mid+1, end);
        return root;
    }
}
class Solution {

    public static void main(String args[]) {
        BST bst = new BST();
        int[] array = {1,2,3,4,5,6};//{1,2,3,4,5};
        Node root = bst.constructBSTWithMinHeight(array, 0, array.length-1);
        bst.inorderTraversal(root);
    }
}