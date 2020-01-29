/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemaTiempoRealAgente.Comportamientos;


import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import SystemaTiempoRealAgente.Agentes.AgenteFusion;
import SystemaTiempoRealAgente.Agentes.AgenteVelocidadCompresor;

/**
 *
 * @author tony_
 */
 public class CiclicoFusion extends CyclicBehaviour
    {
        boolean finis=false;
        float ac=0,ac2=0,c1=0,c2=0,pt=0;
        public void action()
        { 
            AgenteFusion llama = new AgenteFusion();
            AgenteVelocidadCompresor llama2 = new AgenteVelocidadCompresor();
            String mesajecompresor="";
            AID id=new AID();
            
            ac=0;
            ac2=0;
            pt=0;
            c1=0;
            c2=0;   
            
            
            ACLMessage msm6=llama2.receive();
           if(msm6!= null)                
           { 
              if(msm6.getContent().equals("solicitofuciontemperatura")==true)
              {
                  ACLMessage respuesta6 = msm6.createReply(); 
                  //Instancia solicitando temperatura 1
                   ACLMessage msm=new ACLMessage(ACLMessage.AGREE);
                   //Instancia solicitando temperatura 2
                   ACLMessage msm2=new ACLMessage(ACLMessage.AGREE);
                   //llama al primer agente temperatura
                   id.setLocalName("temperatura");            
                    //System.out.println(getLocalName()+" solicita temperatura 1");
                    msm.addReceiver(id);
                    msm.setContent("solicitotemperatura");
                    llama.send(msm);
                    ACLMessage respuesta = llama.blockingReceive();            
                    if(respuesta!=null)
                    {  
                        //Obtiene el valor
                         float temp1 = Float.parseFloat(respuesta.getContent());            
                         c1++;
                         ac=ac+temp1;                        
                        //System.out.println(respuesta.toString());

                    }else
                    {
                        block();
                    }
                    
                    // llama al segundo agente temperatura
                    id.setLocalName("temperatura2");            
                   // System.out.println(getLocalName()+" solicita temperatura 2");
                    msm2.addReceiver(id);
                    msm2.setContent("solicitotemperatura2");
                    llama.send(msm2);         
                    ACLMessage respuesta2 = llama.blockingReceive();
                    if(respuesta2!=null)
                    {
                        float temp2 = Float.parseFloat(respuesta2.getContent());
                        c1++;
                        ac2=ac2+temp2;
                       // System.out.println(respuesta2.toString());
                    }
                    else
                    {
                        block();    
                    } 
                    
                    pt=(ac+ac2)/(c1+c2);
                    System.out.println("Promedio temperaturas 1 y 2 :"+pt);
                   String cadena = Float.toString(pt);
                            if (pt >=0 && pt <=10) 
                                {       
                                   mesajecompresor="mbajo";
                                   //System.out.println("Muy bajo");

                                }
                                else if (pt >10 && pt <=25) 
                                {  
                                   mesajecompresor="bajo";
                                  // System.out.println("Bajo");
                                } 
                                else if (pt >25 && pt <=35) 
                                {   
                                   mesajecompresor="alto";
                                  // System.out.println("Alto");                            
                                }                                                           
                                else if (pt >35 && pt <=100)
                                {  
                                    mesajecompresor="malto";
                                  // System.out.println("Muy alto");
                                }
                                else 
                                {
                                    System.out.println("Temperatura fuera de rango");
                                }
                    respuesta6.setContent(mesajecompresor/*+":"+cadena*/);
                    llama.send(respuesta6);  
                    System.out.println("Estado promedio temperatura: "+mesajecompresor);                   
                    
                    
                    
              }
           }
            else
           {
               block();
           }  
        } 
    }   
