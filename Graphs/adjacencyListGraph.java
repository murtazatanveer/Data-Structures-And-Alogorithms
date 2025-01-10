 package Graphs;
import java.util.*;


 class edge {

    int src;
    int des;
    boolean isVisited;

    edge(int src, int des){
        this.src=src;
        this.des=des;
        isVisited=false;
    }
    
}

class adjacencyListGraph {

    ArrayList<ArrayList<edge>> graph;
    Scanner inp = new Scanner(System.in);

    
    adjacencyListGraph(int vertices){

        graph=new ArrayList<>(10);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

    }

    void createGraph(){

     

     }



    

    public static void main(String[] args) {
        

        adjacencyListGraph g = new adjacencyListGraph(4);

        g.createGraph();

        
}

}

