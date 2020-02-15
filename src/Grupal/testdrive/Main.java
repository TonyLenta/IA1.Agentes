package Grupal.testdrive;

import Grupal.heuristicas.*;
import java.util.ArrayList;
import Grupal.mochila.InstanceFactory;
import Grupal.mochila.Mochila;

public class Main {

	public static void main( String[] args ){
            InstanceFactory factory = new InstanceFactory( "instancias.txt" );
            ArrayList<Mochila> instancias = factory.produce();
            /*        tiempo inicio           */
            int veces=1;
            long ac=0;
            float tt,p=0;
            long TInicio, TFin, tiempo=0; //Variables para determinar el tiempo de ejecución
            TInicio = System.currentTimeMillis(); //Tom
            
	    SubidaEncosta se = new SubidaEncosta();
	    SimulatedAnnealing sa = new SimulatedAnnealing();
	    Greedy guloso = new Greedy();
	    Grasp grasp = new Grasp( 0.8, 100 );
            for( Mochila instancia : instancias ){
                se.solve( instancia );
              //sa.solve( instancia );
              //guloso.solve( instancia );
              //grasp.solve( instancia );
	      System.out.println("-----------------------------------------");
		}
            /*   tiempo final   */
        
            ac=ac+tiempo;   
            tt=ac;
            p=tt/veces;
            TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
            tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
            System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
            System.out.println("Numero de veces ejecutadas: "+ veces);
            System.out.println("Tiempo total en milisegundos: "+ ac);
            System.out.println("Promedio de tiempo en minutos : "+ p);
            
        }

}