/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen;
import examenparcial1.*;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
/**
 *
 * @author MI PC
 */

/*
public class fusionTemperatura extends Agent{
public void setup(){
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action(){
                double T=0, TR=0, I=0, P=0;
                System.out.println("Coordinador de  Temperatura."
                        + "\n temperaturas de las localidades... ");
                //Mens Temperatura Sala
                ACLMessage T1 = new ACLMessage(ACLMessage.INFORM);
                T1.setContent("Temperatura1");
                T1.addReceiver(new AID("Temperatura1",AID.ISLOCALNAME));
                send(T1);
                //Resp Temp Sala
                ACLMessage ra1 = receive();
                if (ra1!=null){         
                    System.out.println("Temperatura1: "+ra1.getContent());  
                    TR = Integer.parseInt(ra1.getContent());
                    T=T+TR;
                    I++;
                }else{ 
                    block();
                }
                //Mens Temp Comedor
                ACLMessage T2 = new ACLMessage(ACLMessage.INFORM);
                T2.setContent("Temperatura de la Comedor");
                T2.addReceiver(new AID("Temperatura2 ",AID.ISLOCALNAME));
                send(T2);
                //Resp Temp Comedor
                ACLMessage ra2 = receive();
                if (ra2!=null){         
                    System.out.println("Temperatura2: "+ra2.getContent()
                    + "\n--------------------------------------------------");  
                    TR = Integer.parseInt(ra2.getContent());
                    T=T+TR;
                    I++;
                }else{ 
                    block();
                }
                
                //Promedios:
                P=T/I;
                System.out.println("Promedio de Temperatura total: "+P);
            }
        });
    }
    
}*/

public class fusionTemperatura extends Agent{
    
    public void setup (){
        addBehaviour(new ReceptorComportamiento());
        
    }
    
    public class ReceptorComportamiento extends CyclicBehaviour{
          boolean fin = false;
           int tempconv=0; 
           int ac1=0,ac2,c1=0,c2=0;
           float primedio=0;
        public  void action(){
                      
            
            AID id=new AID();
            //id.setLocalName("temperatura1");
            ACLMessage msm=new ACLMessage(ACLMessage.AGREE);
           System.out.println(getLocalName()+" solicita temperatura 1");
            msm.addReceiver(id);
            msm.setContent("solicitotemperatura");
            send(msm);
         
           // System.out.println(msm.toString());
                
            ACLMessage respuesta = blockingReceive();
            if(respuesta!=null){
                
                System.out.println(respuesta.toString());
                
                tempconv = Integer.parseInt(respuesta.getContent());
                ac1=ac1+tempconv;
                c1++;
                System.out.println("Este es el valor obtenido de tem1"+tempconv);
                fin=true;
            }     
            
            
            
            
            id.setLocalName("temperatura2");
            ACLMessage msm2=new ACLMessage(ACLMessage.AGREE);
           System.out.println(getLocalName()+" solicita temperatura 2");
            msm2.addReceiver(id);
            msm2.setContent("solicitotemperatura2");
            send(msm2);
         
           // System.out.println(msm.toString());
                
            ACLMessage respuesta2 = blockingReceive();
            if(respuesta2!=null){
                
                System.out.println(respuesta2.toString());
                
                tempconv = Integer.parseInt(respuesta2.getContent());
                ac2=ac2+tempconv;
                c2++;
                System.out.println("Este es el valor obtenido de tem1"+tempconv);
                fin=true;
            }         
            
            primedio=(ac1+ac2)/c2;
            System.out.println("Promedio de es :"+primedio);
        }
       
    }
    
    
    
    
}


