package Examen.ExamenTarea;

import jade.core.AID;
import jade.core.Agent;
import java.util.Random;
import jade.core.Agent;

/**
 *
 * @author tony_
 */
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;
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
             block();
            int humd = (int) (Math.random() * 100) + 1;   
            
           ACLMessage msm=receive();           
           String mjss="";  
           if(msm!= null )                
           { 
                ACLMessage respuesta = msm.createReply();     
              if(msm.getContent().equals("solicitohumedad")==true)
              {
                                  
                    
                    if (humd >0 && humd <=20) 
                    { 
                        mjss="seco";
                        respuesta.setContent(mjss);
                        send(respuesta);      
                    } else if (humd >20 && humd <=40) 
                    {
                        mjss="confortable";
                        respuesta.setContent(mjss);
                    send(respuesta);  
                    } else if (humd >40 && humd <=70) 
                    {
                        mjss="humedo";
                        respuesta.setContent(mjss);
                        send(respuesta);  
                    }     
                    else if (humd >70 && humd <=100)
                    {
                        mjss="pegajoso";
                        respuesta.setContent(mjss);
                        send(respuesta);  
                    } else 
                    {  
                        //mjss="Fuerarango";
                        System.out.println("Humedad fuera de rango");
                    }
                   System.out.println("Humedad: "+humd+" ==> "+mjss);
                   
              }
            }else 
           {   
           block();
           }
        }  
    }    
}

