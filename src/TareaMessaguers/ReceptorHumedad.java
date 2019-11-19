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
public class ReceptorHumedad extends Agent{
    

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
                float humedad;
                humedad = (int) (Math.random() * 100) + 1;
                ms2h.setContent("La Humedad es de: " + humedad);
                send(ms2h);

                System.out.println(getLocalName() + " Enviando mensaje" + ms2h.toString());
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