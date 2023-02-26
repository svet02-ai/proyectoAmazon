/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amazon;

/**
 *
 * @author Svetlana Valentina
 */
public class ShortestPath {
    int [][] matriz; //matriz de adyaciencias.
    int pivote; //peso que se acarrea.
    int [] rutaFinal; //lista del peso minimo de cada ruta desde el origen.
    int o; //vertice origen
    int n; //numero de vertices 
    int [] hilera; //lista para iterar sobre la matriz de adyaciencias.
    int infinito; //valor maximo que trabaja como infinito.
    int [] visitados; //lista que determina que filas han sido visitadas.
    
    
    //CONSTRUCTOR:
    public ShortestPath(MatrizAdy grafo, Edge x)
    { 
        matriz = grafo.getmatAdy();
        n = grafo.getNumVerts();
        pivote = grafo.size();
        infinito = grafo.size();//EL TAMANHO VA A FUNCIONAR COMO NUESTRO INFINITO
        o = x.getIndex();
        visitados = new int[n];
        
        
        for(int i = 0; i < n; i++) //AQUI SE CAMBIAN TODOS LOS CEROS DE LA MATRIZ POR EL TAMANHO DEL GRAFO.
        {
        visitados[i]=0; 
            for(int j = 0; j<n; j++)
                {
                    if(matriz[i][j] == 0)
                    {
                        matriz[i][j] = pivote;
                    }
                }
        }

        rutaFinal = matriz[o]; //SELECCIONA LA FILA DE LA MATRIZ DEL VERTICE ORIGEN.
        rutaFinal[o] = 0; //DECLARA EL PESO DEL ORIGEN AL ORIGEN EN CERO.
        visitados[o]=1; //DECLARA LA FILA DEL EL ORIGEN COMO VISITADO.
        
        
    }
    
    
    public String conseguirRuta(MatrizAdy grafo)
    {
        String print = "";
        for(int v = 0; v<n; v++) //ESTE FOR HACE QUE LA FUNCION SE REPITA EL NUMEOR DE VERTICES, DE ESTA MANERA SE RECORRE TODA LA MATRIZ.
        {
            for(int i = 0; i<n; i++) //ESTE FOR RECORRE LA FILA DE LA RUTA PARA ENCONTRAR LOS PIVOTES.
            {
                if(rutaFinal[i]!= infinito && visitados[i]==0)
                    {
                        pivote=rutaFinal[i];
                        hilera = matriz[i];
                        visitados[i]=1;
                        break;
                    }
            }
            for(int x=0; x<n;x++) //ESTE FOR RECORRE LA HILERA RESPECTIVA PARA HACER LOS CAMBIOS EN LA RUTA FINAL SI SON NECESARIOS.
            {
                if(pivote + hilera[x] < rutaFinal[x])
                {
                    rutaFinal[x] = pivote + hilera[x]; 
                }
            }    
        }
        for(int i =0; i<n; i++)
        {
            print+= "La ruta mas corta desde " + grafo.getVerts()[o].getName() + " hasta " + grafo.getVerts()[i].getName() + " es " + rutaFinal[i] + "\n";
        }
        return print;
    }
}
