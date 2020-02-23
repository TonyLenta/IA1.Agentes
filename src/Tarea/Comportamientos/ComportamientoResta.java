/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea.Comportamientos;

import jade.core.behaviours.OneShotBehaviour;
import java.util.Scanner;

/**
 *
 * @author tony_
 */
public class ComportamientoResta extends OneShotBehaviour {

    public void action() {
        Scanner entrada = new Scanner (System.in);
       
        double n1, n2;
        double resta;
        
        System.out.print("Ingrese el Primer Numero: ");
        n1 = entrada.nextDouble();
        System.out.print("Ingrese el Segundo Numero: ");
        n2 = entrada.nextDouble();
        
        resta = n1 - n2;
        
        System.out.println("La Resta es: " + resta);
        System.out.println("Ejecucion del Comportamiento Resta");
        myAgent.doDelete();
    }
}
