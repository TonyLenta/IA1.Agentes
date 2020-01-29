/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
           int temp = (int) (Math.random() * 100) + 1; 
                if (msm!=null)
                {
                    if(msm.getContent().equals("solicitotemperatura")==true)
                    { 
                        //Instancia para valor en temperatura
                        ACLMessage respuesta = msm.createReply();                      
                        if (temp >=0 && temp <=10) 
                        {
                           //Enviando valor
                           respuesta.setContent(String.valueOf(temp));
                           
                           send(respuesta);                                                                           
                          //System.out.println("Muy bajo");
                        }
                        else if (temp >10 && temp <=25) 
                        {  
                           //Enviando valor
                           respuesta.setContent(String.valueOf(temp));
                           send(respuesta);                     
                         //System.out.println("Bajo");
                        } 
                        else if (temp >25 && temp <=35) 
                        {
                           //Enviando valor
                           respuesta.setContent(String.valueOf(temp));
                           send(respuesta);                    
                          // System.out.println("Alto");
                            
                        }                                                           
                        else if (temp >35 && temp <=100)
                        {
                           //Enviando valor
                           respuesta.setContent(String.valueOf(temp));
                           send(respuesta);                       
                          //System.out.println("Muy alto");
                        }
                        else 
                        {
                                   System.out.println("Temperatura fuera de rango");
                        }
                        System.out.println("temp1:"+temp);
                    } 
                }
                else 
                {
                block();
                }
              //  System.out.println("Enviado temp1");
       }       
   }   
}
