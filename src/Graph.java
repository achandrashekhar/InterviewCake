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

    public int numberOfPathUtils(int v) {
        if(adjList[v].size()>0){
        Iterator<Integer> iterator = adjList[v].iterator();
            int totalChildren = 0;
            while (iterator.hasNext()) {
                totalChildren+=numberOfPathUtils(iterator.next());
            }
            return  totalChildren;
        }
        return 1;
    }

    // Given a non-cyclic directed graph, find all possible paths to the sink/node

    /**
     * Iteratively call for all children of the node,
     * When a node with no children is found, you simply return 1 saying there is only one
     * possible path between parent and current node (sinks won't have a size>0 in their adjacency list representation)
     * if this problem was tweaked to count minimum number of paths from source to sink, don't add up the total number of childre, instead,
     * add them to some sort of heap, and do an extract minimum or keep updating the current max, and return minimum.
     * @param v starting edge
     * @return
     */
    public int findNumerofPaths(int v){
       int n =  numberOfPathUtils(v);
       return n;
    }

    /**
     * Found this on career cup
     * Given a graph with exactly N-1 edges and N Vertices, given a pair of 3 queries,
     * where each query(u,v) is a path from u, v
     * Find out how many times each of these vertices is visited while finding path in
     * the 3 given queries.
     * @param visited array of visited vertices
     * @param u start vertex
     * @param v end vertex
     */

    public void findHowManyVisits(int[] visited, int u, int v){
       if(adjList[u].element()==v){
           return;
       }
        Iterator<Integer> iterator = adjList[u].iterator();
        while(iterator.hasNext()) {
            int p = iterator.next();
            visited[p]++;
            findHowManyVisits(visited,p,v);
        }
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

        Graph g5 = new Graph(5);
        g5.addEdge(1,2);
        g5.addEdge(1,3);
        g5.addEdge(2,4);
        g5.addEdge(4,3);
        g5.addEdge(3,5);
        g5.addEdge(1,5);
        g5.addEdge(2,5);
        //System.out.println(g5.findNumerofPaths(1)); //4

        Graph g6 = new Graph(5);
        g6.addEdge(1,2);
        g6.addEdge(2,5);
        g6.addEdge(1,3);
        g6.addEdge(4,3);
       // System.out.println(g6.findNumerofPaths(1)); //2





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

       // graph.printDFS(1);

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

        Graph g7 = new Graph(5);
        g7.addEdge(1,0);
        g7.addEdge(0,2);
        g7.addEdge(2,3);
        g7.addEdge(3,4);


        int[] visited = new int[g7.V]; // Lol this ain't a good idea, but there's no  time for vulnerability, life is too short
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
        g7.findHowManyVisits(visited,1,2);
        g7.findHowManyVisits(visited,1,3);
        g7.findHowManyVisits(visited,1,4);

        for (int i = 0; i < visited.length; i++) {
            System.out.println(visited[i]);
        }




    }

    // 1 -> 2, 3
    // 2->4
    // 3->4
    // 4->5;
    //5-|__

}
