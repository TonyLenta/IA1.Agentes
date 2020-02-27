package Examen.ExamenTarea;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Scanner;

/**
 *
 * @author tony_
 */
public class AgenteTemperatura1  extends Agent
{    
   protected void setup()
   {
       ciclico comportamientosimple = new ciclico();
       addBehaviour( comportamientosimple);              
       System.out.println("Iniciando agente "+getLocalName());       
       
   }

   protected void takedown ()
   {
       System.out.println("Finalizando..");
   }

   private class ciclico extends CyclicBehaviour 
   { 
       public void action()
       {           
           ACLMessage msm=receive();
           
           if (msm!=null)
                {
                    if(msm.getContent().equals("solicitotemperatura")==true)
                    { 
                        long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
                        TInicio = System.currentTimeMillis(); //Tom
                        /* tiempos   */
                        Scanner reader = new Scanner(System.in);
                        float di = 0;
                        float u=0;
                        System.out.println("Ingrese tiempo limite de suma");
                        di = reader.nextFloat();
                        
                        float n1 = (int) (Math.random() * 100) + 1; 
                        float n2 = (int) (Math.random() * 100) + 1;
                        //Instancia para valor en temperatura
                        float suma;
                        suma=n1+n2;
                        
                                        
                       //Enviando valor suma                      
                       System.out.println("Suma:"+suma);
                      /*Muestra tiempo de ejecucion*/
                        /***************************************************************************************/
                        TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                        tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                        System.out.println("Tiempo de ejecución en milisegundos Temperatura1: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
                                                
                        /*Factor de utilizacion*/
                        u=(float)tiempo/di;
                  
                        ACLMessage respuesta = msm.createReply();    
                        respuesta.setContent(String.valueOf(u));                           
                        send(respuesta); 
                        System.out.println("Envia factor utilizacion de suma");
                    }
                      
                }else 
           {   
           block();
           }            
        }
    }       
}   


