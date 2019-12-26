package Examen.ExamenTarea;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
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
        
        
        boolean finis=false;
        
        public void action()
        {  
            String msjfusiontemp="", msjhumeda="";    
            AID id=new AID();
            
            
           //Llama a agente fusion temperatura            
            ACLMessage msm2=new ACLMessage(ACLMessage.AGREE);
            id.setLocalName("fusion");            
            //System.out.println(getLocalName()+" solicita temperatura 1");
            msm2.addReceiver(id);
            msm2.setContent("solicitofuciontemperatura");
            send(msm2);
            ACLMessage respuesta2 = blockingReceive();   
            if(msm2!=null)
            {
                msjfusiontemp=respuesta2.getContent();
               System.out.println("Temperatura: "+msjfusiontemp);
            }
            else
            {
                block();
            }       
            
            //Llama agente humedad            
            id.setLocalName("humedad");            
            ACLMessage msm=new ACLMessage(ACLMessage.AGREE);
            msm.addReceiver(id);
            msm.setContent("solicitohumedad");
            send(msm);
            ACLMessage respuesta = blockingReceive();
            if(msm!=null)
            {
                msjhumeda=respuesta.getContent();
                System.out.println("Humedad: "+msjhumeda);
            }
            else
            {
                block();
            }          
            String msj="";
            System.out.println(msjfusiontemp+" && "+msjhumeda);
             //#1 Apagado
            if(msjfusiontemp.equals("mbajo") && msjhumeda.equals("seco"))
            {
                msj="Apagado";
            }
            //#2 
            else if(msjfusiontemp.equals("mbajo") && msjhumeda.equals("confortable"))
            {
                msj="Apagado";
            }
            //#3
            else if(msjfusiontemp.equals("mbajo") && msjhumeda.equals("humedo"))
            {
                msj="Apagado";
            }
            //#4 Bajo
            else if(msjfusiontemp.equals("mbajo") && msjhumeda.equals("pegajoso"))
            {
                msj="Bajo";
            }
            //#5 apagdo
            else if(msjfusiontemp.equals("bajo") && msjhumeda.equals("seco"))
            {
                msj="Apagado";
            }
            //#6 apagado
            else if(msjfusiontemp.equals("bajo") && msjhumeda.equals("confortable"))
            {
                msj="Apagado";
            }
            //#7 bajo
            else if(msjfusiontemp.equals("bajo") && msjhumeda.equals("humedo"))
            {
                msj="Bajo";
            }
            //#8 
            else if(msjfusiontemp.equals("bajo") && msjhumeda.equals("pegajoso"))
            {
                msj="Medio";
            }
            //#9 
            else if(msjfusiontemp.equals("alto") && msjhumeda.equals("seco"))
            {
                msj="Bajo";   
            }
            //#10 
            else if(msjfusiontemp.equals("alto") && msjhumeda.equals("confortable"))
            {
                msj="Medio";
            }
            //#11 
            else if(msjfusiontemp.equals("alto") && msjhumeda.equals("humedo"))
            {
                msj="Rapido";              
            }
            //#12 
            else if(msjfusiontemp.equals("alto") && msjhumeda.equals("pegajoso"))
            {
                msj="Rapido";
            }
            //#13 
            else if(msjfusiontemp.equals("malto") && msjhumeda.equals("seco"))
            {
                msj="Medio";
            }
            //#14 
            else if(msjfusiontemp.equals("malto") && msjhumeda.equals("confortable"))
            {
                msj="Rapido";
            }
            //#15 
            else if(msjfusiontemp.equals("malto") && msjhumeda.equals("humedo"))
            {
                msj="Rapido";
               // System.out.println("Rapido");
            }
            
            System.out.println("Estado del compresor: "+msj);
         
       } 
    }       
}

