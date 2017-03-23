package graphfactory;

import java.util.*;

public class Graph {

    private HashMap<String, Vertex> vertices;
    private HashMap<Integer, Edge> edges;

    public Graph() {
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();
    }

    public Graph(ArrayList<Vertex> vertices) {
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();

        for (Vertex v : vertices) {
            this.vertices.put(v.getId(), v);
        }
    }

    public boolean addEdge(Vertex v1, Vertex v2) {
        return addEdge(v1, v2, 1);
    }

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

    public boolean containsEdge(Edge edge) {
        if (edge.getV1() == null || edge.getV2() == null) {
            return false;
        }
        return this.edges.containsKey(edge.hashCode());
    }

    public Edge removeEdge(Edge edge) {
        edge.getV1().removeNeighbor(edge);
        edge.getV2().removeNeighbor(edge);
        return this.edges.remove(edge.hashCode());
    }

    public boolean containsVertex(Vertex vertex) {
        return this.vertices.get(vertex.getId()) != null;
    }

    public Vertex getVertex(String id) {
        return vertices.get(id);
    }

    public boolean addVertex(Vertex vertex, boolean overwriteExisting) {
        Vertex current = this.vertices.get(vertex.getId());
        if (current != null) {
            if (!overwriteExisting) {
                return false;
            }

            while (current.getNeighborCount() > 0) {
                this.removeEdge(current.getNeighbor(0));
            }
        }

        vertices.put(vertex.getId(), vertex);
        return true;
    }

    public Vertex removeVertex(String id) {
        Vertex vertex = vertices.remove(id);

        while (vertex.getNeighborCount() > 0) {
            this.removeEdge(vertex.getNeighbor(0));
        }

        return vertex;
    }

    public Set<String> vertexKeys() {
        return this.vertices.keySet();
    }

    public Set<Edge> getEdges() {
        return new HashSet<Edge>(this.edges.values());
    }
}
