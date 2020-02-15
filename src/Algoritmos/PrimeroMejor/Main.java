
package Algoritmos.PrimeroMejor;

public class Main {
    public static void main(String[] args) 
    {
        GraphBfsSearch graph = new GraphBfsSearch();
        System.out.println("\n\t Caminos desde Guayaquil \n");
        System.out.println(String.format("Desde Guayaquil hasta Esmeraldas %s", graph.hasPathBfs("Guayaquil", "Esmeraldas")));
    }
}
