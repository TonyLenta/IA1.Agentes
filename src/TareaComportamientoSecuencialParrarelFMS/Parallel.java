/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TareaComportamientoSecuencialParrarelFMS;


import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;

/**
 *
 * @author tony_
 */
public class Parallel extends Agent{

  protected void setup(){
        ParallelBehaviour sb = new ParallelBehaviour(ParallelBehaviour.WHEN_ALL);
         sb.addSubBehaviour(new MyBehavior("A",5));//argumento comportmaiento
         sb.addSubBehaviour(new MyBehavior("B",4));
         sb.addSubBehaviour(new MyBehavior("C",3));
         addBehaviour(sb);
    }
    private class MyBehavior extends Behaviour{
        private int cycle,currentcycle;
        private String id;
        public MyBehavior(String a_id,int a_cycle){
            this.id=a_id;
            this.cycle=a_cycle;
            this.currentcycle=0;
        }
        public void action(){
            System.out.println("Comportamineto "+ id +" ejecutando ciclo "+ ++currentcycle);
        }
        public boolean done(){
            return(currentcycle==cycle);
        }
    }
}
