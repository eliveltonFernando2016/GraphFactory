package graphfactory;

import java.util.ArrayList;

public class Vertex {
    
    private ArrayList<Edge> neighborhood;
    private String id;    

    public Vertex(String id) {
        this.id = id;
        this.neighborhood = new ArrayList<Edge>();
    }

    public void addNeighbor(Edge edge) {
        if (this.neighborhood.contains(edge)) {
            return;
        }
        this.neighborhood.add(edge);
    }

    public Edge removeNeighbor(int index) {
        return this.neighborhood.remove(index);
    }

    public void removeNeighbor(Edge edge) {
        this.neighborhood.remove(edge);
    }

    public boolean containsNeighbor(Edge edge) {
        return this.neighborhood.contains(edge);
    }

    public int getNeighborCount() {
        return this.neighborhood.size();
    }

    public Edge getNeighbor(int index) {
        return this.neighborhood.get(index);
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return "Vertice " + id;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean equals(Object o) {
        if (!(o instanceof Vertex)) {
            return false;
        }
        Vertex vertex = (Vertex) o;

        return this.id.equals(vertex.id);
    }

    public ArrayList<Edge> getNeighbors() {
        return new ArrayList<Edge>(this.neighborhood);
    }          
}