package Graphs;

import java.util.*;

class Edge implements Comparable<Edge>{

    Vertex src;
    Vertex des;
    int wgt;
    boolean isVisited;
    

    Edge(Vertex src, Vertex des, int wgt) {
        this.src = src;
        this.des = des;
        this.wgt = wgt;
        isVisited=false;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.wgt, other.wgt);
    }

}

class Vertex {
    int index;
    char value;
    boolean isVisited;

    Vertex() {
        index = -1;
        value = ' ';
        isVisited = false;
    }

    Vertex(int index, char value) {
        this.index = index;
        this.value = value;
        isVisited = false;
    }
}

class minimumSpanningTree {

    ArrayList<ArrayList<Edge>> edges;
    ArrayList<Vertex> vertices;

    Scanner inp = new Scanner(System.in);

    minimumSpanningTree(int verticesCount) {
        edges = new ArrayList<>(verticesCount);
        this.vertices = new ArrayList<>(verticesCount);

        for (int i = 0; i < verticesCount; i++) {
            edges.add(new ArrayList<>());
        }

        createGraph();
    }

    void primsAlgorithm(char startingVertex){

        Vertex start =null;

        for(int i=0;i<vertices.size();i++){
            if (vertices.get(i).value==startingVertex) {
                start=vertices.get(i);
            }
        }
    
        if (start==null) {
            System.out.println("Given Vertex Doesnot Exist in Graph");
            return;
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int i = 0; i < edges.get(start.index).size(); i++) {
                pq.add(edges.get(start.index).get(i));
                edges.get(start.index).get(i).isVisited=true;
            }
            pq.peek().src.isVisited=true;
            
            while (!pq.isEmpty()) {
                Edge curr = pq.poll();
            
                if (!curr.des.isVisited) {
                    curr.des.isVisited=true;
                    System.out.println(curr.src.value+" --> "+curr.des.value);
                    for(int i=0;i<edges.get(curr.des.index).size();i++){
                        if (!edges.get(curr.des.index).get(i).isVisited) {
                            pq.add(edges.get(curr.des.index).get(i));
                        }
                    }
                }

            }
            

    }

    void createGraph() {
        vertices.add(new Vertex(0, 'G'));
        vertices.add(new Vertex(1, 'F'));
        vertices.add(new Vertex(2, 'E'));
        vertices.add(new Vertex(3, 'A'));
        vertices.add(new Vertex(4, 'B'));
        vertices.add(new Vertex(5, 'D'));
        vertices.add(new Vertex(6, 'C'));

        edges.get(0).add(new Edge(vertices.get(0), vertices.get(4), 10));
        edges.get(0).add(new Edge(vertices.get(0), vertices.get(3), 50));
        edges.get(0).add(new Edge(vertices.get(0), vertices.get(1), 40));

        edges.get(4).add(new Edge(vertices.get(4), vertices.get(2), 35));
        edges.get(4).add(new Edge(vertices.get(4), vertices.get(3), 25));
        edges.get(4).add(new Edge(vertices.get(4), vertices.get(0), 10));

        edges.get(1).add(new Edge(vertices.get(1), vertices.get(6), 30));
        edges.get(1).add(new Edge(vertices.get(1), vertices.get(3), 5));
        edges.get(1).add(new Edge(vertices.get(1), vertices.get(0), 40));

        edges.get(2).add(new Edge(vertices.get(2), vertices.get(3), 55)); // Remove duplicate
        edges.get(2).add(new Edge(vertices.get(2), vertices.get(5), 45));

        edges.get(5).add(new Edge(vertices.get(5), vertices.get(2), 45));
        edges.get(5).add(new Edge(vertices.get(5), vertices.get(3), 15));
        edges.get(5).add(new Edge(vertices.get(5), vertices.get(6), 20));

        edges.get(6).add(new Edge(vertices.get(6), vertices.get(3), 60));
        edges.get(6).add(new Edge(vertices.get(6), vertices.get(1), 30));
        edges.get(6).add(new Edge(vertices.get(6), vertices.get(5), 10));

        edges.get(3).add(new Edge(vertices.get(3), vertices.get(2), 55));
        edges.get(3).add(new Edge(vertices.get(3), vertices.get(4), 25));
        edges.get(3).add(new Edge(vertices.get(3), vertices.get(0), 50));
        edges.get(3).add(new Edge(vertices.get(3), vertices.get(1), 5));
        edges.get(3).add(new Edge(vertices.get(3), vertices.get(6), 60));
        edges.get(3).add(new Edge(vertices.get(3), vertices.get(5), 15));
    }

    public static void main(String[] args) {

        minimumSpanningTree g = new minimumSpanningTree(7);
        g.primsAlgorithm('G');
    }
}
