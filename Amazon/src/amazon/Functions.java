/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amazon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Svetlana Valentina
 */
public class Functions {
    public MatrizAdy buildGrafo(String dir){
        MatrizAdy grafo = null;
       
        
        try{
                      
            BufferedReader bf = new BufferedReader(new FileReader(dir));
            
            String temp = "";
            String bfRead;
            
            while((bfRead = bf.readLine()) != null){//hacer ciclo mientras bfRead tiene datos
                temp += bfRead;    
            }
            
             bf.close();
            
            String[] arr = temp.split(";");             
            int cont = 0; //Contador para pasar a rutas
            String noms = ""; //string que contendrá los nombres de los almacenes
            
            for (int i=1; i < arr.length; i++) {
                if(!arr[i].equals("Rutas")) {
                    
                    char a = (arr[i].charAt(8)); //Recordar sintaxis de almacen a la hora de escribir txt (crear almacen)
                    noms += Character.toString(a);
                    cont ++;   
                }
                else{
                    break;
                }
                      
            }
            
            
            /*
            *Crear grafo a partir de la cantidad de almacenes. Se le resta 2
            *porque "Almacenes" y "Rutas" no cuentan.
            */
            
            grafo = new MatrizAdy(cont);
            
            //Crear los vértices con los nombres de los almacenes
            for(int i = 0; i< noms.length(); i++){
                char name = noms.charAt(i);
                grafo.createVertex(Character.toString(name));
            }
            
            
            //Asignar aristas
           
            String routs = arr[cont+2]; //se toma todo el string con las rutas
            
            String[] rout = routs.split(","); //se separan las rutas
            int j = 0;
            do{
                if(j == 0){
                    
                    int position = (rout[j+2].length())-1;
                    String subrout = rout[j+2].substring(0, position); //Esto es para eliminar la letra que acompaña al número                 
                    grafo.createArist(rout[j], rout[j+1], Integer.parseInt(subrout));
                
                    j+=2;
                }
                else if(j+2 == rout.length-1){
                    int position1 = (rout[j].length())-1;
                    char subrout1 = rout[j].charAt(position1);
                   
                    grafo.createArist(Character.toString(subrout1), rout[j+1], Integer.parseInt(rout[j+2]));
                    
                    j+=2;
                }
                else{                    
                    
                    int position1 = (rout[j].length())-1;
                    char subrout1 = rout[j].charAt(position1); //Tomar únicamente la letra 
                   
                    int position2 = (rout[j+2].length())-1;
                    String subrout2 = rout[j+2].substring(0, position2);
                    
                    grafo.createArist(Character.toString(subrout1), rout[j+1], Integer.parseInt(subrout2));
                    
                    j+=2;
                }
            }while(j+2 <= (rout.length));
            
            
            //CREAR LISTAS DE PRODUCTOS E INSERTARLAS EN LOS VÉRTICES
            
           
            int index = -2;
            
            BufferedReader bf2 = new BufferedReader(new FileReader(dir));
            
            
            while(!(bfRead = bf2.readLine()).equals("Rutas;")){
                Edge[] verts = grafo.getVerts();                
                
                
                if(bfRead.contains("Almacen")){
                    index++;
                }
                else{
                    if(bfRead.contains(";")){
                        String replace = bfRead.replace(";", "");
                    
                        String[] productList = replace.split(",");

                        Product product = new Product(productList[0], Integer.parseInt(productList[1]));                    

                        if((verts[index].getProducts()).isEmpty()){
                            List lista = new List();
                            Node node = new Node(product);
                            lista.addAtEnd(node);
                            verts[index].setProducts(lista);
                        }
                        else{
                            List lista = verts[index].getProducts();
                            Node node = new Node(product);
                            lista.addAtEnd(node);
                            verts[index].setProducts(lista);
                            }
                    
                        }
                    else{
                        String[] productoList = bfRead.split(",");
                   
                        Product product = new Product(productoList[0], Integer.parseInt(productoList[1]));                    

                        if((verts[index].getProducts()).isEmpty()){
                            List lista = new List();
                            Node node = new Node(product);
                            lista.addAtEnd(node);
                            verts[index].setProducts(lista);
                        }
                        else{
                            List lista = verts[index].getProducts();
                            Node node = new Node(product);
                            lista.addAtEnd(node);
                            verts[index].setProducts(lista);
                        }
                    }
    
                    
                }
                
            }
            
            bf2.close();
            
            return grafo;
            

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR, NO SE PUDO CREAR EL GRAFO");
            return null;
        }
       
    }
    
    public void actTxt(MatrizAdy grafo){
        
    }
    
    public void actTxt(MatrizAdy grafo, String dir){
        Edge[] vertices = grafo.getVerts();
        String temp = "";
        Product product = null; 
        try{
            
            PrintWriter pw = new PrintWriter(dir);
            pw.print("Almacenes;" + "\n");
                       
            
            
            for (int i=0; i < vertices.length; i++){
                pw.print("Almacen" + " " + vertices[i].getName() + ":" + "\n");
                List lista = vertices[i].getProducts();
                Node temporal = lista.getPfirst();
                for (int j = 0; j < lista.getSize(); j++) {
                    product = temporal.getData();
                    
                    if(temporal != lista.getPlast()){
                    
                        temp = product.getName() + "," + product.getQuantity();
                        pw.print(temp + "\n");
                        temporal = lista.nextNode(temporal); 
                    }
                    else
                    {
                                            
                        temp = product.getName() + "," + product.getQuantity() + ";";
                        pw.print(temp + "\n");
                        temporal = lista.nextNode(temporal); 
                    }
                
                
                }
     
            }
            
          
            pw.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR, NO SE PUDO ACTUALIZAR EL ARCHIVO");
        }
    }
}
