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
    private static int numVerts;
    private int maxNodes;
    private static Edge[] verts;
    private int [][] matAdy;
    private String [] totalProducts;


      
            
    public MatrizAdy(int max) {
        matAdy = new int [max][max];
        verts = new Edge[max];
        maxNodes = max;        
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
        return maxNodes;
    }

    public void setMaxVerts(int maxVerts) {
        this.maxNodes = maxVerts;
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

  
    
    //metodos
    
    public boolean isEmpty(){
        return this.numVerts == 0;
    }
    
    //Para retornar el índice de los vértices
     public static int searchIndex(String nom){
        
        Edge verti = new Edge(nom);
        boolean exist = false;
        int i = 0;
        for (; (i < numVerts) && !exist;) {
            exist = verts[i].compare(verti);
            if(!exist) i++;
           
        }
        
        if(exist){
        return i;
        }
        else{
        
        return -1;
            
        }
    }
    
//Aristas
        
    public void createArist(String u, String v, int width){
        
        if(!this.isEmpty()){
            
            int valU, valV;
            valU = searchIndex(u);
            valV = searchIndex(v);
            if(valU != -1 && valV != -1){
                matAdy[valU][valV] = width;
            }
            else{
                System.out.println("Error, el vértice no existe"); //hacerle format
            }
             
        }
        else{
            System.out.println("Error, grafo vacío");
        }
    }
    
    
    public void deleteArist(String u, String v){
        
        if(!this.isEmpty()){
            int valU, valV;
            valU = searchIndex(u);
            valV = searchIndex(v);
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
    
    //Comprobar si exist la arista
    public boolean existArist(int v, int u){
        boolean existe;
        if(matAdy[v][u] != 0){
            existe = true;
        }else{
            existe = false;
        }
        return existe;
    }
    

//Vértice
    
    public void createVertex(String nom){
        int existe = searchIndex(nom);
        if(existe == -1){
            Edge verti = new Edge(nom);
            verti.setIndex(numVerts);
            verts[numVerts++] = verti;
        }
        
    }
    
//Imprimir la matriz de adyacencia
    
    public void printMatriz(){
        System.out.printf("La matriz contiene %d vertices \n", numVerts);
        String matriz = "";
        for (int i = 0; i < maxNodes; i++) {
            matriz += ",";
            for (int j = 0; j < maxNodes; j++) {
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

     public String [] TotalProduct()
    {
        Edge x = new Edge(null);
        int contador = 0;
        String temp = " ";
        for(int i = 0; i<numVerts; i++)
        {
            x = verts[i];
            List list = x.getProducts();
            contador += list.getSize();
            temp += list.getName();
        }
        totalProducts = new String [contador];
        String [] aux = new String [contador];
        aux = temp.split(";");
        for(int k = 1; k<aux.length-1; k++)
        {
           totalProducts[k]=aux[k];
        }
       return totalProducts;
    }
    
    public String [] WarehouseOrder(Product [] productlist, MatrizAdy grafo)
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
    
    public void subtractProducts(Product [] productlist, MatrizAdy grafo){
    int encontrado;
    Product product;
    int nuevaCantidad=0;
    Node temp;
    try{
        for (int i = 0; i < verts.length; i++) {
            for (int j = 0; j < productlist.length; j++) {
                encontrado = verts[i].getProducts().compareProductQuantity(productlist[j].getQuantity());
                if(encontrado != -1){
                    temp = verts[i].getProducts().getNode(encontrado);
                    nuevaCantidad = Integer.parseInt(verts[i].getProducts().obtainCuantity()) - productlist[j].getQuantity();
                    product = new Product(verts[i].getProducts().getName(), nuevaCantidad);
                    temp.setData(product);;
                } 
            }
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "No hay suficientes articulos disponibles, chequee el stock otr vez.");
    }
}

}
