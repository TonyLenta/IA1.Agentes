package Examen.Examen;

import agentes_jade.*;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author user
 */
//-gui -port 1098 fusion:Examen.AgenteFusion;temp1:Examen.AgenteTemperatura1;temp2:Examen.AgenteTemperatura1
public class AgenteFusion extends Agent {

    long tini;
    int[] fus = new int[2];
    int mitad;

    protected void setup() {
        tini = System.currentTimeMillis();
        addBehaviour(new miTicker(this, 5000));
    }

    private class miTicker extends TickerBehaviour {

        int minticks;

        public miTicker(Agent a, long intervalo) {
            super(a, intervalo);
            minticks = 0;
        }

        protected void onTick() {
            long tfin = System.currentTimeMillis() - tini;
            int nticks = getTickCount(); // obtenemos el numero de ticks desde el último reset
            minticks++;

            String mensaje = "No estoy autorizado para contestar";
            block();
            ACLMessage msm = receive();
            //System.out.println(getLocalName() + " esta esperando recibir un mensaje");
            if (msm != null) {
                //System.out.println("LLego");
                if (msm.getSender().getLocalName().equals("temp1")) {
                    fus[0] = Integer.parseInt(msm.getContent());
                }
                if (msm.getSender().getLocalName().equals("temp2")) {
                    fus[1] = Integer.parseInt(msm.getContent());
                }
                mitad = (fus[0] + fus[1]) / 2;

                if (mitad >= 0 && mitad < 10) {
                    mensaje = "muy bajo";
                } else if (mitad >= 10 && mitad < 25) {
                    mensaje = "bajo";
                } else if (mitad >= 25 && mitad < 35) {
                    mensaje = "alto";
                } else if (mitad >= 35 && mitad <= 45) {
                    mensaje = "muy alto";
                }
                //System.out.println(fus[0]+"----"+fus[1]+"----"+mitad + "ºC es " + mensaje);
            }
            
            mensaje = Integer.toString(mitad);
            
            //------------------ENVIAR
            //System.out.println(getLocalName()+" preparando para enviar mensaje");
            AID id = new AID();
            id.setLocalName("compre");
            
            ACLMessage msm2 = new ACLMessage(ACLMessage.INFORM);
            msm2.setSender(getAID());
            msm2.setLanguage("Español");
            msm2.addReceiver(id);
            msm2.setContent(mensaje);
            send(msm2);
            //System.out.println("Enviando mensaje a "+id.getLocalName());
        }
    }
}
