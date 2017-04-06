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

    public BFS(Graph graph, BFS_Vertex s) {
        root = s;
        ArrayList<BFS_Vertex> Q = new ArrayList();
        
        Iterator i = graph.getVertices().entrySet().iterator();
        i.next();
        
        while(i.hasNext()){
            Map.Entry par = (Map.Entry) i.next();
            ((DFS_Vertex) graph.getVertex(par.getKey().toString())).setColor(Color.WHITE);
            ((DFS_Vertex) graph.getVertex(par.getKey().toString())).setD(999999999);
            ((DFS_Vertex) graph.getVertex(par.getKey().toString())).setDaddy(null);
        }
        
        root.setColor(Color.GRAY);
        root.setD(0);
        root.setDaddy(null);
        Q.add(root);
    }
    
}
