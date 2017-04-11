/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author elivelton
 */
public class BFS {
    
    private static BFS_Vertex root;
    private ArrayList<BFS_Vertex> Q = new ArrayList();

    public BFS(Graph graph, BFS_Vertex s) {
        root = s;
        
        Iterator i = graph.getVertices().entrySet().iterator();
        i.next();
        
        while(i.hasNext()){
            Map.Entry par = (Map.Entry) i.next();
            ((BFS_Vertex) graph.getVertex(par.getKey().toString())).setColor(Color.WHITE);
            ((BFS_Vertex) graph.getVertex(par.getKey().toString())).setD(999999999);
            ((BFS_Vertex) graph.getVertex(par.getKey().toString())).setDaddy(null);
        }
        
        root.setColor(Color.GRAY);
        root.setD(0);
        root.setDaddy(null);
        Q.add(root);
    }

    public void BFS_Algorithm(Graph graph, BFS_Vertex s){
        BFS_Vertex u;
        while (!Q.isEmpty()) {            
            u = Q.get(0);
            
            for(Edge e:u.getNeighbors()){
                BFS_Vertex v = (BFS_Vertex)e.getNeighbor(u);
                
                if(v.getColor() == Color.WHITE){
                    v.setColor(Color.GRAY);
                    v.setD(u.getD()+1);
                    v.setDaddy(u);
                    Q.add(v);
                }
            }
            
            u.setColor(Color.BLACK);
        }
    }
}
