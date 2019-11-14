/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes_jade;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author tony_
 */
public class Receptor extends Agent{
    
    public void setup (){
        addBehaviour(new ReceptorComportamiento());
        
    }
    
    public class ReceptorComportamiento extends SimpleBehaviour{
         private boolean fin=false;
         
         public void action(){
             block();
             System.out.println("Esperando a recibir mensaje.");
             ACLMessage msm=receive();
             if (msm!=null){
                 System.out.println(getLocalName()+"acaba de recibir un mensaje");
                 System.out.println(msm.toString());
                 System.out.println(msm.getContent());
                 
                 ACLMessage respuesta = msm.createReply();
                 respuesta.setPerformative(ACLMessage.INFORM);
                 respuesta.setContent("Hi! fine thanks");
                 send(respuesta);
                 fin=true;
                 
             }
         }
        public boolean done(){
        return fin;
        }
    }
    
    
    
    
}
