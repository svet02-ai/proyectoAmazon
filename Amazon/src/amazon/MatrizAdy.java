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
public class MatrizAdy {
    //Número de vértices
    private static int numVerts;
    
    //tamaño máximo de la matriz
    private int maxNodos;
    
    //Lista con los vértices
    private static Edge[] verts;
    
    //Forma la matriz
    private int [][] matAdy;
    
    //Todos los productos
    private String [] totalProductos;


      
            
    public MatrizAdy(int max) {
        matAdy = new int [max][max];
        verts = new Edge[max];
        maxNodos = max;        
        numVerts = 0;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                matAdy[i][j] =  0; 
            }
            
        }
       
    }

//Getters y Setters
    public int getNumVerts() {
        return numVerts;
    }

    public void setNumVerts(int numVerts) {
        this.numVerts = numVerts;
    }

    public int getMaxVerts() {
        return maxNodos;
    }

    public void setMaxVerts(int maxVerts) {
        this.maxNodos = maxVerts;
    }
    
    /**
     *
     * @return
     */
    public Edge[] getVerts(){
        return this.verts;
    }
    
    public void setVerts(Edge[] verts){
        this.verts = verts;
    }
    
    public int[][] getmatAdy() {
        return matAdy;
    }

    public void setmatAdy(int[][] matAdy) {
        this.matAdy = matAdy;
    }

  
    
    //MÉTODOS
    
    public boolean isEmpty(){
        return this.numVerts == 0;
    }
    
//    //Va a decir si el vértice ya existe o no. Validar
//    public boolean buscarVertice(String nom){
//        
//        Vertice verti = new Vertice(nom);
//        boolean existe = false;
//        int i = 0;
//        for (; (i < numVerts) && !existe;) {
//            existe = verts[i].comparar(verti);
//            if(!existe) i++;
//           
//        }
//        
//        return existe;
//        
//    }
    
    //Para retornar el índice de los vértices
     public static int buscarIndex(String nom){
        
        Edge verti = new Edge(nom);
        boolean existe = false;
        int i = 0;
        for (; (i < numVerts) && !existe;) {
            existe = verts[i].compare(verti);
            if(!existe) i++;
           
        }
        
        if(existe){
        return i;
        }
        else{
        
        return -1;
            
        }
    }
    
//Aristas 
        
    public void crearArista(String u, String v, int peso){
        /*En el código lo marcan con true, creo recordar que Ale
        dijo que en este caso se pondría el peso, así que añadí ese paramétro.       
     
        Hacer excepciones por si alguno de los dos no existe, por si superan el maximo, etc.
        */
        if(!this.isEmpty()){
            
            int valU, valV;
            valU = buscarIndex(u);
            valV = buscarIndex(v);
            if(valU != -1 && valV != -1){
                matAdy[valU][valV] = peso;
            }
            else{
                System.out.println("Error, el vértice no existe"); //hacerle format
            }
             
        }
        else{
            System.out.println("Error, grafo vacío");
        }
    }
    
    
    public void eliminarArista(String u, String v){
        
        if(!this.isEmpty()){
            int valU, valV;
            valU = buscarIndex(u);
            valV = buscarIndex(v);
           if(valU != -1 && valV != -1){
                matAdy[valU][valV] = 0;
            }
            else{
                System.out.println("Error, el vértice no existe");
            }
        }
        else{
            System.out.println("Error, grafo vacío");
        }
            
        
    }
    
    //Comprobar si existe la arista
    public boolean existeArista(int v, int u){
        boolean existe;
        if(matAdy[v][u] != 0){
            existe = true;
        }else{
            existe = false;
        }
        return existe;
    }
    
    //buscar arista:
//    public boolean getArista(int v, int u){
//    boolean existe;
//    if(matAdy[v][u] != 0){
//        existe = true;
//    }else{
//        existe = false;
//    }
//    return existe;
//}
    

//Vértice
    
    public void crearVertice(String nom){
        int existe = buscarIndex(nom);
        if(existe == -1){
            Edge verti = new Edge(nom);
            verti.setIndex(numVerts);
            verts[numVerts++] = verti;
        }
        
    }
    
//Eliminar vértice no está y no tengo cabeza para pensar en eso ahora. Sorry
    
//Imprimir la matriz de adyacencia
    
    public void printMatriz(){
        System.out.printf("La matriz contiene %d vertices \n", numVerts);
        String matriz = "";
        for (int i = 0; i < maxNodos; i++) {
            matriz += ",";
            for (int j = 0; j < maxNodos; j++) {
                matriz += (matAdy[i][j]);
             
            }
        
        }
        String[] mat = matriz.split(",");
        JOptionPane.showMessageDialog(null, mat);
    }
    
//Tamaño del grafo
    
    public int size(){
        int tm = 0;
        for (int i = 0; i < numVerts; i++) {
            for (int j = 0; j < numVerts; j++) {
                tm += matAdy[i][j];                
            }
            
        }
        return tm;
    }
    
//Grados
    
//Calcula el grado de entrada del vértice
    
    //Recorre las filas, teniendo la columna fija
    public int gradoEnt(int j){
        int gEnt = 0;
        for (int i = 0; i < numVerts; i++) {
                gEnt += matAdy[i][j]; 
            
        }
        return gEnt;
    }
//Calcula el grado de salida del vértice
    public int gradoSal(int i){
        int gSal = 0;
        for (int j = 0; j < numVerts; j++) {
            gSal += matAdy[i][j];
            
        }
        return gSal;
    }

     public String [] ProductosTotal()
    {
        Edge x = new Edge(null);
        int contador = 0;
        String temp = " ";
        for(int i = 0; i<numVerts; i++)
        {
            x = verts[i];
            List list = x.getProducts();
            contador += list.getSize();
            temp += list.getNombre();
        }
        totalProductos = new String [contador];
        String [] aux = new String [contador];
        aux = temp.split(";");
        for(int k = 1; k<aux.length-1; k++)
        {
           totalProductos[k]=aux[k];
        }
       return totalProductos;
    }
    
    public String [] pedidoAlmacenes(Product [] productlist, MatrizAdy grafo)
    {
        String [] Alist;
        String Aux = " ";
        int contador = 0;
        
        for (int i = 0; i < productlist.length; i++) {
            Aux += Path.searchProducts(grafo, "A", productlist[i]);
            Aux += ",";
        }
        
        Alist = Aux.split(",");

       return Alist;
    }
    
    public void RestarProductos(Product [] productlist, MatrizAdy grafo){
    int encontrado;
    Product product;
    int nuevaCantidad=0;
    Node temp;
    try{
        for (int i = 0; i < verts.length; i++) {
            for (int j = 0; j < productlist.length; j++) {
                encontrado = verts[i].getProducts().compararProductoCantidad(productlist[j].getQuantity());
                if(encontrado != -1){
                    temp = verts[i].getProducts().getNodo(encontrado);
                    nuevaCantidad = Integer.parseInt(verts[i].getProducts().ObtenerCantidad()) - productlist[j].getQuantity();
                    product = new Product(verts[i].getProducts().getNombre(), nuevaCantidad);
                    temp.setData(product);;
                } 
            }
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No hay suficientes articulos disponibles, chequee el stock otr vez.");
    }
}

}
