package Examen;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import java.util.Random;

/*
 * Crear un agente humedad que tenga un comportamiento de manera cíclica periódica
   a partir del cual lea el valor de humedad de la habitación donde está instalado  
   un aire acondicionado. Este valor es un valor generado de forma aleatoria en el 
   rango 0-100,donde seco es 0-20, confortable es 20-40, húmedo es de 40-70 y pegajoso es 70-100.
 */





import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

/**
 *
 * @author tony_
 */
import jade.core.behaviours.CyclicBehaviour;
import java.util.Random;
public class humedad extends Agent{
    
     public void setup(){
    
              MyCyclicBehavior c = new MyCyclicBehavior();
              addBehaviour(c);
        
    }
    protected void takeDown(){
        System.out.println("Ejecucion finalzada.");
    }

    private class MyCyclicBehavior extends CyclicBehaviour{
    public void action(){
        System.out.println("Ejecucion del comportamiento CyclicBehavior de humedad");   
        Random aletorio =new Random();
         int humd =1+aletorio.nextInt(50);
         System.out.println("Humedad del ambiente:"+humd);
        
         
         
         
         
         if (humd >=0 && humd <=20) {
                                // Si la temperatura es mayor que 25 ...
                              //  ms2h.setContent("ambiente seco");
                            //send(ms2h); 
                     System.out.println("Ambiente seco");
                            } else if (humd >20 && humd <=40) {
                                // si es mayor que 15 y no es mayor que 25 ..
                               // ms2h.setContent("ambiente confortable");  
                               // send(ms2h); 
                                System.out.println("Ambiente confortable");
                            } else if (humd >40 && humd <=70) {
                                // si es menor que 5 y esta nevando y no es mayor que 15 ni mayor que 25
                               // ms2h.setContent("ambiente confortable");  
                               // send(ms2h); 
                                System.out.println("Ambiente humedo");
                                                                
                            }                            
                                 else if (humd >70 && humd <=100) {
                                // si es menor que 5 y esta nevando y no es mayor que 15 ni mayor que 25
                              //  ms2h.setContent("ambiente confortable");  
                               // send(ms2h); 
                                     System.out.println("Ambiente pegajoso");
                            } else {
                                // si la tempera  no es mayor que 25 ni que 15 ni menor que 5 si esta nevando
                                System.out.println("Humedad fuera de rango");
                            }
            }
         
         
        //myAgent.doDelete();
    }
 
    
}

