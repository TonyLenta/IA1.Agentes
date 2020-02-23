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
public class ComportamientoDivision extends OneShotBehaviour {

    public void action() {
         int veces=1;
       long ac=0;
       float tt,p=0;
       long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
           TInicio = System.nanoTime(); //Tom
           
    /**************************************************************************************/    
        while (veces<=999) {
           
           Scanner entrada = new Scanner (System.in);
       
        double n1, n2;
        double division;
        
        System.out.print("Ingrese el Primer Numero: ");
        n1 = entrada.nextDouble();
        System.out.print("Ingrese el Segundo Numero: ");
        n2 = entrada.nextDouble();
        
        division = n1 / n2;
        
        System.out.println("La Division es: " + division);
        System.out.println("Ejecucion del Comportamiento Division");
                
        }
        /***************************************************************************************/
           TFin = System.nanoTime(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
           tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
           System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
   
           ac=ac+tiempo;  
            tt=ac;
            p=tt/veces;
       
       System.out.println("Numero de veces ejecutadas: "+ veces);
       System.out.println("Tiempo total en milisegundos: "+ ac);
        System.out.println("Promedio de tiempo en minutos : "+ p);
        /*Termina el agente*/
        myAgent.doDelete();
    }
}
