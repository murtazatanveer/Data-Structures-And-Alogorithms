package Graphs;
import java.util.*;


 class edge {

    vertex src;
    vertex des;

    edge(vertex src, vertex des){
        this.src=src;
        this.des=des;   
    }
    
}

class vertex{

    int index;
    char value;
    boolean isVisited;

    vertex(){
        index=-1;
        value=' ';
        isVisited=false;
    }

    vertex(int index , char value){
        this.index=index;
        this.value=value;
        isVisited=false;
    }

}

class adjacencyListGraph {

    ArrayList<ArrayList<edge>> edges;
    ArrayList<vertex> vertices;

    Scanner inp = new Scanner(System.in);

    
    adjacencyListGraph(int vertices){

        edges=new ArrayList<>(10);
        this.vertices=new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            edges.add(new ArrayList<>());
        }
        
        createGraph();

    }

    void createGraph(){

        vertices.add(new vertex(0, 'G'));
        vertices.add(new vertex(1, 'F'));
        vertices.add(new vertex(2, 'E'));
        vertices.add(new vertex(3, 'A'));
        vertices.add(new vertex(4, 'B'));
        vertices.add(new vertex(5, 'D'));
        vertices.add(new vertex(6, 'C'));

        edges.get(0).add(new edge(vertices.get(0), vertices.get(4)));
        edges.get(0).add(new edge(vertices.get(0), vertices.get(3)));
        edges.get(0).add(new edge(vertices.get(0), vertices.get(1)));

        edges.get(4).add(new edge(vertices.get(4), vertices.get(2)));
        edges.get(4).add(new edge(vertices.get(4), vertices.get(3)));
        edges.get(4).add(new edge(vertices.get(4), vertices.get(0)));

        edges.get(1).add(new edge(vertices.get(1), vertices.get(6)));
        edges.get(1).add(new edge(vertices.get(1), vertices.get(3)));
        edges.get(1).add(new edge(vertices.get(1), vertices.get(0)));

        edges.get(2).add(new edge(vertices.get(2), vertices.get(4)));
        edges.get(2).add(new edge(vertices.get(2), vertices.get(3)));
        edges.get(2).add(new edge(vertices.get(2), vertices.get(5)));

        edges.get(5).add(new edge(vertices.get(5), vertices.get(2)));
        edges.get(5).add(new edge(vertices.get(5), vertices.get(3)));
        edges.get(5).add(new edge(vertices.get(5), vertices.get(6)));

        edges.get(6).add(new edge(vertices.get(6), vertices.get(3)));
        edges.get(6).add(new edge(vertices.get(6), vertices.get(1)));
        edges.get(6).add(new edge(vertices.get(6), vertices.get(5)));

        edges.get(3).add(new edge(vertices.get(3), vertices.get(2)));
        edges.get(3).add(new edge(vertices.get(3), vertices.get(4)));
        edges.get(3).add(new edge(vertices.get(3), vertices.get(0)));
        edges.get(3).add(new edge(vertices.get(3), vertices.get(1)));
        edges.get(3).add(new edge(vertices.get(3), vertices.get(6)));
        edges.get(3).add(new edge(vertices.get(3), vertices.get(5)));


     }


     void BFS(char startingVertex){

        vertex start =null;

        for(int i=0;i<vertices.size();i++){
            if (vertices.get(i).value==startingVertex) {
                start=vertices.get(i);
            }
        }
    
        if (start==null) {
            System.out.println("Given Vertex Doesnot Exist in Graph");
            return;
            }
            
            Queue<vertex> q = new LinkedList<>();
            q.add(start);
            start.isVisited=true;
            System.out.print("\nVertices : ");

            while (!q.isEmpty()) {
                
                vertex current = q.remove();

                System.out.print(current.value+"\t");

                for (int i = 0; i < edges.get(current.index).size(); i++) {

                    vertex neighbour = edges.get(current.index).get(i).des;

                    if (!neighbour.isVisited) {

                        q.add(neighbour);
                        neighbour.isVisited=true;
                        
                    }
                }

            }

     }

    public static void main(String[] args) {
        
        adjacencyListGraph g = new adjacencyListGraph(7);
        
      g.BFS('A');
}

}

