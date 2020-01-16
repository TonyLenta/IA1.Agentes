/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LicoreraOntology;
import LicoreraOntology.*;
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

/**
 *
 * @author josec
 */
public class Vendedor extends Agent {
 
   private Codec codec = new SLCodec();
   private Ontology ontologia = LicoreriaOntologia.getInstance();
   private double EDAD_MIN;
   private double EDAD_CLIENTE;
 
 
   protected void setup()
   {
    EDAD_MIN=18;
    EDAD_CLIENTE=(Math.random()*10);
        System.out.println("[Vendedor "+getLocalName()+"] : Pendiente de avisos...");
 
    // Crea una plantilla que solo acepte los mensajes ACL recibidos que utilizan el protocolo FIPA_REQUEST
        // Y ademas que sean del tipo REQUEST
        // Y ademas que esten codificados mediante el lenguaje de contenido SLCodec
        // Y que utilicen la ontologia policiaOntology
        MessageTemplate protocolo = MessageTemplate.MatchProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
        MessageTemplate performativa = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
        MessageTemplate lenguajeContenido = MessageTemplate.MatchLanguage(codec.getName());
        MessageTemplate ontoTemplate = MessageTemplate.MatchOntology(ontologia.getName());
 
        MessageTemplate plantilla = MessageTemplate.and(MessageTemplate.and(protocolo, performativa),MessageTemplate.and(lenguajeContenido, ontoTemplate));
 
        // Registra el lenguaje de contenido y la ontologia en el gestor de contenidos
        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontologia);
 
        addBehaviour(new ManejadorResponder(this, plantilla));
   }
 
 
   class ManejadorResponder extends AchieveREResponder
   {
 
      public ManejadorResponder(Agent a,MessageTemplate mt)
      {
          super(a,mt);
      }
 
 
      protected ACLMessage prepareResponse(ACLMessage request)
      {
 
        ACLMessage respuesta = request.createReply();
            try
            {
                // Decodifica el mensaje ACL recibido a un objeto de tipo Action mediante el lenguaje de contenido y la ontologia actuales
                Action a = (Action) myAgent.getContentManager().extractContent(request);
                // Recupera el objeto accion de la ontologia
                VentaEnEfectivo ve = (VentaEnEfectivo) a.getAction();
 
        // Recibido un INFORM con contenido correcto
 
                String Nombre=ve.getLicor().getDescripcion().getNombre();
                Double Precio=ve.getLicor().getDescripcion().getPrecio();
                String PaisOrigen=ve.getLicor().getDescripcion().getPaisOrigen();
                Integer Volumen=ve.getLicor().getDescripcion().getVolumen();
 
        System.out.println("[Vendedor "+getLocalName()+"] : Hemos recibido una llamada de " + request.getSender().getName() + " solicitando una compra.");
        System.out.println("[Vendedor "+getLocalName()+"] : Obteniendo edad...");
 
 
                if (EDAD_MIN < EDAD_CLIENTE)
                {
                      System.out.println("[Vendedor "+getLocalName()+"] : Obteniendo licor que responde a la siguiente descripcion:");
                      System.out.println("----------------------------------------");
                      System.out.println("  Nombre:      "+Nombre);
                      System.out.println("  Precio:  "+Precio+" $");
                      System.out.println("  Pais de Origen:    "+PaisOrigen);
                      System.out.println("  Volumen:    "+Volumen+" ml");
                      System.out.println("----------------------------------------");
                      System.out.println("");
 
                      respuesta.setPerformative(ACLMessage.AGREE);
 
                      // Crea un predicado Disponible de la ontologia añadiandole el concepto TiempoLlegada
                      TiempoVenta tv = new TiempoVenta();
                      tv.setTiempo((int)(Math.random()*10));
                      Disponible disp = new Disponible();
                      disp.setTiempo(tv);
 
                      getContentManager().fillContent(respuesta,disp);
              }
              else
              {
                        System.out.println("[Vendedor "+getLocalName()+"]: Cliente menor de edad. Venta rechazada. ");
                        respuesta.setPerformative(ACLMessage.REFUSE);
 
                        // Crea un predicado NoDisponible de la ontologia y le añade el concepto Motivo
                        Motivo m = new Motivo();
                        m.setMotivo("Cliente menor de edad .");
                        NoDisponible nd = new NoDisponible();
                        nd.setMotivo(m);
 
                        getContentManager().fillContent(respuesta, nd);
               }
 
            }catch (Exception ex)
            {
                ex.printStackTrace();
                System.out.println(getLocalName()+": Error manejando la acción de venta en efectivo");
                System.out.println(ex.getMessage().toString());
            }
 
            return respuesta;
    }
 
 
 
    protected ACLMessage prepareResultNotification(ACLMessage request,ACLMessage response)
    {
 
        // Si la policia fue a detener al ladron
        ACLMessage inform = request.createReply();
 
        try
            {
                ContentElement ce = getContentManager().extractContent(response);
 
                Disponible disp = (Disponible)ce;
                System.out.println("[Vendedor "+getLocalName()+"]: Hemos conseguido vender el producto!!");
                inform.setPerformative(ACLMessage.INFORM);
 
                Action a = (Action) myAgent.getContentManager().extractContent(request);
 
                VentaEnEfectivo ve = (VentaEnEfectivo) a.getAction();
                // Crea un predicado LadronDetenido de la ontologia y le añade el ladron detenido
                Formadepagoefectivo fe = new Formadepagoefectivo();
                fe.setEfectivo(ve.getEfectivo());
                getContentManager().fillContent(inform,fe);
 
 
             } catch (Exception ex)
             {
                System.out.println(getLocalName()+": Error manejando el predicado Disponible");
                System.out.println(ex.getMessage().toString());
             }
 
             return inform;
        }
 
    }
}

