package graphfactory;

public class GraphFactory{
    
    public Graph getGraph(String graphType){
        if(graphType == null){
            return null;
        } else if(graphType.equalsIgnoreCase("Busca de Profundidade")){
            return new DFS_Graph();
        }
        return null;
    }
	
}
