/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TareaMessaguers;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.core.AID;
import java.util.Scanner;

/**
 *
 * @author tony_
 */
public class Emisor  extends Agent{
    
    class EmisorComportamiento extends SimpleBehaviour {

        private boolean fin = false;

        public void action() {
            
            Scanner entrada = new Scanner(System.in);
            boolean salir = false;
            int y;
            System.out.println("Comunicacion de agentes");
            System.out.println("        Menu");
            System.out.println("1. Calcule la temperatura:");
            System.out.println("2. Calcule la humedad:");
            System.out.println("3. Pruebe enviando un saludo:");
            System.out.println("Elija la opcion: ");
            y = entrada.nextInt();
            switch (y) {
                case 1:
                    System.out.println(getLocalName() + "Preparando para enviar mensaje");
                    AID id = new AID();
                    id.setLocalName("ReceptorTemperatura");
                    ACLMessage mst = new ACLMessage(ACLMessage.INFORM);
                    mst.setSender(getAID());
                    mst.addReceiver(id);
                    mst.setContent("Temperatura");
                    send(mst);
                    System.out.println(mst.toString());
                    ACLMessage ms2 = blockingReceive();
                    if (ms2 != null) {
                        System.out.println(getLocalName() + " acaba de recibir el mensaje" + ms2);
                        fin = true;
                    }
                    break;
                case 2:
                    System.out.println(getLocalName() + "Preparando para enviar mensaje");
                    AID id2 = new AID();
                    id2.setLocalName("ReceptorHumedad");
                    ACLMessage msh = new ACLMessage(ACLMessage.INFORM);
                    msh.setSender(getAID());
                    msh.addReceiver(id2);
                    msh.setContent("Humedad");
                    send(msh);
                    System.out.println(msh.toString());
                    ACLMessage ms2h = blockingReceive();
                    if (ms2h != null) {
                        System.out.println(getLocalName() + " acaba de recibir el mensaje" + ms2h);
                        fin = true;
                    }
                    break;
                case 3:
                    System.out.println(getLocalName() + "Preparando para enviar mensaje");
                    AID id3 = new AID();
                    id3.setLocalName("ReceptorSaludo");
                    ACLMessage mss = new ACLMessage(ACLMessage.INFORM);
                    mss.setSender(getAID());
                    mss.addReceiver(id3);
                    mss.setContent("Hi!");
                    send(mss);
                    System.out.println(mss.toString());
                    ACLMessage ms2s = blockingReceive();
                    if (ms2s != null) {
                        System.out.println(getLocalName() + " acaba de recibir el mensaje" + ms2s);
                        fin = true;
                    }
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        }

        public boolean done() {
            return fin;
        }
    }

    public void setup() {

        addBehaviour(new EmisorComportamiento());
    }
        
}
