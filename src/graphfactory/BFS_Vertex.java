/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfactory;

/**
 *
 * @author elivelton
 */
public class BFS_Vertex extends Vertex{
    private Color color;    
    private Vertex daddy;
    private int d;

    public BFS_Vertex(String id) {
        super(id);
    }

    public BFS_Vertex(Color color, Vertex daddy, String id, int d) {
        super(id);
        this.color = color;
        this.daddy = daddy;
        this.d = d;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Vertex getDaddy() {
        return daddy;
    }

    public void setDaddy(Vertex daddy) {
        this.daddy = daddy;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}
