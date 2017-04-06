package graphfactory;

import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author lucasgb
 */
public class DFS {

    private int time = 0;      

    public DFS(Graph graph){                
        Iterator i = graph.getVertices().entrySet().iterator();
        
        while(i.hasNext()){
          Map.Entry par = (Map.Entry) i.next();
          ((DFS_Vertex) graph.getVertex(par.getKey().toString())).setColor(Color.WHITE);
          ((DFS_Vertex) graph.getVertex(par.getKey().toString())).setDaddy(null);
        }

        time = 0;            
        i = graph.getVertices().entrySet().iterator();

        while(i.hasNext()){
            Map.Entry par = (Map.Entry) i.next();
            if(((DFS_Vertex) graph.getVertex(par.getKey().toString())).getColor() == Color.WHITE){            
                DFS_Visit(graph, graph.getVertex(par.getKey().toString()));
            }
        }
    }
    
    public void DFS_Visit(Graph graph, Vertex vertex){
        time += 1;
        DFS_Vertex u = (DFS_Vertex) vertex;
        u.setD(time);
        u.setColor(Color.GRAY);                

        for(Edge e : u.getNeighbors()){
            DFS_Vertex v = (DFS_Vertex) e.getNeighbor(u);
            if(v.getColor() == Color.WHITE){
                v.setDaddy(vertex);
                DFS_Visit(graph, v);
            }
        }
        u.setColor(Color.BLACK);
        time += 1;
        u.setf(time);                   
    }        
}