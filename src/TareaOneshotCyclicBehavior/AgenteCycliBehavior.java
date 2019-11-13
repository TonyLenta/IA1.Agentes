/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TareaOneshotCyclicBehavior;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

/**
 *
 * @author tony_
 */
import jade.core.behaviours.CyclicBehaviour;
import java.util.Random;
public class AgenteCycliBehavior extends Agent{
    
     public void setup(){
    
              MyCyclicBehavior c = new MyCyclicBehavior();
              addBehaviour(c);
        
    }
    protected void takeDown(){
        System.out.println("Ejecucion finalzada.");
    }

    private class MyCyclicBehavior extends CyclicBehaviour{
    public void action(){
        System.out.println("Ejecucion del comportamiento CyclicBehavior de temperatura");   
        Random aletorio =new Random();
         int temperatura =1+aletorio.nextInt(50);
         System.out.println("Temperatura del ambiente:"+temperatura);
         if(temperatura>=30){
             System.out.println("Aire encendido.");
         }else{
             System.out.println("Aire apagado.");
         }
         
         
        //myAgent.doDelete();
    }
    }
}
