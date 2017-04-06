package graphfactory;

import java.util.*;

public interface Graph {
    
    public void Graph(ArrayList<? extends Vertex> vertices); 
    
    public boolean addVertex(Vertex vertex, boolean overwriteExisting);

    public Vertex removeVertex(String id);
    
    public boolean addEdge(Vertex v1, Vertex v2);   
    
    public boolean addEdge(Vertex v1, Vertex v2, int weight);
    
    public Edge removeEdge(Edge edge);
        
    public boolean containsEdge(Edge edge);

    public boolean containsVertex(Vertex vertex);

    public Vertex getVertex(String id);

    public Set<Edge> getEdges();
    
    public Set<String> vertexKeys();
    
    public HashMap getVertices();

}