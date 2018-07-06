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

//    public void myaddNode(Node node, int key){
//        if(root==null){
//            root = new Node(key);
//            return;
//        } else {
//            if (key < node.key) {
//                if (node.left == null) {
//                    node.left = new Node(key);
//                } else {
//                    myaddNode(node.left, key);
//                }
//            } else {
//                if (node.right == null) {
//                    node.right = new Node(key);
//                } else {
//                    myaddNode(node.right, key);
//                }
//            }
//
//        }
//
//    }


    public void myaddNode(Node node,int key){
        if(root==null){
            root = new Node(key);
        } else {
            if(key<node.key){
                if(node.left==null){
                    node.left = new Node(key);
                } else {
                   myaddNode(node.left,key);
                }
            } else {
                if(node.right==null){
                    node.right = new Node(key);
                } else {
                    myaddNode(node.right,key);
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



   public boolean checkBST(Node node){
    boolean check = checkBSTHelper(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
    return check;
   }

   public boolean checkBSTHelper(Node node, Integer min,Integer max){
       if(node==null){
           return true;
       }
        if(node.key<min || node.key>max){
            return false;
        }

        return (checkBSTHelper(node.left,min,node.key-1)&&checkBSTHelper(node.right,node.key+1,max));
   }

    public void kthSmallest(Node node, int k, Count c){
        if(node==null|| c.count>=k){
            return;
        }
        kthSmallest(node.left,k,c);
        c.count+=1;
        if(k==c.count){
            System.out.println("Kth element is "+node.key);
            return;
        }
        kthSmallest(node.right,k,c);
    }


    public int largestNodeLessThanOrEqualTo(Node node, int key){
        if(node==null){
            return 0;
        }
        if(node.right==null && node.left==null && node.key>key){
            return -1;
        }
        if(node.key<=key && node.right==null || node.key<=key && node.right.key>key){
            return node.key;
        } if(node.key>key){
            return largestNodeLessThanOrEqualTo(node.left,key);
        } else
            return largestNodeLessThanOrEqualTo(node.right,key);

    }

    public void isSequencePresentUtil(Node node, int[] seq, Count index){
        if(node==null){
            return;
        }

        isSequencePresentUtil(node.left,seq,index);
        if(node.key==seq[index.count])
            index.count++;
        if(index.count>=seq.length)
            index.count--;
        isSequencePresentUtil(node.right,seq,index);

    }

    public int isSequencePresent(Node node, int[] seq){
        Count c = new Count();
        isSequencePresentUtil(node,seq,c);
        return c.count;
    }


    Node lca(Node node,int n1,int n2){
        if(n1<=node.key&& node.key<=n2)
        {
            return node;
        } if(node.key>n2){
            return lca(node.left,n1,n2);
        } else if(node.key<n2){
            return lca(node.right,n1,n2);
        }
        return node;
    }

    public Node inorderPredecessor(Node node,int key){
        if(node==null){
            return null;
        }

        if(node.key>key){
            return inorderPredecessor(node.left,key);
        } else if(node.key<key){
            return inorderPredecessor(node.right,key);
        }
        if(node.key==key){
            if(node.right!=null){
                Node temp = node.right;
                while(temp!=null){
                    temp = temp.right;
                }
                return temp;
            } else return node;
        }
        return node;
    }


    public void createInvalidTree(int num){
        root.right.right.right = new Node(num);
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
        //System.out.println(tree.checkBST(tree.root));
//        Count c = new Count();
//        tree.kthSmallest(tree.root,1,c);
        //System.out.println("node value is "+tree.largestNodeLessThanOrEqualTo(tree.root,30));
       // int[] seq = {5,6,15};
//        System.out.println("index is "+tree.isSequencePresent(tree.root,seq));
        //System.out.println("LCA is "+tree.lca(tree.root,1,6).key);
        System.out.println(tree.inorderPredecessor(tree.root,29).key);
    }
}

class Count {
    int count = 0;
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


/*

            15
            /\
           5  29
          /\   \
         1  6   80
*/
