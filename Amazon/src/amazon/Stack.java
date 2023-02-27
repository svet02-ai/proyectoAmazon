/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amazon;

/**
 *
 * @author macbookpro
 */
public class Stack {
  
    private Node peak;
    private int size;

    //Constructor 
    public Stack() {
        this.peak = null;
        this.size = 0;
    }

    //Obtener peak
    public Node getPeak() {
        return peak;
    }

    //Asignar peak
    public void setPeak(Node cima) {
        this.peak = cima;
    }
    
     //Obtener tamaño
    public int getSize() {
        return size;
    }
    
    //Asignar tamaño
    public void setSize(int size){
        this.size = size;
    }

    //Apilar 
    public void pile(Object data) {
        Node aux = new Node(data);
        aux.setPnext(this.peak);
        setPeak(aux);
        size++;
    }

    //Desapilar 
    public Object unstack() {
        Object info = peak.getData2();
        this.peak = peak.getPnext();
        size--;
    return info;
    }

  
    //Obtener valor del peak o cima
    public Object top() {
        return peak.getData2();
    }

    //Esta vacio
    public boolean isEmpty() {
        return peak == null;
    }


    //Mostrar pila
    public void showStack() {       
        Node pAux = this.peak;
        while (pAux != null) {
            System.out.println(pAux.getData2());
            pAux = pAux.getPnext();
        }
        
    }

    //sumergir valor
    public void push(Object x) {
        if (!isEmpty()) {
            Object aux = this.unstack();
            this.push(x);
            this.pile(aux);
        } else {
            this.pile(x);
        }
    }

    //Invertir pila
    public void inverseStack() {
        if (!isEmpty()) {
            Object aux = this.unstack();
            this.inverseStack();
            this.push(aux);
        }
    }

    //Vaciar pila
    public void clearStack() {
        while (!isEmpty()) {
            this.unstack();
        }
    }
    
}
