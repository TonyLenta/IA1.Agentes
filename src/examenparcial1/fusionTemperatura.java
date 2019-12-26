/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenparcial1;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
/**
 *
 * @author MI PC
 */
public class fusionTemperatura extends Agent{
public void setup(){
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action(){
                double T=0, TR=0, I=0, P=0;
                System.out.println("Coordinador de  Temperatura."
                        + "\n temperaturas de las localidades... ");
                //Mens Temperatura Sala
                ACLMessage T1 = new ACLMessage(ACLMessage.INFORM);
                T1.setContent("Temperatura1");
                T1.addReceiver(new AID("Temperatura1",AID.ISLOCALNAME));
                send(T1);
                //Resp Temp Sala
                ACLMessage ra1 = receive();
                if (ra1!=null){         
                    System.out.println("Temperatura1: "+ra1.getContent());  
                    TR = Integer.parseInt(ra1.getContent());
                    T=T+TR;
                    I++;
                }else{ 
                    block();
                }
                //Mens Temp Comedor
                ACLMessage T2 = new ACLMessage(ACLMessage.INFORM);
                T2.setContent("Temperatura de la Comedor");
                T2.addReceiver(new AID("Temperatura2 ",AID.ISLOCALNAME));
                send(T2);
                //Resp Temp Comedor
                ACLMessage ra2 = receive();
                if (ra2!=null){         
                    System.out.println("Temperatura2: "+ra2.getContent()
                    + "\n--------------------------------------------------");  
                    TR = Integer.parseInt(ra2.getContent());
                    T=T+TR;
                    I++;
                }else{ 
                    block();
                }
                
                //Promedios:
                P=T/I;
                System.out.println("Promedio de Temperatura total: "+P);
            }
        });
    }
    
}
