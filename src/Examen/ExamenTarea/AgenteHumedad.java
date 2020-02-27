package Examen.ExamenTarea;

/**
 *
 * @author tony_
 */

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Scanner;
public class AgenteHumedad extends Agent
{   
     public void setup()
     {    
        MyCyclicBehavior c = new MyCyclicBehavior();
        addBehaviour(c);
         System.out.println("Iniciando agente "+getLocalName());
     }
    protected void takeDown()
    {
        System.out.println("Ejecucion finalzada.");
    }
    
    private class MyCyclicBehavior extends CyclicBehaviour 
    {
        public void action()
        {
           /*Comunicacion agentes*/
           ACLMessage msm=receive();           
           if(msm!= null )
            {
                if(msm.getContent().equals("solicitohumedad")==true)
                {
                   long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
                   TInicio = System.currentTimeMillis(); //Tom
                   /*Tiempos*/
                   Scanner reader = new Scanner(System.in);
                        float di = 0;
                        float u=0;
                        System.out.println("Ingrese tiempo limite resta");
                        di = reader.nextInt();
                        /*Comportamiento*/
                        float n1 = (int) (Math.random() * 100) + 1; 
                        float n2 = (int) (Math.random() * 100) + 1;
                        float resta;
                        resta=n1-n2;
                        System.out.println("Resta:"+resta);
                    
                   /*Muestra tiempo de ejecucion*/
                   /***************************************************************************************/
                   TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                   tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                   System.out.println("Tiempo de ejecución en milisegundos Humedad: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
                    
                    u=(float)tiempo/di;
                        
                        
                        
                        ACLMessage respuesta = msm.createReply();    
                        respuesta.setContent(String.valueOf(u));                           
                        send(respuesta); 
                        System.out.println("envia factor de utilizacion resta");
                 
              }
            }else 
           {   
           block();
           }
        }  
    }    
}

