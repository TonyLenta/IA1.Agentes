/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TareaMessaguers;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;

/**
 *
 * @author tony_
 */
public class humedad extends Agent{
    

    class ReceptorComportamiento extends SimpleBehaviour {

        private boolean fin = false;

        public void action() {
            block();
            System.out.println("Preparando para recibir..");
            ACLMessage hms = receive();
            if (hms != null) {
                System.out.println(getLocalName() + " acaba de recibir el siguiente mensaje.");
                System.out.println(hms.toString());
                ACLMessage ms2h = hms.createReply();
                ms2h.setPerformative(ACLMessage.INFORM);
                float humd;
                humd = (int) (Math.random() * 40) + 1;
                
                
                
                if (humd >=0 && humd <=20) {
                                // Si la temperatura es mayor que 25 ...
                                ms2h.setContent("ambiente seco");
                            send(ms2h); 
                            } else if (humd >20 && humd <=40) {
                                // si es mayor que 15 y no es mayor que 25 ..
                                ms2h.setContent("ambiente confortable");  
                                send(ms2h); 
                            } else if (humd >40 && humd <=70) {
                                // si es menor que 5 y esta nevando y no es mayor que 15 ni mayor que 25
                                ms2h.setContent("ambiente confortable");  
                                send(ms2h); }
                                
                                 else if (humd >70 && humd <=100) {
                                // si es menor que 5 y esta nevando y no es mayor que 15 ni mayor que 25
                                ms2h.setContent("ambiente confortable");  
                                send(ms2h); 

                            } else {
                                // si la tempera  no es mayor que 25 ni que 15 ni menor que 5 si esta nevando
                                System.out.println("Humedad fuera de rango");
                            }
            }
        }
        
        public boolean done() {
            return fin;
        }
    }

    public void setup() {

        addBehaviour(new ReceptorComportamiento());
    }

    
}