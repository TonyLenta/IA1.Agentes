/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea.Comportamientos;

import Tarea.Tiempos.Tiempos;
import jade.core.behaviours.OneShotBehaviour;
import java.util.Scanner;

/**
 *
 * @author tony_
 */
public class ComportamientoResta extends OneShotBehaviour {
    
     /*Tiempos de calculo para sistema real*/
    public int burstTime;
    public int arrivalTime;
    public int deadlineTime;
    private int id = 0;
    

    public void action() {
        //Scanner entrada = new Scanner (System.in);
       int veces=1;
        long ac=0;
        float p=0;
        long TInicio, TFin, tiempo=0; //Variables para determinar el tiempo de ejecución
      /*  Tiempos tiemporeal = new Tiempos();
        tiemporeal.setCi(burstTime);
        tiemporeal.setTi(arrivalTime);
        tiemporeal.setDi(deadlineTime);*/
           
     /**************************************************************************************/    
        while (veces<=999) {
        TInicio = System.nanoTime(); //Obtine los nanosegundos           
        double n1 = (int)(Math.random() * 100) + 1;  
        double n2 = (int)(Math.random() * 100) + 1;
        double resta;          
        resta = n1 + n2;        
        System.out.println("Numero 1:"+n1);
        System.out.println("Numero 2:"+n2);
        System.out.println("La resta es: " + resta);
        System.out.println("Ejecucion del Comportamiento resta");
        veces++;        
        TFin = System.nanoTime(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
        tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
        ac=ac+tiempo;
        }
     /***************************************************************************************/
        p=ac/veces; 
        System.out.println("Numero de veces ejecutadas: "+ veces);
        System.out.println("Tiempo total de ejecución en nanosegundos de los 1000 comportamientos: " + ac); //Mostramos en pantalla el tiempo de ejecución en milisegundos
         System.out.println("Promedio de tiempo en nanoseguntos de 1000 comportamientos : "+ p);
        System.out.println("Promedio de tiempo en miliseguntos de 1000 comportamientos : "+ (p/100000));
        /*Termina el agente*/
       // myAgent.doDelete();
    }    
}
