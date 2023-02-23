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
  
    private Node top;
    private int size;

    //Constructor 
    public Stack() {
        this.top = null;
        this.size = 0;
    }

    //Obtener top
    public Node getTop() {
        return top;
    }

    //Asignar top
    public void setTop(Node cima) {
        this.top = cima;
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
        aux.setPnext(this.top);
        setTop(aux);
        size++;
    }

    //Desapilar 
    public Object unstack() {
        Object info = top.getData2();
        this.top = top.getPnext();
        size--;
    return info;
    }

  
    //Obtener valor del top o cima
    public Object top() {
        return top.getData2();
    }

    //Esta vacio
    public boolean isEmpty() {
        return top == null;
    }


    //Mostrar pila
    public void showStack() {       
        Node pAux = this.top;
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
    public void emptyStack() {
        while (!isEmpty()) {
            this.unstack();
        }
    }
    
}
