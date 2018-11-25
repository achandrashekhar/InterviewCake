/**
 * Created by ashi on 8/23/17.
 * Problems solved in this Class:
 *      1. Detect loop in a Linked List
 *      2. Reverse a Linked List
 *      3. Find Kth to last Node
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

    public Node getRoot(){
        return root;
    }

    class LinkedNode {
        int val;
        LinkedNode next;

        public LinkedNode(int val){
            val = val;
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

    public Node getGenericTail(Node node){
        Node tail = node;
        while(tail.next!=null){
            tail= tail.next;
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
        addNode(5);
        addNode(6);
        addNode(7);
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

    /*
        This approach uses a 'stick'. Let's say, your stick is K nodes wide. you keep incrementing the end of these
        sticks until the right end of your stick hits the last node.
        You will then just return the value at the left end of the stick, since the stick is k nodes wide!
     */

    public int kthToLastNode(int k){
        Node rightEnd = root;
        Node leftEnd =  root;
        for (int i = 0; i < k; i++) {
            rightEnd = rightEnd.next; //build the stick to be k nodes away from the root
        }
        while(rightEnd!=null){ //keep advancing the stick forward until you hit the end
            leftEnd = leftEnd.next;
            rightEnd = rightEnd.next;
        }
        return leftEnd.value;

    }

    public void printRecursiveLinkedList(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.value+ " ");
        printRecursiveLinkedList(node.next);
    }

    public void recursiveReverseLinkedList(Node node){
       if(node.next==null){
          root = node;
          return;
       }
        recursiveReverseLinkedList(node.next);
        Node tempNode = node.next;
        tempNode.next = node;
        node.next=null;

    }


    public Node addTwoNumbers(Node l1, Node l2) {
        Node result = null;
        Node temp = result;
        int carryOver = 0;
        Node head1 = l1;
        Node head2 = l2;
        while(head1!=null && head2!=null){
            Node newNode = new Node(head1.value+head2.value+carryOver);
            if(result==null){
                result = newNode;
                temp = result.next;
            }
            else temp = getGenericTail(result);
            temp = newNode;
            temp = temp.next;
        }
        return result;
    }



    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.populateLinkedList();
      //  linkedList.printRecursiveLinkedList(linkedList.root);
        linkedList.recursiveReverseLinkedList(linkedList.root);
        linkedList.printRecursiveLinkedList(linkedList.root);
//        linkedList.printLinkedList();
//        if(linkedList.findLoop()){
//            System.out.println("There is a loop!");
//        } else {
//            System.out.println("There is no loop!");
//        }
        //linkedList.reverseLinkedList();
        //System.out.println(linkedList.kthToLastNode(3));
    }

}