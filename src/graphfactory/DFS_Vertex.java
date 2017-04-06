package graphfactory;

/**
 *
 * @author lucasgb
 */
public class DFS_Vertex extends Vertex{

    private Color color;    
    private Vertex daddy;
    private int d, f;
    
   
    public DFS_Vertex(String id){
        super(id);
    }
    
    public DFS_Vertex(String id, Color color, Vertex daddy) {
        super(id);
        this.color = color;
        this.daddy = daddy;        
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    public Color getColor(){
        return color;
    }
   
    public void setDaddy(Vertex v){
        this.daddy = v;
    }
    
    public void setD(int d){
        this.d = d;
    }
    public void setf(int f){
        this.f = f;
    }
}