package graphfactory;

public class GraphDemo {

    public static void main(String[] args) {
        GraphFactory graphFactory = new GraphFactory();
        
        Graph graph = graphFactory.getGraph("Busca em Largura");        
        
        BFS_Vertex[] vertices = new BFS_Vertex[5];

        for (int i = 0; i < vertices.length; i++) {

            vertices[i] = new BFS_Vertex("" + i);

            graph.addVertex(vertices[i], true);

        }

        for (int i = 0; i < vertices.length - 1; i++) {
            for (int j = i + 1; j < vertices.length; j++) {
                graph.addEdge(vertices[i], vertices[j]);
            }
        }

        //display the initial setup- all vertices adjacent to each other
        for (int i = 0; i < vertices.length; i++) {

            System.out.println(vertices[i]);

            for (int j = 0; j < vertices[i].getNeighborCount(); j++) {

                System.out.println(vertices[i].getNeighbor(j));

            }

            System.out.println();

        }
        BFS bfs = new BFS(graph, vertices[0]);

    }
}   