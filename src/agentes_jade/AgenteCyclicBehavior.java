/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes_jade;

import comportamiento.MyCyclicBehavior;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.*;
import jade.core.*;
/**
 *
 * @author tony_
 */
public class AgenteCyclicBehavior  extends Agent{
    
   public void setup(){
    
              MyCyclicBehavior c = new MyCyclicBehavior();
              addBehaviour(c);
        
    }
    protected void takeDown(){
        System.out.println("Ejecucion finalzada.");
    }

   /* private class MyCyclicBehavior extends CyclicBehaviour{
    public void action(){
        System.out.println("Ejecucion del comportamiento CyclicBehavior");    
        myAgent.doDelete();
    }
    }*/
}
