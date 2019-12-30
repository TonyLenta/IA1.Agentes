/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes_jade;

import jade.core.Agent;
import jade.core.behaviours.*;

/**
 *
 * @author tony_
 */
public class AgenteOneShotBehavior extends Agent{
    
    public void setup(){
    MyOoneShotBehavior c = new MyOoneShotBehavior();
        addBehaviour(c);
    }
    protected void takeDown(){
        System.out.println("Ejecucion finalzada.");
    }

    private class MyOoneShotBehavior extends OneShotBehaviour{
    public void action(){
        System.out.println("Ejecucion del comportamiento OneShotBehavior");    
       // myAgent.doDelete();
    }
    }
}

