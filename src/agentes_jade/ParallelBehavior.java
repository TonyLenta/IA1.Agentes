/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes_jade;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;

/**
 *
 * @author tony_
 */
public class ParallelBehavior extends Agent{
    protected void setup(){
    ParallelBehaviour sb =new ParallelBehaviour(ParallelBehaviour.WHEN_ALL);
    sb.addSubBehaviour(new MyBehavior(1,3));
    sb.addSubBehaviour(new MyBehavior(2,4));
    sb.addSubBehaviour(new MyBehavior(3,2));
        addBehaviour(sb);
         
    }
    private class MyBehavior extends Behaviour{
    //constructor
        private int id,cycle,currentcycle;
        public  MyBehavior (int a_id, int a_cycle){
        this.id=a_id;
        this.cycle=a_cycle;
        this.currentcycle=0;
        }
        
        public void action(){
            System.out.println("Comportamiento: "+id+" ejecutando ciclo "+ ++currentcycle);
        }
        
        public boolean done(){
        return(currentcycle==cycle);
        }
    
        
        
        
    }
    
}
