/**
 * Created by ashi on 8/23/17.
 */
public class TreeQuestions {
    Node root;
    static int num;
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

    public void myaddNode(Node node, int key){
        if(root==null){
            root = new Node(key);
            return;
        } else {
            if (key < node.key) {
                if (node.left == null) {
                    node.left = new Node(key);
                } else {
                    myaddNode(node.left, key);
                }
            } else {
                if (node.right == null) {
                    node.right = new Node(key);
                } else {
                    myaddNode(node.right, key);
                }
            }

        }

    }

    public int getHeight(Node node){
//        System.out.println("what"+node.key);
        if(node==null){
            return 0;
        }
        if(node.right==null && node.left==null) {
            return 1;
        }

        return 1+Math.max(getHeight(node.left),getHeight(node.right));
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

        //System.out.println("went"+node.key);

        inOrder(node.left);
        System.out.println(node);
        inOrder(node.right);
    }

    public void inOrderKthSmallest(Node node){

        if(node==null){
            return;
        }

        //System.out.println("went"+node.key);

        inOrder(node.left);
        System.out.println(node);
        inOrder(node.right);
    }

    public boolean checkBST(Node node){
        if (node==null){
            return true;
        }
        if(node.right==null&&node.left==null){
            if(node.key>num){
                num = node.key;
                return true;
            } else {
                return false;
            }
        }
        checkBST(node.left);
        checkBST(node.right);

       return false;
    }

    public void createInvalidTree(int num){
        root.right.right = new Node(num);
    }

    public static void main(String[] args) {
        TreeQuestions tree = new TreeQuestions();
        tree.myaddNode(tree.root, 15);
        tree.myaddNode(tree.root, 5);
        tree.myaddNode(tree.root,6);
        tree.myaddNode(tree.root,29);
        tree.myaddNode(tree.root,80);
        tree.myaddNode(tree.root,1);
        //tree.createInvalidTree(58);
        tree.inOrder(tree.root);
        //System.out.println(tree.getHeight(tree.root));

        System.out.println("yes "+tree.checkBST(tree.root));

        //tree.preOrder(tree.root);

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
