package graphfactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lucasgb
 */
public class DFS_Graph implements Graph{
    private HashMap<String, DFS_Vertex> vertices;
    private HashMap<Integer, Edge> edges;

    public DFS_Graph() {
        this.vertices = new HashMap<String, DFS_Vertex>();
        this.edges = new HashMap<Integer, Edge>();
    }   

    @Override
    public void Graph(ArrayList<? extends Vertex> vertices) {
        this.vertices = new HashMap<String, DFS_Vertex>();
        this.edges = new HashMap<Integer, Edge>();
        
        for(Vertex v : vertices){
            this.vertices.put(v.getId(), (DFS_Vertex) v);
        }
    }

    @Override
    public boolean addEdge(Vertex v1, Vertex v2) {
        return addEdge(v1, v2, 1);        
    }

    @Override
    public boolean addEdge(Vertex v1, Vertex v2, int weight) {
        if (v1.equals(v2)) {
            return false;
        }

        Edge edge = new Edge(v1, v2, weight);
        if (edges.containsKey(edge.hashCode())) {
            return false;
        } else if (v1.containsNeighbor(edge) || v2.containsNeighbor(edge)) {
            return false;
        }

        edges.put(edge.hashCode(), edge);
        v1.addNeighbor(edge);
        v2.addNeighbor(edge);
        return true;

    }

    @Override
    public boolean containsEdge(Edge edge) {
        if (edge.getV1() == null || edge.getV2() == null) {
            return false;
        }
        return this.edges.containsKey(edge.hashCode());

    }

    @Override
    public Edge removeEdge(Edge edge) {
        edge.getV1().removeNeighbor(edge);
        edge.getV2().removeNeighbor(edge);
        return this.edges.remove(edge.hashCode());

    }

    @Override
    public boolean containsVertex(Vertex vertex) {
        return this.vertices.get(vertex.getId()) != null;
    }

    @Override
    public Vertex getVertex(String id) {        
        return vertices.get(id);
    }

    @Override
    public boolean addVertex(Vertex vertex, boolean overwriteExisting) {
        DFS_Vertex current = this.vertices.get(vertex.getId());
        if (current != null) {
            if (!overwriteExisting) {
                return false;
            }

            while (current.getNeighborCount() > 0) {
                this.removeEdge(current.getNeighbor(0));
            }
        }
        
        vertices.put(vertex.getId(), (DFS_Vertex) vertex);
        return true;

    }

    @Override
    public Vertex removeVertex(String id) {
        DFS_Vertex vertex = vertices.remove(id);

        while (vertex.getNeighborCount() > 0) {
            this.removeEdge(vertex.getNeighbor(0));
        }

        return vertex;        
    }

    @Override
    public Set<String> vertexKeys() {
        return this.vertices.keySet();
    }

    @Override
    public Set<Edge> getEdges() {
        return new HashSet<Edge>(this.edges.values());
    }

    @Override
    public HashMap getVertices() {
        return vertices;        
    }
    
}