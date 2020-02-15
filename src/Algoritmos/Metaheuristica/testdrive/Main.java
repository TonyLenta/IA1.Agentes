package Algoritmos.Metaheuristica.testdrive;


import Algoritmos.Metaheuristica.heuristicas.Grasp;
import Algoritmos.Metaheuristica.heuristicas.SubidaEncosta;
import Algoritmos.Metaheuristica.heuristicas.SimulatedAnnealing;
import Algoritmos.Metaheuristica.heuristicas.Greedy;
import Algoritmos.Metaheuristica.mochila.*;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        InstanceFactory factory = new InstanceFactory("instancias.txt");
        ArrayList<Mochila> instancias = factory.produce();

        SubidaEncosta se = new SubidaEncosta();
        SimulatedAnnealing sa = new SimulatedAnnealing();
        Greedy guloso = new Greedy();
        Grasp grasp = new Grasp(0.8, 100);
        int eleccion = 0;
        do {
            System.out.println("Que algoritmo metahuristico desea utilizar");
            System.out.println(
                    "1. Hill Climb\n"
                    + "2. Simulated Anneling\n"
                    + "3. Greedy\n"
                    + "4. Grasp\n"
            );
            eleccion = entrada.nextInt();
        } while (eleccion > 4 || eleccion < 0);

        for (Mochila instancia : instancias) {

            switch (eleccion) {
                case 1:
                //    se.solve(instancia);
                    break;
                case 2:
               //     sa.solve(instancia);
                    break;
                case 3:
                //    guloso.solve(instancia);
                    break;
                case 4:
                 //   grasp.solve(instancia);
                    break;
            }

            System.out.println("-----------------------------------------");
        }

        entrada.close();
    }

}
