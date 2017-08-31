/**
 * Created by ashi on 8/23/17.
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
        Node current = root;
        while(current != null) {
            tail = current.next;
            current = current.next;
        }
        return tail;
    }

}
