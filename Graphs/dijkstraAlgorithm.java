package Graphs;

import java.util.*;


class edge_ {

    vertex_ src; 
    vertex_ des;
    int weight; 

   
    edge_(vertex_ src, vertex_ des, int weight) {
        this.src = src;
        this.des = des;
        this.weight = weight;
    }
}


class vertex_{
    

    int index;
    char value;
    boolean isVisited;
    int distance;

    vertex_(){
        index=-1;
        value=' ';
        isVisited=false;
        distance=0;
    }

    vertex_(int index , char value){
        this.index=index;
        this.value=value;
        isVisited=false;
        distance=0;
    }

    @Override
    public String toString() {
        return "vertex{" +
                "index=" + index +
                ", value=" + value +
                ", distance=" + distance +
                '}';
    }

}

class dijkstraAlgorithm{

    ArrayList<ArrayList<edge_>> edges;
    ArrayList<vertex_> vertices;

    Scanner inp = new Scanner(System.in);

    
    dijkstraAlgorithm(int vertices){

        edges=new ArrayList<>(10);
        this.vertices=new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            edges.add(new ArrayList<>());
        }
        
        createGraph();

    }

    void createGraph() {
        vertices.add(new vertex_(0, 'A')); // Vertex 0
        vertices.add(new vertex_(1, 'B')); // Vertex 1
        vertices.add(new vertex_(2, 'C')); // Vertex 2
        vertices.add(new vertex_(3, 'D')); // Vertex 3
        vertices.add(new vertex_(4, 'E')); // Vertex 4
    
        
        edges.get(0).add(new edge_(vertices.get(0), vertices.get(1), 4)); // A -> B
        edges.get(1).add(new edge_(vertices.get(1), vertices.get(0), 4)); // B -> A
    
        edges.get(0).add(new edge_(vertices.get(0), vertices.get(2), 2)); // A -> C
        edges.get(2).add(new edge_(vertices.get(2), vertices.get(0), 2)); // C -> A
    
        edges.get(1).add(new edge_(vertices.get(1), vertices.get(2), 1)); // B -> C
        edges.get(2).add(new edge_(vertices.get(2), vertices.get(1), 1)); // C -> B
    
        edges.get(1).add(new edge_(vertices.get(1), vertices.get(3), 5)); // B -> D
        edges.get(3).add(new edge_(vertices.get(3), vertices.get(1), 5)); // D -> B
    
        edges.get(2).add(new edge_(vertices.get(2), vertices.get(3), 8)); // C -> D
        edges.get(3).add(new edge_(vertices.get(3), vertices.get(2), 8)); // D -> C
    
        edges.get(2).add(new edge_(vertices.get(2), vertices.get(4), 10)); // C -> E
        edges.get(4).add(new edge_(vertices.get(4), vertices.get(2), 10)); // E -> C
    
        edges.get(3).add(new edge_(vertices.get(3), vertices.get(4), 2)); // D -> E
        edges.get(4).add(new edge_(vertices.get(4), vertices.get(3), 2)); // E -> D
    }
    

     void ALGORITHM(char startingVertex){

        vertex_ start =null;

        for(int i=0;i<vertices.size();i++){
            if (vertices.get(i).value==startingVertex) {
                start=vertices.get(i);
            }
        }
    
        if (start==null) {
            System.out.println("Given Vertex Doesnot Exist in Graph");
            return;
            }

        PriorityQueue<vertex_> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));

       pq.add(start);

       System.out.print("Shortest Distance : ");

       while (!pq.isEmpty()) {
        
        vertex_ current = pq.poll();
        if (current.isVisited) continue;
        current.isVisited=true;
        System.out.println("Vertex " + current.value + " and Distance : " + current.distance);

        for (int i = 0; i < edges.get(current.index).size(); i++) {

            vertex_ neighbour = edges.get(current.index).get(i).des;
           edge_ e = edges.get(current.index).get(i);
            int sum=e.weight+current.distance;

            if (!neighbour.isVisited && sum<neighbour.distance) {
                
                neighbour.distance=sum;
                pq.add(neighbour);
            }
        }

       }


     }

    public static void main(String[] args) {
        
       dijkstraAlgorithm g = new dijkstraAlgorithm(5);
       g.ALGORITHM('A');
           
}

}



