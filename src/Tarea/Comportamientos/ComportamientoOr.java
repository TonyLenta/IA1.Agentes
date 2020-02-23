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
public class ComportamientoOr extends OneShotBehaviour {

    public void action() {
        Scanner entrada = new Scanner(System.in);
        
        boolean vv1;
        boolean vv2;
        
        System.out.print("Ingrese el Primer Valor de Verdad: ");
        vv1 = entrada.nextBoolean();
        System.out.print("Ingrese el Segundo Valor de Verdad: ");
        vv2 = entrada.nextBoolean();
        
        boolean ope = vv1 || vv2;
        
        System.out.println(vv1 + " OR " + vv2 + " = " + ope);
        System.out.println("Ejecucion del Comportamiento Or");
        myAgent.doDelete();
    }
}
