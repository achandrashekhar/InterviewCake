/**
 * Created by ashi on 8/23/17.
 */
public class TreeQuestions {
    Node root;
    public void addNode(int key){
        Node node = new Node(key);
        if(root==null) {
            root = node;
        } else {
            Node focusNode = root;
            Node parent;
            while(true){
                parent = focusNode;
                if(key<focusNode.key){
                    focusNode = focusNode.left;
                    if(focusNode==null){
                        parent.left = node;
                        return;
                    }
                } else {
                    focusNode = focusNode.right;
                    if(focusNode==null){
                        parent.right = node;
                        return;
                    }
                }
            }
        }
    }

    public void preOrder(Node node){
        if(node==null){
            return;
        }

        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node){
        if(node==null){
            return;
        }

        inOrder(node.left);
        System.out.println(node);
        inOrder(node.right);
    }

    public static void main(String[] args) {
        TreeQuestions tree = new TreeQuestions();
        tree.addNode(15);
        tree.addNode(5);
        tree.addNode(6);
        tree.addNode(29);
        tree.addNode(80);
        tree.addNode(1);
        //tree.inOrder(tree.root);
        tree.preOrder(tree.root);

    }
}

class Node {

    int key;
    Node right;
    Node left;

    Node(int key){
        this.key = key;
    }

    public String toString(){
        return "key :"+key;
    }
}
