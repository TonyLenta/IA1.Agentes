/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea.PlanificadorRM;

import comportamiento.MyCyclicBehavior;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import java.util.Scanner;

/**
 *
 * @author tony_
 */
public class SchedulerRateMonotonic extends Agent
{
    public void setup()
    {
    addBehaviour(new ComportamientoSuma());
    addBehaviour(new ComportamientoResta());
    addBehaviour(new ComportamientoMultiplicacion());
    doDelete();
    }
    
    public void takedown()
    {
        System.out.println("Finalizando agente");
    }
    
    
    
    /******************************************************/
    public float tiempo(float ci, float ti,float di)
    {
        float r;
        r= ci/ti; 
        return r;
    }
    
    public float suma(float r)
    {
        int c=0;
        c++;
        float r2;
        r2=r/c;
    return r2;
    }
    
    /*******************************************************/
    
    public class ComportamientoSuma extends OneShotBehaviour {
    /*Tiempos de calculo para sistema real*/
    public int burstTime=40;
    public int arrivalTime=50;
    public int deadlineTime=50;
    private int id = 0;
    
        
    public void action()  {
        Scanner entrada = new Scanner (System.in);
        int veces=1;
        long ac=0;
        float p=0;
        long TInicio, TFin, tiempo=0; //Variables para determinar el tiempo de ejecución
      /*  Tiempos tiemporeal = new Tiempos();
        tiemporeal.setCi(burstTime);
        tiemporeal.setTi(arrivalTime);
        tiemporeal.setDi(deadlineTime);*/
           
     /**************************************************************************************/    
       
        TInicio = System.nanoTime(); //Obtine los nanosegundos           
        double n1 = (int)(Math.random() * 100) + 1;  
        double n2 = (int)(Math.random() * 100) + 1;
        double suma;          
        suma = n1 + n2;        
        System.out.println("Numero 1:"+n1);
        System.out.println("Numero 2:"+n2);
        System.out.println("La Suma es: " + suma);
        System.out.println("Ejecucion del Comportamiento Suma");
        veces++;        
        TFin = System.nanoTime(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
        tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
        ac=ac+tiempo;
        
     /***************************************************************************************/
        p=ac/veces; 
        System.out.println("Numero de veces ejecutadas: "+ veces);
        System.out.println("Tiempo total de ejecución en nanosegundos de los 1000 comportamientos: " + ac); //Mostramos en pantalla el tiempo de ejecución en milisegundos
        System.out.println("Promedio de tiempo en nanoseguntos de 1000 comportamientos : "+ p);
        System.out.println("Promedio de tiempo en miliseguntos de 1000 comportamientos : "+ (p/100000));
        /*Termina el agente*/
        //myAgent.doDelete();
    }
    
 
    
    
    
}
    
    /********************************************************************************/
    public class ComportamientoMultiplicacion extends OneShotBehaviour {

    /*Tiempos de calculo para sistema real*/
    public int burstTime=8;
    public int arrivalTime=10;
    public int deadlineTime=10;
    private int id = 0;
    
        
    public void action() {
        //Scanner entrada = new Scanner (System.in);
        int veces=1;
        long ac=0;
        float p=0;
        long TInicio, TFin, tiempo=0; //Variables para determinar el tiempo de ejecución
       /* Tiempos tiemporeal = new Tiempos();
        tiemporeal.setCi(burstTime);
        tiemporeal.setTi(arrivalTime);
        tiemporeal.setDi(deadlineTime);*/
        
        //tiemporeal.Tiempos();
        
     /**************************************************************************************/    
        while (veces<=999) {
        TInicio = System.nanoTime(); //Obtine los nanosegundos           
        double n1 = (int)(Math.random() * 100) + 1;  
        double n2 = (int)(Math.random() * 100) + 1;
        double multiplicacion;          
        multiplicacion = n1 + n2;        
        System.out.println("Numero 1:"+n1);
        System.out.println("Numero 2:"+n2);
        System.out.println("La multiplicacion es: " + multiplicacion);
        System.out.println("Ejecucion del Comportamiento multiplicacion");
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
    
    /*******************************************************************************/
    
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
        //myAgent.doDelete();
    }    
}
}
