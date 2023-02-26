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
    int [][] matrix; //matriz de adyaciencias.
    int pivote; //peso que se acarrea.
    int [] finalRoute; //lista del peso minimo de cada ruta desde el origen.
    int o; //vertice origen
    int n; //numero de vertices 
    int [] hilera; //lista para iterar sobre la matrix de adyacencias.
    int infinito; //valor maximo que trabaja como infinito.
    int [] visitados; //lista que determina que filas han sido visitadas.
    
    
    //CONSTRUCTOR:
    public ShortestPath(MatrizAdy grafo, Edge x)
    { 
        matrix = grafo.getmatAdy();
        n = grafo.getNumVerts();
        pivote = grafo.size();
        infinito = grafo.size();//el size maximo
        o = x.getIndex();
        visitados = new int[n];
        
        
        for(int i = 0; i < n; i++) //se reemplazan los ceros de la matriz con el size del grafo
        {
        visitados[i]=0; 
            for(int j = 0; j<n; j++)
                {
                    if(matrix[i][j] == 0)
                    {
                        matrix[i][j] = pivote;
                    }
                }
        }

        finalRoute = matrix[o]; //fila de la matriz del vertice de origen.
        finalRoute[o] = 0; //declara el width del origen al origen en cero.
        visitados[o]=1; //el origen ya visitado.
        
        
    }
    
    
    public String searchRoute(MatrizAdy grafo)
    {
        String print = "";
        for(int v = 0; v<n; v++) //recorre la matriz.
        {
            for(int i = 0; i<n; i++) //encuentra los pivotes.
            {
                if(finalRoute[i]!= infinito && visitados[i]==0)
                    {
                        pivote=finalRoute[i];
                        hilera = matrix[i];
                        visitados[i]=1;
                        break;
                    }
            }
            for(int x=0; x<n;x++) //cambia la ruta final si se necesita.
            {
                if(pivote + hilera[x] < finalRoute[x])
                {
                    finalRoute[x] = pivote + hilera[x]; 
                }
            }    
        }
        for(int i =0; i<n; i++)
        {
            print+= "La ruta mas corta desde " + grafo.getVerts()[o].getName() + " hasta " + grafo.getVerts()[i].getName() + " es " + finalRoute[i] + "\n";
        }
        return print;
    }
}
