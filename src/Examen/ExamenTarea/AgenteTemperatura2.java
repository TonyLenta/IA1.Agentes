package Examen.ExamenTarea;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;
/**
 *
 * @author tony_
 */
public class AgenteTemperatura2  extends Agent
{
    
   protected void setup()
   {
       ciclico comportamientosimple = new ciclico();
       addBehaviour( comportamientosimple) ;             
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
           int temp = (int)(Math.random() * 100) + 1;  
          
                if (msm!=null)
                {
                    if(msm.getContent().equals("solicitotemperatura2")==true)
                    {         
                        //Instancia para valor en temperatura
                        ACLMessage respuesta = msm.createReply(); 
                        if (temp >=0 && temp <=10)
                        {                         
                        respuesta.setContent(String.valueOf(temp));
                        send(respuesta);                                  
                        //System.out.println("Muy bajo");
                        } 
                        else if (temp >10 && temp <=25)
                        {
                            respuesta.setContent(String.valueOf(temp));
                            send(respuesta);    
                          //  System.out.println("Bajo");
                        } else if (temp >25 && temp <=35) 
                        {
                            respuesta.setContent(String.valueOf(temp));                         
                            send(respuesta);  
                           // System.out.println("Alto");                                                               
                        }
                        else if (temp >35 && temp <=100)
                        {
                            respuesta.setContent(String.valueOf(temp));
                            send(respuesta);  
                           // System.out.println("Muy alto");
                        } 
                        else 
                        { 
                            System.out.println("Temperatura fuera de rango");
                        }
                        System.out.println("temp2:"+temp);
                    } 
                }else 
                {
                block();
                }   
                //System.out.println("Enviando temp2");
       }
   } 
}
