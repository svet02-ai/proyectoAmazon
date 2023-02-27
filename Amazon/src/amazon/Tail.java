/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amazon;

/**
 *
 * @author macbookpro
 */
public class Tail {
     
    private int size;
    private Node front;
    private Node back;

    //constructor
    public Tail() {
        this.size = 0;
        this.front = null;
        this.back = null;
    }
    
 
    /**
    *@return size
    * 
    */
    public int getSize() {
        return size;
    }
    
    /**
    *@return front 
    */
    public Node getFront() {
        return front;
    }

    /**
    *@param front asigna front
    */
    public void setFront(Node front) {
        this.front = front;
    }

    /**
    *@return back 
    */
    public Node getBack() {
        return back;
    }

    /**
    *@param back asigna back 
    */
    public void setBack(Node back) {
        this.back = back;
    }

    /**
    *@return si esta vacia la cola
    */
    public boolean isEmpty() {
        return this.front == null;
    }

    //Verificar si existen
    public boolean available(Object info) {
        Node aux = front;
        boolean available;
        if (!isEmpty()) {
            desencolar();
            if (aux.getData2() == info) {
                available = true;
            } else {
                available = available(info);
            }
            encolar(aux.getData2());
        } else {
            available = false;
        }
        return available;
    }

    //Agregar a la cola
    public void encolar(Object info) {
        Node novo = new Node(info);
        if (isEmpty()) {
            this.front = novo;
            this.back = novo;
            size++;
        } else {
            back.pnext = novo;
            back = novo;
            size++;
        }
    }

    //Eliminar de la cola
    //Devolver index del vertice
    public Object desencolar() {
        Node aux = front;        
        Object index = aux.getData2();
        if (!isEmpty()) {
            front = front.pnext;
            size--;
        }
    return index;
    }

    //Invertir cola
    public void invertCola() {
        Object aux;
        if (!isEmpty()) {
            aux = front.data;
            desencolar();
            invertCola();
            encolar(aux);
        }
    }

    //Copiar Cola
    public Tail copy(Tail copy) {
        Object aux;
        if (!isEmpty()) {
            aux = front.getData2();
            desencolar();
            copy.encolar(aux);
            copy(copy);
            encolar(aux);
        }
        return copy;
    }

    //Buscar elemento en cola
    public Object searchElement(int index) {
        Node aux = front;
        Object element = null;
        if (index > size) {
            System.out.println("No existe en la cola");
        } else if (index > 1) {
            desencolar();
            index--;
            element = searchElement(index);
            encolar(aux.getData2());
        } else {
            element = front.getData2();
        }
        return element;
    }

    //Mostrar cola
    public void showTail() {
        Node temp = front;
        
        while (temp != null) {
            System.out.println(temp.getData2());
            temp = temp.pnext;
        }
        
    }
}
