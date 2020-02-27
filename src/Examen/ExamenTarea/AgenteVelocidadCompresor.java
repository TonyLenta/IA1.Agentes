package Examen.ExamenTarea;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author tony_
 */
public class AgenteVelocidadCompresor extends Agent
{ 
   
 public void setup()
    {
        System.out.println("Iniciando agente "+getLocalName());
        ciclico fusion = new ciclico();
        addBehaviour(fusion) ;
        
    }
    public void takedown()
    {
    
        System.out.println("Finalizando..");
    }
        
    private class ciclico extends CyclicBehaviour 
    {
         double boundary;
        public void action()
        {            
            /*Comunicacion agentes*/
            String msjfusiontemp="", msjhumeda="";    
            AID id=new AID();
            
            //Llama agente temp1           
            id.setLocalName("temperatura");            
            ACLMessage msm=new ACLMessage(ACLMessage.AGREE);
            msm.addReceiver(id);
            msm.setContent("solicitotemperatura");
            send(msm);
            ACLMessage respuesta = blockingReceive();
            if(msm!=null)
            {
                msjfusiontemp=respuesta.getContent();
                System.out.println("U1: "+msjfusiontemp);
            }
            else
            {
                block(900000000);
            }
                          
            //Llama agente humedad            
            id.setLocalName("humedad");            
            ACLMessage msm2=new ACLMessage(ACLMessage.AGREE);
            msm2.addReceiver(id);
            msm2.setContent("solicitohumedad");
            send(msm2);
            ACLMessage respuesta2 = blockingReceive();
            if(msm!=null)
            {
                msjhumeda=respuesta2.getContent();
                System.out.println("U2: "+msjhumeda);
            }
            else
            {
                block(900000000);
            }
            
            System.out.println("Factor de utilizacion "+msjfusiontemp+" && "+msjhumeda);
            /*************************************************/
           
            float u1= Float.parseFloat(msjfusiontemp);
            float u2 = Float.parseFloat(msjhumeda);
            float ut;
            ut= u1+u2;
            
         
           if(ut<Ug(2))
        {
            System.out.println("Si es planificable");
        }
        else 
        {
            System.out.println("No es planificable");
        }
           
            
            
       }
        
        public double Ug(int n) {
		boundary = n * ( (Math.pow(2, 1/(double)n) ) - 1);
		System.out.println("Boundary : " + boundary);
                return boundary;
		
	}
        
        
    }       
}

