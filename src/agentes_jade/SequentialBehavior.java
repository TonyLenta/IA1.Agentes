/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes_jade;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;

/**
 *
 * @author tony_
 */
public class SequentialBehavior extends Agent{
    protected void setup(){
    SequentialBehaviour sb = new SequentialBehaviour();
    sb.addSubBehaviour (new OneShot (1));
    sb.addSubBehaviour(new OneShot (2));
    sb.addSubBehaviour(new OneShot (3));
    sb.addSubBehaviour(new OneShot (4));
    sb.addSubBehaviour(new OneShot (5));
        addBehaviour(sb);
    }
    private class OneShot extends OneShotBehaviour{
    // Creacion del contrusctor 
        private int id=0;
        public OneShot(int arg){
        this.id=arg;
        }
        
        public void action(){
            System.out.println("Ejecucion del subcomportamiento "+id);
        }
       
    }
}
