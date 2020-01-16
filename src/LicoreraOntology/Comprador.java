package LicoreraOntology;

import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import jade.domain.FIPANames;
import java.util.Scanner;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.*;
import jade.content.onto.basic.*;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREResponder;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.NotUnderstoodException;
import jade.domain.FIPAAgentManagement.RefuseException;
import jade.domain.FIPAAgentManagement.FailureException;
import jade.core.Agent;
import jade.core.AID;
import jade.lang.acl.*;
import jade.proto.AchieveREInitiator;
import jade.domain.FIPANames;
import jade.content.*;
import jade.content.lang.*;
import jade.content.lang.sl.*;
import jade.content.onto.*;
import jade.content.onto.basic.*;
import java.io.*;

public class Comprador extends Agent  {

    private Codec codec = new SLCodec();
    private Ontology ontologia = LicoreriaOntologia.getInstance();

    protected void setup() {

        try {

            Object[] args = getArguments();
            if (args != null && args.length > 0) {

                System.out.println("Comprador ingresando y solicitando licor..");
                ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);

                for (int i = 0; i < args.length; i++) {
                    msg.addReceiver(new AID((String) args[i], AID.ISLOCALNAME));
                }

                // Se establece el protocolo de comunicaciones
                msg.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);

                // Se establece el lenguaje de contenido y la ontología del mensaje.
                msg.setLanguage(codec.getName());
                msg.setOntology(ontologia.getName());

                // Obtener los detalles del licor a comprar
                try {
                    BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
                    Licor l = new Licor();
                    Descripcion d = new Descripcion();
                    
                    System.out.println("");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("    INTRODUCE los detalles del licor:");
                    System.out.print("      Nombre --> ");
                    d.setNombre(buff.readLine());
                    System.out.print("      Precio ($) ---> ");
                    d.setPrecio(new Double(buff.readLine()));
                    System.out.print("      Pais -----> ");
                    d.setPaisOrigen(new String(buff.readLine()));
                    l.setDescripcion(d);

                    System.out.println("");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("");

                    // Crea la accion VentaEfectivo
                    VentaEnEfectivo ve = new VentaEnEfectivo();
                    ve.setLicor(l);

                    // Registra el lenguaje de contenido y la ontologia utilizada
                    getContentManager().registerLanguage(codec);
                    getContentManager().registerOntology(ontologia);

                    // Crea la accion a enviar asociándola a la acción Venta en efectivo
                    Action a = new Action(getAID(), ve);

                    // Rellena el mensaje ACL para que sea consistente con el lenguaje de contenido y la ontologia
                    getContentManager().fillContent(msg, a);

                    addBehaviour(new ManejadorInitiator(this, msg));
                } catch (IOException ioe) {
                    System.err.println("Error I/O: " + ioe.getMessage());
                }

            } else {
                System.out.println("Especifique el nombre de al menos algun agente comisaria.");
            }

        } catch (jade.content.lang.Codec.CodecException ce) {
            System.out.println(ce);

        } catch (jade.content.onto.OntologyException oe) {
            System.out.println(oe);
        }
    }

    class ManejadorInitiator extends AchieveREInitiator {

        public ManejadorInitiator(Agent a, ACLMessage msg) {
            super(a, msg);
        }

        protected void handleAgree(ACLMessage agree) {
            try {
                // Decodifica el mensaje ACL recibido mediante el lenguaje de contenido y la ontologia actuales
                ContentElement ce = getContentManager().extractContent(agree);

                if (ce instanceof Disponible) {
                    // Recibido un AGREE con contenido correcto
                    Disponible disp = (Disponible) ce;   // Transforma el contenido en el objeto predicado EstoyDisponible de la ontologia

                    System.out.println("Vendedor " + agree.getSender().getName() + " informa que atendera al cliente. Breve  " + disp.getTiempo().getTiempo() + " minutos");
                } else {
                    System.out.println("Recibido mensaje de tipo AGREE desde tienda " + agree.getSender().getName() + " cuyo contenido no es el esperado.");
                }

            } catch (Exception ce) {
                System.out.println(ce);
            }
        }

        protected void handleInform(ACLMessage inform) {
            try {

                // Decodifica el mensaje ACL recibido mediante el lenguaje de contenido y la ontologia actuales
                ContentElement ce = getContentManager().extractContent(inform);

                if (ce instanceof ProductoVendido) {
                    // Recibido un INFORM con contenido correcto
                    ProductoVendido pv = (ProductoVendido) ce; // Transforma el contenido en el objeto predicado LadronDetenido de la ontologia

                    System.out.println("La tienda " + inform.getSender().getName() + " informa que se ha realizado la venta correctamente!!");
                } else {
                    System.out.println("Recibido mensaje de tipo INFORM desde la tienda " + inform.getSender().getName() + " cuyo contenido no es el esperado.");
                }

            } catch (Exception ce) {
                System.out.println(ce);
            }
        }

        protected void handleRefuse(ACLMessage refuse) {
            try {

                // Decodifica el mensaje ACL recibido mediante el lenguaje de contenido y la ontologia actuales
                ContentElement ce = getContentManager().extractContent(refuse);
                if (ce instanceof NoDisponible) {
                    // Recibido un REFUSE con contenido correcto
                    NoDisponible nd = (NoDisponible) ce; // Transforma el contenido en el objeto predicado NoDisponible de la ontologia

                    System.out.println("La tienda " + refuse.getSender().getName() + " informa que NO realizar la venta. Motivo: " + nd.getMotivo().getMotivo());
                } else {
                    System.out.println("Recibido mensaje de tipo REFUSE desde tienda " + refuse.getSender().getName() + " cuyo contenido no es el esperado.");
                }

            } catch (Exception ce) {
                ce.printStackTrace();
            }
        }

        protected void handleNotUnderstood(ACLMessage notUnderstood) {
            System.out.println("La comisaria " + notUnderstood.getSender().getName() + " no entiende el mensaje.");
        }

    }
}
