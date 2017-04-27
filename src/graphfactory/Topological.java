package graphfactory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author lucasgb
 */
public class Topological {
    
    private int time;
    private LinkedList<DFS_Vertex> list;
    
    public Topological(Graph graph){                
        Iterator i = graph.getVertices().entrySet().iterator();
        time = 0;
        list = new LinkedList<DFS_Vertex>();
        
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
                Topological_Visit(graph, graph.getVertex(par.getKey().toString()));
            }
        }
    }
    
    public LinkedList<DFS_Vertex> Topological_Visit(Graph graph, Vertex vertex){
        time += 1;
        DFS_Vertex u = (DFS_Vertex) vertex;
        u.setD(time);
        u.setColor(Color.GRAY);                

        try{
        for(Edge e : u.getNeighbors()){
            DFS_Vertex v = (DFS_Vertex) e.getNeighbor(u);
            if(v.getColor() == Color.WHITE){
                v.setDaddy(vertex);
                Topological_Visit(graph, v);
            } else if(v.getColor() == Color.GRAY){
                throw new Exception("O grafo deve ser acíclico!");                
            }
        }
        u.setColor(Color.BLACK);
        time += 1;
        u.setf(time);               
        list.add(u);        
        return list;
        
        } catch (Exception e){
            System.out.println(e);
            System.exit(0);
        }
        return null;
    }   
    
    public void displayList(){
        for(DFS_Vertex v : list){
            System.out.println(v.getId());
        }
    }
}