/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen.ExamenTarea.ContaminacionAire;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author tony_
 */
public class AQI extends Agent{
    
    
     public void setup()
    {
    Ciclico c = new Ciclico();
        System.out.println("Iniciando AQI");
        addBehaviour(c);
    }
    
    public void takedown()
    {
        System.out.println("Finalizando..");    
    }
    
    private class Ciclico extends CyclicBehaviour
    {
        public void action()
        {
           String msjgeneral="",msjn02="",msjso2="";
           AID id=new AID();
           
          //Llama a agente fusion temperatura            
            ACLMessage msm2=new ACLMessage(ACLMessage.AGREE);
            id.setLocalName("no");            
            //System.out.println(getLocalName()+" solicita temperatura 1");
            msm2.addReceiver(id);
            msm2.setContent("solicitono2");
            send(msm2);
            ACLMessage respuesta2 = blockingReceive();   

            if (respuesta2!=null)
            {
                msjn02=respuesta2.getContent();
                //System.out.println("NO2: "+msjn02);
            
                
            }
            else
            {
                block();
            }
            
            
             //Llama a agente fusion temperatura            
            ACLMessage msm=new ACLMessage(ACLMessage.AGREE);
            id.setLocalName("so");            
            //System.out.println(getLocalName()+" solicita temperatura 1");
            msm.addReceiver(id);
            msm.setContent("solicitoso2");
            send(msm);
            ACLMessage respuesta = blockingReceive();   

            if (respuesta!=null)
            {
                msjso2=respuesta.getContent();
              //  System.out.println("SO2: "+msjso2);
                
            }
            else
            {
                block();
            }
            
            System.out.println("NO2: "+msjn02 +","+" SO2: "+msjso2);
            
            if(msjn02.equals("good") && msjso2.equals("good"))
            {
                msjgeneral="very healthy";
               // System.out.println("Estado: ");
            }
            else if(msjn02.equals("good") && msjso2.equals("moderate"))
            {
                msjgeneral="medium";
               // System.out.println("Estado: ");
            }
            else if(msjn02.equals("good") && msjso2.equals("poor"))
            {
                msjgeneral="unhealthy";
               // System.out.println("Estado: ");
            }
            else if(msjn02.equals("moderate") && msjso2.equals("good"))
            {
                msjgeneral="healthy";
               // System.out.println("Estado: ");
            }
            else if(msjn02.equals("moderate") && msjso2.equals("moderate"))
            {
                msjgeneral="medium";
               // System.out.println("Estado: ");
            }
            else if(msjn02.equals("moderate") && msjso2.equals("poor"))
            {
                msjgeneral="unhealthy";
               // System.out.println("Estado: ");
            }else if(msjn02.equals("poor") && msjso2.equals("good"))
            {
                msjgeneral="medium";
               // System.out.println("Estado: ");
            }
            else if(msjn02.equals("poor") && msjso2.equals("moderate"))
            {
                msjgeneral="unhealthy";
               // System.out.println("Estado: ");
            }
            else if(msjn02.equals("poor") && msjso2.equals("poor"))
            {
                msjgeneral="very unhealthy";
               // System.out.println("Estado: ");
            }else 
            {
                System.out.println("Error");
            }
            
            
            System.out.println("Estado del aire: "+msjgeneral);
        
        }
    
    }
    
}
