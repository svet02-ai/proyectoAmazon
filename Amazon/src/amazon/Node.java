/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amazon;

/**
 *
 * @author macbookpro
 */
public class Node{
    
    protected Node pnext;
    protected Product data;
    protected Object data2;
    private String[] edges;
    
    
    
    public Node(Product data) {
        this.pnext = null;
        this.data = data;
    }
    
    public Node(Object data) {
        this.pnext = null;
        this.data2 = data;
    }
    

    /**
    * @return pnext
    */
    public Node getPnext() {
        return pnext;
    }

    /**
    * @param pnext, asigna pnext
    */
    public void setPnext(Node pnext) {
        this.pnext = pnext;
    }

    /**
    *@return nombre
    */
    public Product getData() {
        return data;
    }

    /**
    * @param data, asigna data
    */
    public void setData(Product data) {
        this.data = data;
    }
    
    /**
    *@return dato del nodo - colas/pilas
    */
    public Object getData2() {
        return data2;
    }

    /**
    * @param data2, asigna data2
    */
    public void setData2(Object data2) {
        this.data2 = data2;
    }
}
