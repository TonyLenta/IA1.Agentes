
package Examen;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;
/**
/**
 *
 * @author tony_
 */
public class temperatura2 extends Agent {
    
    class ReceptorComportamiento extends SimpleBehaviour{
        
        private boolean fin = false;
        
        public void action(){
            block();
            System.out.println("Preparando para recibir");
            ACLMessage ms = receive();
            if(ms!=null){
                System.out.println(getLocalName()+" acaba de recibir el siguiente mensaje");
                System.out.println(ms.toString());
                ACLMessage ms2 = ms.createReply();
                ms2.setPerformative(ACLMessage.INFORM);
                float tmp;
                tmp = (int) (Math.random() * 40) + 1;
                ms2.setContent("La temperatura es de: "+ tmp  +" °C");
                send(ms2);
                
                System.out.println(getLocalName()+" Enviando mensaje"+ms2.toString());
            }
        }
        public boolean done(){
            return fin;
        }
    }
    public void setup(){
        
        addBehaviour(new ReceptorComportamiento());
    }
    
}