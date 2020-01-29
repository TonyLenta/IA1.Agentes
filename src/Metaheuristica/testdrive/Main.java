package Metaheuristica.testdrive;

import Metaheuristica.heuristicas.*;
import java.util.ArrayList;
import Metaheuristica.mochila.InstanceFactory;
import Metaheuristica.mochila.Mochila;
import Metaheuristica.heuristicas.Grasp;
import Metaheuristica.heuristicas.Greedy;

public class Main {

    
	public static void main( String[] args ){
		
               /*Tiempo */            
               //Variables para determinar el tiempo de ejecución
               long TInicio=0, TFin=0;
               double      tiempo=0;              
               /*Tiempo inicio*/
               TInicio = System.currentTimeMillis();
               
               
               
		InstanceFactory factory = new InstanceFactory( "instancias.txt" );
		ArrayList<Mochila> instancias = factory.produce();
		
		SubidaEncosta se = new SubidaEncosta();
		SimulatedAnnealing sa = new SimulatedAnnealing();
		Greedy guloso = new Greedy();
		Grasp grasp = new Grasp( 0.8, 100 );
		
                for(int i=0; i<=99; i++)
                { 
                   
                    for( Mochila instancia : instancias ){

                        /*Descomentar cada objeto; estos representan cada algoritmo **/
                        // se.solve( instancia );
                    	sa.solve( instancia );
                        //guloso.solve( instancia );
                    	//grasp.solve( instancia );
                        System.out.println("-----------------------------------------");
                    }
                    
                  
                }
	
                
        
                /*Tiempo final*/
                TFin = System.currentTimeMillis();
                tiempo = (double) ((TFin - TInicio));                
                System.out.println("Tiempo promedio de las 100 ejecuciones: "+tiempo);
                /*Los tiempos varian, dependiendo del tipo de porcesador de cada pc 
                Resultados de tiempo de ejecucion    :
                Para el algoritmo SubidaEncosta      :  63 milisegundos
                Para el algoritmo SimulatedAnnealing :  78 milisegundos
                Para el algoritmo Greedy             :  31 milisegundos
                Para el algoritmo Grasp              :  78 milisegundos
                */
                /*Por lo tanto el algortmos mas eficiente con respecto al rendimineto; tenemos que el algoritmo
                Greedy es el mas optimo entre los demas algoritmos*/
        }
        
        

}