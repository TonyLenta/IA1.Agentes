package Examen;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;

/**
 *
 * @author tony_
 */

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import java.util.Random;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

/**
 *
 * @author tony_
 */
import jade.core.behaviours.CyclicBehaviour;
import java.util.Random;
public class temperatura1 extends Agent{
    
     public void setup(){
    
              MyCyclicBehavior c = new MyCyclicBehavior();
              addBehaviour(c);
              
        
    }
    protected void takeDown(){
        System.out.println("Ejecucion finalzada.");
    }

    private class MyCyclicBehavior extends CyclicBehaviour{
       
    public void action(){
        
        //Creacion de temperatura aletoria
       
        Random aletorio =new Random();
         int temp =1+aletorio.nextInt(100);
       
              
               block();
         
         System.out.println("Temperatura1 1 lista ");
         
         ACLMessage msm=receive();
         if (msm!=null){
             
               if(msm.getContent().equals("solicitotemperatura")==true)
               {         
                 ACLMessage respuesta = msm.createReply();
                 respuesta.setPerformative(ACLMessage.REQUEST);
                 respuesta.setContent(String.valueOf(temp));
                 send(respuesta);
                 
             
             }
         }
         
         
         
         //********************************************
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         /*
    
                if (temp>=0 && temp <=10) {
                            //envia mensaje
                            infotem="Temperatura1 muy baja, es de :"+temp;
                            msm.setContent(infotem);
                            send(msm); System.out.println("Enviando temperatura a AgenteFusion");
                            System.out.println(msm.toString());
                            
                            //comprueba si recepto el mensaje
                            ACLMessage respuesta = blockingReceive();
                            if(respuesta!=null){
                                System.out.println(getLocalName()+"acaba de recibir un mensaje");
                                System.out.println(respuesta.toString());
                                fin=true;
                            } 
                            
                            
                        
                        // System.out.println("Temperatura1 muy baja");
                            } else if (temp >10 && temp <=25) {
                                
                                
                            infotem="Temperatura1 bajo, es de :"+temp;
                             msm.setContent(infotem);
                            send(msm); 
                            System.out.println("Enviando mensaje a receptor");
                             System.out.println(msm.toString());
                             
                              //comprueba si recepto el mensaje
                            ACLMessage respuesta = blockingReceive();
                            if(respuesta!=null){
                                System.out.println(getLocalName()+"acaba de recibir un mensaje");
                                System.out.println(respuesta.toString());
                                fin=true;
                            } 
                            //System.out.println("Temperatura1 bajo");
                            } else if (temp >25 && temp <=35) {
                                 infotem="Temperatura1 alta, es de :"+temp;
                                msm.setContent(infotem);
                                send(msm); 
                               // System.out.println("Temperatura1 alta");
                                            System.out.println("Enviando mensaje a receptor");
                                 System.out.println(msm.toString());
                                  //comprueba si recepto el mensaje
                            ACLMessage respuesta = blockingReceive();
                            if(respuesta!=null){
                                System.out.println(getLocalName()+"acaba de recibir un mensaje");
                                System.out.println(respuesta.toString());
                                fin=true;
                            } 
                            }                            
                                 else if (temp >35 && temp <=100) {
                                infotem="Temperatura1 muy alta,es de :"+temp;
                                msm.setContent(infotem);
                                send(msm); 
                                System.out.println("Enviando mensaje a receptor");
                                System.out.println(msm.toString());
                                 // System.out.println("Temperatura1 muy alta");
                            } else {
                                  infotem="Temperatura1 fuera rango";
                                  msm.setContent(infotem);
                                  send(msm);
                                  System.out.println("Enviando mensaje a receptor");
                                  System.out.println(msm.toString());
                                   //comprueba si recepto el mensaje
                            ACLMessage respuesta = blockingReceive();
                            if(respuesta!=null){
                                System.out.println(getLocalName()+"acaba de recibir un mensaje");
                                System.out.println(respuesta.toString());
                                fin=true;
                            } 
                               // System.out.println("temperatura de rango");
                            }
                
                
                
           */
         
            
            
            }
      
         
        //myAgent.doDelete();
    }
    
    
    
    
}
    

 
     

