package Examen.ExamenTarea;

/**
 *
 * @author tony_
 */

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
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
          
           String mjss="";  
           if(msm!= null )
            {
                ACLMessage respuesta = msm.createReply();
                
                if(msm.getContent().equals("solicitohumedad")==true)
                {
                   int humd = (int) (Math.random() * 100) + 1;
                   long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
                   TInicio = System.currentTimeMillis(); //Tom
                   /*Tiempos*/
                   Scanner reader = new Scanner(System.in);
                        float di = 0;
                        float u=0;
                        System.out.println("Ingrese tiempo de plazo maximo de sensor humedad");
                        di = reader.nextInt();
                        /*Comportamiento*/
                        if (humd >0 && humd <=20) 
                    { 
                        mjss="seco";
                         
                    } else if (humd >20 && humd <=40) 
                    {
                        mjss="confortable";
                       
                    } else if (humd >40 && humd <=70) 
                    {
                        mjss="humedo";
                        
                    }     
                    else if (humd >70 && humd <=100)
                    {
                        mjss="pegajoso";
                        
                    } else 
                    {
                        System.out.println("Humedad fuera de rango");
                    }                        
                                   
                   /*Muestra tiempo de ejecucion*/
                   /***************************************************************************************/
                   TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                   tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                   System.out.println("Tiempo de ejecución en milisegundos Humedad: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
                    
                    u=(float)tiempo/di;
                    String cadena = Float.toString(u); 
                    respuesta.setContent(mjss/*+"Factor U:"+cadena*/);
                    send(respuesta);  
                    ACLMessage respuesta2 = msm.createReply();
                    respuesta2.setContent(cadena);
                    send(respuesta2);
                    System.out.println("Enviando factor de utilizacion de sensor Humedad a compresor");
                 
              }
            }else 
           {   
           block();
           }
        }  
    }    
}

