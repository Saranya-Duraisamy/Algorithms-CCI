import java.io.*;
import java.util.*;
/*
 * Finding path between given two nodes in a directed graph
 */
enum NodeStatus{UNVISITED, VISITED};
class Node{
    private String id;
    private NodeStatus status;
    private Node[] neighbor;

    Node(String id){
        this.id = id;
        status = NodeStatus.UNVISITED;
    }
    void addNeighbors(Node[] neighbor){
        this.neighbor = new Node[neighbor.length];
        for(int loop = 0; loop<neighbor.length; loop++){
            this.neighbor[loop] = neighbor[loop];
        }
    }
    String getNodeID(){
        return this.id;
    }
    Node[] getNodeNeighbors(){
        return this.neighbor;
    }
    void visitNode(){
        this.status = NodeStatus.VISITED;
    }
    boolean isVisited(){
        if(this.status == NodeStatus.VISITED) {
            return true;
        }
        return false;
    }
    public String toString(){
        StringBuilder sbr = new StringBuilder();
        sbr.append(id+": ");
        for(int loop=0; loop<neighbor.length; loop++){
            sbr.append(neighbor[loop].id+",");
        }
        return sbr.toString();
    }
}
class Graph{
    ArrayList<Node> nodesList;
    Graph(){
        nodesList = new ArrayList<>();
    }
    Node nodeExists(String id){
        for(Node node: nodesList){
            if(id.equals(node.getNodeID())){
                return node;
            }
        }
        return null;
    }
    void addNode(String nodeValue){
        String[] str = nodeValue.split("[ ,:]+");
        Node node = nodeExists(str[0]);
        if(node == null) {
            node = new Node(str[0]);
            nodesList.add(node);
        }
        Node[] neighbor = new Node[str.length-1];
        for(int loop=1; loop<str.length; loop++){
            Node new_node = nodeExists(str[loop]);
            if( new_node == null) {
                new_node = new Node(str[loop]);
                nodesList.add(new_node);
            }
            neighbor[loop - 1] = new_node;
        }
        node.addNeighbors(neighbor);
    }
    public String toString(){
        StringBuilder sbr = new StringBuilder();
        for(Node node: nodesList){
            sbr.append(node.toString()+ "\n");
        }
        return sbr.toString();
    }
}
class Solution {
    static boolean searchPathinGraph(Graph graph, Node start, Node end){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(start);
        start.visitNode();
        while(!queue.isEmpty()){
            Node node = queue.poll();
            Node[] neighbors = node.getNodeNeighbors();
            for(Node neighbor:neighbors) {
                if(!neighbor.isVisited()){
                    if(neighbor == end) {
                        queue.clear();
                        return true;
                    }
                    queue.add(neighbor);
                    neighbor.visitNode();
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Graph graph = new Graph();
        try {
            String str;
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\saran\\OneDrive\\Documents\\Learn&Test\\src\\graph.txt"));
            while ((str = br.readLine()) != null){
                graph.addNode(str);
            }
            br.close();
        }
        catch(IOException e){
            System.out.println("Exception: "+ e);
        }
        System.out.println(graph.toString());
        Node start = graph.nodesList.get(0);
        Node end = graph.nodesList.get(graph.nodesList.size()-1);
        //Node end = graph.nodesList.get(3);
        if(searchPathinGraph(graph, start, end)) {
            System.out.println("Path exist between "+start.getNodeID()+ " and "+end.getNodeID());
        }
        else {
            System.out.println("No path exist between "+start.getNodeID()+ " and "+end.getNodeID());
        }
    }
}