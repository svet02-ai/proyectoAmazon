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
   //asignarle un name al vértice. 
    protected String name;
    //Le asigna un número al vértice
    protected int index;
    //Lista de products:
    protected List products;
    
    public Edge(String name) {
        this.name = name;
        this.index = -1;
        this.products = new List();
        
    }
   

    //GETTERS Y SETTERS
    
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
 
// MÉTODOS
    
    //Revisa si el vértice ya existe
    public boolean compare(Edge n){
        return this.name.equals(n.getName());
    }
    
   
//    public String toString() {
//        return name + "(" + index + ")";
//    }
// 
}
