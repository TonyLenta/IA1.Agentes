/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemaTiempoRealAgente.Comportamientos;

import SystemaTiempoRealAgente.Agentes.AgenteFusion;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import SystemaTiempoRealAgente.Agentes.AgenteVelocidadCompresor;
import SystemaTiempoRealAgente.Agentes.AgenteHumedad;


/**
 *
 * @author tony_
 */
 public class CiclicoCompresor extends CyclicBehaviour
    {
     public void action()
        {  
            AgenteVelocidadCompresor compre= new AgenteVelocidadCompresor();
            AgenteFusion fusion = new AgenteFusion();
            AgenteHumedad humed= new AgenteHumedad();     
            
            String msjfusiontemp="", msjhumeda="";    
            AID id=new AID();
            
            
            //Llama agente humedad            
            id.setLocalName("humedad");            
            ACLMessage msm=new ACLMessage(ACLMessage.AGREE);
            msm.addReceiver(id);
            msm.setContent("solicitohumedad");             
            compre.send(msm);     
            ACLMessage respuesta2 = compre.blockingReceive();
           
            if(msm!=null)
            {          
               msjhumeda=respuesta2.getContent();              
              
                //System.out.println("Humedad: "+msjhumeda);
            }
            else
            {
                block(900000000);
            }
            
            
            
            //Llama a agente fusion temperatura            
            ACLMessage msm2=new ACLMessage(ACLMessage.AGREE);
            id.setLocalName("fusion");        
            msm2.addReceiver(id);
            msm2.setContent("solicitofuciontemperatura");
            compre.send(msm2);
            ACLMessage respuesta =compre.blockingReceive();   
            if(msm2!=null)
            {
                msjfusiontemp=respuesta.getContent();
               //System.out.println("Temperatura: "+msjfusiontemp);
            }
            else
            {
                block();
            }  
        
            /*************************************************/
            
                   
            String msj="";
            System.out.println("Agente compresor: Fusion temperatrua "+msjfusiontemp+" && "+msjhumeda);
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
                    
            System.out.println("Estado del compresor: "+msjhumeda);
         
       } 

  
    }
