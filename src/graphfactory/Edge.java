package graphfactory;

public class Edge implements Comparable<Edge> {

    private Vertex v1, v2;
    private int weight;

    public Edge(Vertex v1, Vertex v2) {
        this(v1, v2, 1);
    }

    public Edge(Vertex v1, Vertex v2, int weight) {
        this.v1 = (v1.getId().compareTo(v2.getId()) <= 0) ? v1 : v2;
        this.v2 = (this.v1 == v1) ? v2 : v2;
        this.weight = weight;
    }

    public Vertex getNeighbor(Vertex vertex) {
        if (!(vertex.equals(v1) || (vertex.equals(v2)))) {
            return null;
        }
        return (vertex.equals(v1)) ? v2 : v1;
    }

    public Vertex getV1() {
        return this.v1;
    }

    public Vertex getV2() {
        return this.v2;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }

    public int hashCode() {
        return (v1.getId() + v2.getId()).hashCode();
    }

    public String toString() {
        return "({" + v1.getId() + ", " + v2.getId() + "}, " + weight + ")";
    }

    public boolean equals(Object o) {
        if (!(o instanceof Edge)) {
            return false;
        }
        Edge edge = (Edge) o;

        return edge.v1.equals(this.v1) && edge.v2.equals(this.v2);
    }
}
