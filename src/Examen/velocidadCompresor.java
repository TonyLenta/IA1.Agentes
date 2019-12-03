
package Examen;

/**
 *
 * @author tony_
 */



import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.core.AID;
import java.util.Scanner;

/**
 *
 * @author tony_
 */
public class velocidadCompresor  extends Agent{
    
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
            
            System.out.println("Elija la opcion: ");
            y = entrada.nextInt();
            switch (y) {
                case 1:
                    System.out.println(getLocalName() + "Preparando para enviar mensaje");
                    AID id = new AID();
                    id.setLocalName("temperatura1");
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
                    id2.setLocalName("temperatur2");
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
