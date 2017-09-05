/**
 * Created by ashi on 8/23/17.
 * Problems solved in this Class:
 *      1. Detect loop in a Linked List
 *      2. Reverse a Linked List
 */
public class LinkedList {
    private Node root;

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void addNode(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node tail = getTail();
            tail.next = new Node(value);
        }
    }

    public Node getTail() {
        Node tail = root;
        while(tail.next!= null) {
            tail = tail.next;
        }
        return tail;
    }

    public void addLoop(int value){
        addNode(5);
        Node loopNode = getTail();
        loopNode.next = root.next;
    }

    public void populateLinkedList(){
        addNode(1);
        addNode(2);
        addNode(3);
        addNode(4);
       // addLoop(5); //Make 5 point to 2!
    }

    public void printLinkedList(){
        Node node = root;
        while(node!=null){
            System.out.println(node.value);
            node = node.next;
        }
    }

    /*
        This method uses Floyd's loop detection algorithm
        There is a slow pointer and a Fast pointer.
        The slow pointer increments by one and the fast pointer by two.
        According to Floyd's theorem, if there is a cycle, the pointers will collide at some given point.
        We return that there is indeed a loop in case this happens!
     */

    public boolean findLoop () {
        Node slowRunner = root;
        Node FastRunner = root;
        while(slowRunner!=null){
        slowRunner = slowRunner.next;
        if(FastRunner.next.next!=null) {
            FastRunner = FastRunner.next.next;
            if (slowRunner == FastRunner) {
                return true;
            }
        } else {
            return false;
        }
        }
        return false;
    }

    public void reverseLinkedList(){
        Node currentNode = root;
        Node previousNode = null;
        Node nextNode = null;
        while(currentNode!=null){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        root = previousNode;
        printLinkedList();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.populateLinkedList();
//        linkedList.printLinkedList();
//        if(linkedList.findLoop()){
//            System.out.println("There is a loop!");
//        } else {
//            System.out.println("There is no loop!");
//        }
        linkedList.reverseLinkedList();
    }

}
