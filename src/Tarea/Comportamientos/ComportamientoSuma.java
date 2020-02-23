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
public class ComportamientoSuma extends OneShotBehaviour {

    public void action() {
        Scanner entrada = new Scanner (System.in);
       
        double n1, n2;
        double suma;
        
        System.out.print("Ingrese el Primer Numero: ");
        n1 = entrada.nextDouble();
        System.out.print("Ingrese el Segundo Numero: ");
        n2 = entrada.nextDouble();
        
        suma = n1 + n2;
        
        System.out.println("La Suma es: " + suma);
        System.out.println("Ejecucion del Comportamiento Suma");
        myAgent.doDelete();
    }
}
