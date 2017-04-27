package graphfactory;

public class GraphDemo {

    public static void main(String[] args) {
        GraphFactory graphFactory = new GraphFactory();
        
        Graph graph = graphFactory.getGraph("Busca Topologica");        
        
        DFS_Vertex[] vertices = new DFS_Vertex[5];

        for (int i = 0; i < vertices.length; i++) {

            vertices[i] = new DFS_Vertex("" + i);

            graph.addVertex(vertices[i], true);

        }

        for (int i = 0; i < vertices.length - 1; i++) {
            for (int j = i + 1; j < vertices.length; j++) {
                graph.addEdge(vertices[i], vertices[j]);
            }
        }

        // Displays the initial setup. All vertices adjacent to each other.
        for (int i = 0; i < vertices.length; i++) {
            System.out.println(vertices[i]);
            for (int j = 0; j < vertices[i].getNeighborCount(); j++) {
                System.out.println(vertices[i].getNeighbor(j));
            }
            System.out.println();
        }
        System.out.println(vertices[2].getNeighbor(0));
        
        Topological top = new Topological(graph);
        //top.displayList();
    }
}   