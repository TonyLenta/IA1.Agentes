/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen;

/**
 *
 * @author tony_
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;
/**
/**
 *
 * @author tony_
 */
public class temperatura1 extends Agent {
    
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
                
                
                
                if (tmp >=0 && tmp <=10) {
                                // Si la temperatura es mayor que 25 ...
                                ms2.setContent("muy bajo");
                            send(ms2); 
                            } else if (tmp >10 && tmp <=25) {
                                // si es mayor que 15 y no es mayor que 25 ..
                                ms2.setContent("bajo");  
                                send(ms2); 
                            } else if (tmp >25 && tmp <=25) {
                                // si es menor que 5 y esta nevando y no es mayor que 15 ni mayor que 25
                                ms2.setContent("alto");  
                                send(ms2); }
                                
                                 else if (tmp >35 && tmp <=100) {
                                // si es menor que 5 y esta nevando y no es mayor que 15 ni mayor que 25
                                ms2.setContent("muy alto");  
                                send(ms2); 

                            } else {
                                // si la tempera  no es mayor que 25 ni que 15 ni menor que 5 si esta nevando
                                System.out.println("Temperatura fuera de rango");
                            }
              
                
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