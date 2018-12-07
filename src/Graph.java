import java.util.*;
import java.util.LinkedList;

/**
 * Created by ashi on 10/29/18.
 */
public class Graph {
    LinkedList<Integer> adjList[];
    private int V;
    Graph(int numEdges) {
        adjList = new LinkedList[numEdges+1];
        V = numEdges;
        for (int i = 0; i <= V ; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        adjList[u].add(v);
    }

    public void printGraphRepresentation(){
        for (int i = 0; i <= V; i++) {
            System.out.println("Adjacency list of vertex "+ i);
            System.out.print("head-> ");
            for (int j = 0; j < adjList[i].size() ; j++) {
                System.out.print(adjList[i].get(j)+ " ");
            }
            System.out.print("\n");
        }
    }


    public void breadthFirstSearchPrint(int v){
        Queue queue =  new LinkedList<Integer>();
        boolean visited[] = new boolean[V+1];
        visited[v] = true;
        queue.add(v);
        while (!queue.isEmpty()){
            int s = (int) queue.poll();
            System.out.print(s+" ");
            Iterator<Integer> iterator = adjList[s].iterator();
            while (iterator.hasNext()){
                int p = iterator.next();
                if(!visited[p]){
                    visited[p] = true;
                    queue.add(p);
                }
            }
            System.out.print("\n");
        }

    }

    public void topologicalSortUtil(int v, boolean[] visited, Stack stack){
        visited[v] = true;
        Iterator<Integer> iterator = adjList[v].iterator();
        while(iterator.hasNext()){
            int p = iterator.next();
            if(!visited[p]){
                topologicalSortUtil(p,visited,stack);
            }
        }
        stack.push(v);
    }

    public void topologicalSort(){
        boolean visited[] = new boolean[V+1];
        Stack<Integer> stack = new Stack<>();
        for(int i = 1 ;i<=V;i++){
            if(!visited[i]){
                topologicalSortUtil(i,visited, stack);
            }
        }

        while(!stack.empty()){
            System.out.println(stack.pop());
        }

    }

    public void cyclelengthDFSUtil(int v, boolean[] visited, ArrayList<ArrayList<Integer>> setOfVertices, int n, int parent){
        visited[v] = true;

    }

    public void findCycleOfLengthN(int n){
        boolean visited[] = new boolean[V+1];

        ArrayList<ArrayList<Integer>> setOfVertices = new ArrayList<ArrayList<Integer>>(); // a list of the set of vertices. ArrayList provides constant lookup time

        for(int i = 1;i<=V;i++){
//            cyclelengthDFSUtil(i,visited, setOfVertices,n);
        }
    }

    public void dfsUtil(int v,boolean[] visited){
        visited[v] = true;
        System.out.println(v);
        Iterator<Integer> iterator = adjList[v].iterator();
        while(iterator.hasNext()){
            int p = iterator.next();
            if(!visited[p]){
               dfsUtil(p,visited);
            }
        }
    }

    public void printDFS(int v){
        boolean visited[] = new boolean[V+1];
        dfsUtil(v,visited);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
//        graph.addEdge(5,6);
//        graph.addEdge(5,7);
//        graph.addEdge(5,8);
//        graph.addEdge(6,9);
//        graph.addEdge(7,9);
//        graph.addEdge(8,9);





//
//        Graph g = new Graph(4);
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);

        // graph.printGraphRepresentation();
        //   g.breadthFirstSearchPrint(2);
        // graph.printDFS(1);

        graph.printDFS(1);

//        Graph g1 = new Graph(9);
//        g1.addEdge(1,2);
//        g1.addEdge(1,3);
//        g1.addEdge(2,4);
//        g1.addEdge(3,4);
//        g1.addEdge(4,5);
//        g1.addEdge(4,6);
//        g1.addEdge(5,8);
//        g1.addEdge(5,7);
//        g1.addEdge(6,8);
//        g1.addEdge(8,7);
//        g1.addEdge(7,9);
      //  g1.breadthFirstSearchPrint(1);



    }

    // 1 -> 2, 3
    // 2->4
    // 3->4
    // 4->5;
    //5-|__

}
