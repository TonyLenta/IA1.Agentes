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
public class ComportamientoNot extends OneShotBehaviour {

    public void action() {
        Scanner entrada = new Scanner(System.in);
        
        boolean vv1;
        boolean vv2;
          
        System.out.print("Ingrese un valor de verdad: ");
        vv1 = entrada.nextBoolean();
        System.out.print("Ingrese un valor de verdad: ");
        vv2 = entrada.nextBoolean();
        
        boolean ope =!(vv1==vv2);
        
        System.out.println(vv1 + " NOT " + vv2 + " = " + ope);
        System.out.println("Ejecucion del Comportamiento Not");
        myAgent.doDelete();
    }
}
