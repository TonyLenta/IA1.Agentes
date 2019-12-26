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
            //block();  
            Random aletorio =new Random();
            int humd = (int) (Math.random() * 100) + 1;
            String mjss="";                
                 
            
           // AID id=new AID();
            //Instancia solicitando temperatura 1
           // ACLMessage msm=new ACLMessage(ACLMessage.AGREE);            
           // id.setLocalName("compresor");
           // msm.addReceiver(id);            
           // msm.setContent("enviohumedad");
           // send(msm);
           //ACLMessage respuesta = blockingReceive();   
           ACLMessage msm=receive();
           String cadena = Integer.toString(humd);
           if(msm!= null)                
           { 
              if(msm.getContent().equals("solicitohumedad")==true)
              {
                     ACLMessage respuesta = msm.createReply();                        
                    
                    if (humd >=0 && humd <=20) 
                    { 
                        
                        respuesta.setContent("seco"/*+":"+cadena*/);
                        send(respuesta);      
                    } else if (humd >20 && humd <=40) 
                    {
                        //mjss="Confortable";
                       respuesta.setContent("confortable");
                    send(msm);  
                    } else if (humd >40 && humd <=70) 
                    {
                        //mjss="Humedo";
                       respuesta.setContent("humedo"/*+":"+cadena*/);
                        send(msm);  
                    }     
                    else if (humd >70 && humd <=100)
                    {
                        //mjss="Pegajoso";
                        
                       respuesta.setContent("pegajoso"/*+":"+cadena*/);
                        send(msm);  
                    } else 
                    {  
                        //mjss="Fuerarango";
                        System.out.println("Humedad fuera de rango");
                    }
                  // System.out.println("Enviando humedad a compresor");
              }
            }else 
           {
           block();
           }
           // System.out.println("Humedad: "+mjss);
        }  
    }    
}

