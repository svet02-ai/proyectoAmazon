/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amazon;

/**
 *
 * @author Svetlana Valentina
 */
public class Edge { 
    // atributos: nombre y numero del vertice y lista de productos
    protected String name;
    protected int index;
    protected List products;
    public Edge(String name) {
        this.name = name;
        this.index = -1;
        this.products = new List();
        
    }
   

    //getters and setters
    
    /**
    * @return name
    */
    public String getName() {
        return name;
    }
    
    /**
    * @param name, asigna name
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * @return index
    */
    public int getIndex() {
        return index;
    }

    /**
    * @param index, asigna index
    */
    public void setIndex(int index) {
        this.index = index;
    }
    
    /**
    * @return products
    */
    public List getProducts() {
        return products;
    }
    
    /**
    * @param products, asigna products
    */
    public void setProducts(List products) {
        this.products = products;
    }
 
// funciones
    
    //Revisa si el vértice ya existe
    public boolean compare(Edge n){
        return this.name.equals(n.getName());
    }
    
}
