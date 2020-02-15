package Algoritmos.AlgoritmoBacktracking;

public class Laberinto {

    public static void main(String[] args) {
        // se dibuja el laberinto por medio de # y se lo guarda en un array bidimensional
        char[][] laberinto
                = {{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' '},
                {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#', ' '},
                {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#', ' '},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' '},
                {'#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' '},
                {'#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', ' ', ' '},
                {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', '#', ' '},
                {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' '},
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' '},};
        //posiciones de entrada
        int posxinicial = 1;
        int posyinicial = 1;        
        // llama a la clase
        Backtraking clase_laberinto = new Backtraking(laberinto, posxinicial, posyinicial, 'X');        
        //Posicion de salida
        clase_laberinto.Salida(1,5);
        System.out.println("Solucion: \n" + clase_laberinto.imprimir_matrizSolution());
    }
}
