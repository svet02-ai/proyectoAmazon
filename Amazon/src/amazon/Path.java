/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amazon;

import javax.swing.JOptionPane;

/**
 *
 * @author Svetlana Valentina
 */
public class Path {
    public static String depthWidth(MatrizAdy grafo, String nombre){
        int valOrigen;
        Integer w = null;
        int intW;
        int[] arrVisitados = null;
        Edge[] verts = grafo.getVerts(); //es un arreglo con los vertices del grafo
        String temp = "";
        
                
        try{
            valOrigen = grafo.searchIndex(nombre);
            
           if (valOrigen < 0)throw new Exception("Vertice no existe");
        
           Tail cola = new Tail();
           arrVisitados = new int[grafo.getNumVerts()];
           
            for (int i = 0; i < grafo.getNumVerts(); i++) {
                arrVisitados[i] = -1; //Los vértices se marcan con -1
            
            }
            
            arrVisitados[valOrigen] = 0; //vertice de partida se inicializa en 0
            cola.encolar(valOrigen); //se encola un nodo con el índice del vértice 
            
            
            for (int i = 0; i < grafo.getNumVerts(); i++) {
                if(arrVisitados[i] == -1){
                    
                    while(!cola.isEmpty()){
                        
                        
                        w = (Integer) cola.desencolar();                     
                        intW = w;
                        Edge vert = verts[intW];
                        List lista = vert.getProducts();
                        
                        temp += "Almacen" + " " + vert.getName() + "\n" + lista.getInfo() + "\n";
                    
                    //Se encolan los adyacentes
                    for (int j = 0; j < grafo.getNumVerts(); j++) {
                        if((w != j) && (grafo.existArist(w, j) && arrVisitados[j] == -1)){                            
                            int valNodo = verts[j].getIndex();
                            cola.encolar(valNodo); 
                            arrVisitados[j] = 0;
                            }
                        }
                    }
                }
            
            }
            return temp;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, no se pudo recorrer el grafo [Anchura]");
        }
        return temp;        
   
    } 



    public static String traverseDepth(MatrizAdy grafo, String nombre){
        int valOrigen, valSig = 0;       
        int[] arrVisitados = null;
        Edge[] verts = grafo.getVerts();
        Stack pila = new Stack();
        arrVisitados = new int[grafo.getNumVerts()];
        String temp = "";
        
        try{
            valOrigen = grafo.searchIndex(nombre);
            
            if (valOrigen < 0)throw new Exception("Vertice no existe");
            
            for (int i = 0; i < grafo.getNumVerts(); i++) {
                arrVisitados[i] = -1; //Los vértices se marcan con -1            
            }
            
            arrVisitados[valOrigen] = 0; //vertice de partida se inicializa en 0
            
            pila.pile(valOrigen);
            
            while(!pila.isEmpty()){
                Integer sig;
                sig = (Integer) pila.unstack();
                valSig = sig;
                Edge vert = verts[valSig];
                List lista = vert.getProducts();
                temp += "Almacen" + " " + vert.getName() + "\n" + lista.getInfo() + "\n";
                
                for (int j = 0; j < grafo.getNumVerts(); j++){
                    if((valSig != j) && (grafo.existArist(valSig, j) && arrVisitados[j] == -1)){
                        int valNodo = verts[j].getIndex();
                        pila.pile(valNodo); 
                        arrVisitados[j] = 0;
                    }
                }
            }
            
            return temp;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, no se pudo recorrer el grafo [Profundidad]");
            }
        
        
        
    return temp;
    }
    
    public static String searchProducts(MatrizAdy grafo, String nombre, Product producto){
        int valOrigen;
        Integer w = null;
        int intW;
        int[] arrVisitados = null;
        Edge[] verts = grafo.getVerts(); //arreglo con los vertices del grafo
        String vertices = "";
        boolean encontrado;
       
        
                
        try{
            valOrigen = grafo.searchIndex(nombre);
            
           if (valOrigen < 0)throw new Exception("Vertice no existe");
        
           Tail cola = new Tail();
           arrVisitados = new int[grafo.getNumVerts()];
           
            for (int i = 0; i < grafo.getNumVerts(); i++) {
                arrVisitados[i] = -1; //Los vértices se marcan con -1
            
            }
            
            arrVisitados[valOrigen] = 0; //vertice de partida se inicializa en 0
            cola.encolar(valOrigen); //se encola un nodo con el índice del vértice 
            
            
            for (int i = 0; i < grafo.getNumVerts(); i++) {
                if(arrVisitados[i] == -1){
                    
                    while(!cola.isEmpty()){
                        
                        
                        w = (Integer) cola.desencolar();                     
                        intW = w;
                        Edge vert = verts[intW];
                        List lista = vert.getProducts();                      
                        
                    //formar el arreglo de vertices
                        encontrado = lista.compareProduct(producto.getName());  
                        
                        if (encontrado == true){
                            vertices += vert.getName() + ",";
                            
                        }                       
                        else{
                        }
                    
                    //encolar los adyacentes
                    for (int j = 0; j < grafo.getNumVerts(); j++) {
                        if((w != j) && (grafo.existArist(w, j) && arrVisitados[j] == -1)){                            
                            int valNodo = verts[j].getIndex();
                            cola.encolar(valNodo); 
                            arrVisitados[j] = 0;
                            }
                        }
                    }
                }
            
            }
            return vertices;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, no se pudo recorrer el grafo [Anchura]");
        }
        return vertices;        
   
    } 
}
