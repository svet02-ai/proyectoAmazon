/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amazon;

import javax.swing.JOptionPane;

/**
 *
 * @author macbookpro
 */
public class List {
    private Node pfirst;
    private Node plast;
    private int size;

//GETTERS Y SETTERS 
    
    /**
    *@return pfirst
    */
    public Node getPfirst() {
        return pfirst;
    }
   
    /**
    * @param pfirst, asigna pfirst
    */
    public void setPfirst(Node pfirst) {
        this.pfirst = pfirst;
    }
   
    /**
    *@return size
    */
    public int getSize() {
        return size;
    }
   
    /**
    * @param size, asigna size
    */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
    *@return plast
    */
    public Node getPlast() {
        return plast;
    }
   
    /**
    * @param plast, asigna plast
    */
    public void setPlast(Node plast) {
        this.plast = plast;
    }

 //CONSTRUCTOR
    public List() {
        this.pfirst = null;
        this.size = 0;    
    }
 
 //FUNCIONES PRIMITIVAS
    public boolean isEmpty(){
        return pfirst == null;
    }  
    
    public Node firstNode(Node posicion){
        return pfirst;
    }
    
    public Node lastNode(Node posicion){
        return null;
    }
    
    public void clearList(){
        pfirst = null;
        size = 0;
    }
    
    //OBTENER EL PROXIMO NODO
    public Node nextNode(Node  enlace){
        if(enlace.getPnext() != null){
            enlace =enlace.getPnext();
            return enlace;                    
        }
        else{
            return null;
        }
    }
   
    //IMPRIMIR

    /**
     *
     */
    public void printList(){
        Node temp = pfirst;
        if (this.isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        }
        else{
            
                
            String print = "";             

            for (int i = 0; i< this.getSize(); i++ ){               

                print += " "+ temp.getData().getName()+ " " + temp.getData().getQuantity() + "|";
                
                temp = nextNode(temp);               
                
               }
            JOptionPane.showMessageDialog(null,print);
   
            }
        }
    
    /*
    *@return la información de los productos de la lista
    */
    public String getInfo(){
        Node temp = pfirst;
        if (this.isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        }
        else{
            String print = "";             

            for (int i = 0; i< this.getSize(); i++ ){               

                print += temp.getData().getName()+ ":" + " " + temp.getData().getQuantity() +"\n";
                
                temp = nextNode(temp);               
                
               }
            
            return print;
            }
        return null;            
        
        }
    
     public String getName(){
        Node temp = pfirst;
        if (this.isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        }
        else{
            String print = "";             

            for (int i = 0; i< this.getSize(); i++ ){               

                print += temp.getData().getName() + " ; ";
                
                temp = nextNode(temp);               
                
               }
            
            return print;
            }
        return null;            
        
        }
    
    public boolean compareProduct(String producto){
        Node temp = pfirst;
        boolean found = false;
        
        if (this.isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        }
        else{                        

            for (int i = 0; i< this.getSize(); i++ ){               
                String p = temp.getData().getName();
                
                if(p.equals(producto)){
                    found = true;
                    break;
                        } 
                else{
                    temp = nextNode(temp);  
                        }

               }
            
            return found;
            }
        return found;            
        
        }
    
    
   
    
    //ELIMINA AL INICIO
    public void deleteAtStart(){
        if (!isEmpty()){
            pfirst = pfirst.getPnext();
            size -= 1;
        }else{
            JOptionPane.showMessageDialog(null,"La lista está vacía");
        }
    }
    
    public void deleteAtIndex(int pos){
        if (!isEmpty()){
            pfirst = pfirst.getPnext();
            size -= 1;
        }else{
            JOptionPane.showMessageDialog(null,"La lista está vacía");
        }
    }
    
    //AÑADIR AL FINAL
    public void addAtEnd(Node nodo){
        
        if(!this.isEmpty()){ 
            Node temp = plast;
            temp.setPnext(nodo);
            plast = nodo;
        }
        else{
            pfirst = plast = nodo;
        }
        
        size++;        
        
    }

    //BUSCAR ELEMENTO EN LA LISTA (retorna el nodo con el valor en cuestión)
    public Node Search(Object valor){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"Lista vacía");
            return null;
        }else{
            Node temp = pfirst;
            for (int i = 0; i < this.getSize(); i++) {
                
                if(valor== temp.getData()){
                    return temp;
                }
                else{
                    temp = temp.getPnext();
                }
            }
        }
            return null;
    }
   
    //ÍNDICE DE LA LISTA
    public int getIndex(Node nodito){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null, "Lista vacía");
            return -1;
        }else{
            Node temp = pfirst;
            int cont = 0;
            while(temp != null){
                
                if (nodito == temp){
                     return cont;
                     
                }else{
                    temp = temp.getPnext();
                    cont ++;
                }
                
            } return cont;
        }
        
    }
    
    //OBTENER NODO POR INDICE
    public Node getNode(int posicion){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null, "Lista vacía");
            return null;
        }else if(posicion >= this.size){
            JOptionPane.showMessageDialog(null,"Error");
            return null;
        }else{
            Node temp = pfirst;
            
            for (int i = 0; i < posicion; i++) {
                temp = temp.getPnext();
            }return temp;
        }
    }
    
         public String obtainCuantity(){
        Node temp = pfirst;
        if (this.isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        }
        else{
            String print = "";             

            for (int i = 0; i< this.getSize(); i++ ){               

                print += temp.getData().getQuantity();
                
                temp = nextNode(temp);               
                
               }
            
            return print;
            }
        return null;            
        
        }
    
        public int compareProductQuantity(int cant){
        Node temp = pfirst;
        int cont = 0;
        boolean found = false;
        
        if (this.isEmpty()){
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        }
        else{                        

            for (int i = 0; i< this.getSize(); i++ ){               
                int p = temp.getData().getQuantity();
                
                if(cant <= p){
                    found = true;
                    break;
                        } 
                else{
                    temp = nextNode(temp);
                    cont ++;
                        } 
               }
            
            if(found == true){
                return cont;
            }
            }
        return -1;            
        }
}
