package Examen;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;

/**
 *
 * @author tony_
 */


import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import java.util.Random;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

/**
 *
 * @author tony_
 */
import jade.core.behaviours.CyclicBehaviour;
import java.util.Random;
public class temperatura2 extends Agent{
    
     public void setup(){
    
              MyCyclicBehavior c = new MyCyclicBehavior();
              addBehaviour(c);
        
    }
    protected void takeDown(){
        System.out.println("Ejecucion finalzada.");
    }

    private class MyCyclicBehavior extends CyclicBehaviour{
        boolean fin = false;
    public void action(){
       
        
        
        Random aletorio =new Random();
         int temp =1+aletorio.nextInt(100);
         block();
         
         System.out.println("Temperatura1 2 lista ");
         
         ACLMessage msm=receive();
         if (msm!=null){
             
               if(msm.getContent().equals("solicitotemperatura2")==true)
               {         
                   
               }
                 ACLMessage respuesta = msm.createReply();
                 respuesta.setPerformative(ACLMessage.INFORM);
                 respuesta.setContent(String.valueOf(temp));
                 send(respuesta);
                 
             
             }  
         
         }
        
        
        /*
        System.out.println("Ejecucion del comportamiento CyclicBehavior de temperatura2");   
        Random aletorio =new Random();
        String infotem2="";
        int temp2 =1+aletorio.nextInt(50);
        System.out.println("Humedad del ambiente:"+ temp2);
        */
        //*************************************************************
        /*
          //Creando instancia de Emisor
         AID id=new AID();
         //Declarando nombre de agente al que va realizar la funcion de receptor
         id.setLocalName("temperatura2");

            ACLMessage msm2 = new ACLMessage(ACLMessage.REQUEST);
            msm2.setSender(getAID());
            msm2.setLanguage("Español");
            msm2.addReceiver(id);
         
         
         
         if (temp2>=0 && temp2 <=10) {
             
                            infotem2="Temperatura1 muy baja, es de :"+temp2;
                            msm2.setContent(infotem2);
                            send(msm2); System.out.println("Enviando mensaje a receptor");
                            System.out.println(msm2.toString());
                            
                            //comprueba si recepto el mensaje
                            ACLMessage respuesta2 = blockingReceive();
                            if(respuesta2!=null){
                                System.out.println(getLocalName()+"acaba de recibir un mensaje");
                                System.out.println(respuesta2.toString());
                                fin=true;
                            } 
                           
                     
                            } else if (temp2 >10 && temp2 <=25) {
                                 infotem2="Temperatura2 baja, es de :"+temp2;
                            msm2.setContent(infotem2);
                            send(msm2); System.out.println("Enviando mensaje a receptor");
                            System.out.println(msm2.toString());
                            
                            //comprueba si recepto el mensaje
                            ACLMessage respuesta2 = blockingReceive();
                            if(respuesta2!=null){
                                System.out.println(getLocalName()+"acaba de recibir un mensaje");
                                System.out.println(respuesta2.toString());
                                fin=true;
                            } 
                            
                            } else if (temp2 >25 && temp2 <=35) {
                                 infotem2="Temperatura1 alta, es de :"+temp2;
                            msm2.setContent(infotem2);
                            send(msm2); System.out.println("Enviando mensaje a receptor");
                            System.out.println(msm2.toString());
                            
                            //comprueba si recepto el mensaje
                            ACLMessage respuesta2 = blockingReceive();
                            if(respuesta2!=null){
                                System.out.println(getLocalName()+"acaba de recibir un mensaje");
                                System.out.println(respuesta2.toString());
                                fin=true;
                            } 
                                
                                                                
                            }                            
                                 else if (temp2 >35 && temp2 <=100) {
                                infotem2="Temperatura2 muy alta, es de :"+temp2;
                                msm2.setContent(infotem2);
                                send(msm2); System.out.println("Enviando mensaje a receptor");
                                System.out.println(msm2.toString());

                                //comprueba si recepto el mensaje
                                ACLMessage respuesta2 = blockingReceive();
                                if(respuesta2!=null){
                                    System.out.println(getLocalName()+"acaba de recibir un mensaje");
                                    System.out.println(respuesta2.toString());
                                    fin=true;
                                } 
                                    
                            } else {
                                // si la tempera  no es mayor que 25 ni que 15 ni menor que 5 si esta nevando
                                System.out.println("temperatura2 de rango");
                            }
            }
         
      */
    }
 
    
}


