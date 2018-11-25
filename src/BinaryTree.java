import java.util.ArrayList;

/**
 * Created by ashi on 11/1/18.
 */
public class BinaryTree {

   NodeBTree root;

   public BinaryTree(int key){
       root = new NodeBTree(key);
   }

   public BinaryTree(){
       root = null;
   }

   public void preOrder(NodeBTree node){
       if(node==null) {
           return;
       }
       System.out.println(node.key);
       preOrder(node.left);
       preOrder(node.right);
   }

    void printVector(ArrayList v, int i)
    {
        for (int j=i; j<v.size(); j++)
            System.out.print(v.get(j)+" ");
        System.out.print("\n");
    }

   public void printKPathUtil(NodeBTree node, ArrayList path, int k){
       if(node==null){
           return;
       }
       path.add(node.key);
       printKPathUtil(node.left,path,k);
       printKPathUtil(node.right,path,k);

       int f = 0;
       for (int j=path.size()-1; j>=0; j--)
       {
           f += (int) path.get(j);

           // If path sum is k, print the path
           if (f == k)
               printVector(path, j);
       }

       path.remove(path.size()-1);

   }


    // A wrapper over printKPathUtil()
    void printKPath(NodeBTree root, int k)
    {
        ArrayList path = new ArrayList();
        printKPathUtil(root, path, k);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new NodeBTree(1);
        binaryTree.root.left = new NodeBTree(3);
        binaryTree.root.right = new NodeBTree(-1);
        binaryTree.root.left.left = new NodeBTree(2);
        binaryTree.root.left.right = new NodeBTree(1);
        binaryTree.root.left.right.left = new NodeBTree(1);

        binaryTree.root.right.left = new NodeBTree(4);
        binaryTree.root.right.left.left = new NodeBTree(1);
        binaryTree.root.right.left.right = new NodeBTree(2);
        binaryTree.root.right.right = new NodeBTree(5);
        binaryTree.root.right.right.right = new NodeBTree(6);

       // binaryTree.preOrder(binaryTree.root);

        binaryTree.printKPath(binaryTree.root,5);
    }
}

class NodeBTree{

    int key;
    NodeBTree left;
    NodeBTree right;

    NodeBTree(int k){
        key = k;
    }
}
