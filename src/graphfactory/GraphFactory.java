package graphfactory;

public class GraphFactory{
    
    public Graph getGraph(String graphType){
        if(graphType == null){
            return null;
        } else if(graphType.equalsIgnoreCase("Busca de Profundidade")){
            return new DFS_Graph();
        } else if(graphType.equalsIgnoreCase("Busca em Largura")){
            return new BFS_Graph();
        }
        return null;
    }
	
}
