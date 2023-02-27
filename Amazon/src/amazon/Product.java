/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amazon;

/**
 *
 * @author macbookpro
 */
public class Product {
    protected String name;
    protected int quantity;
    
    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

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
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity, asigna quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
