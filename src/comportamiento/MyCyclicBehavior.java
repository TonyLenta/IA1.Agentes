/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comportamiento;

import jade.core.behaviours.CyclicBehaviour;

/**
 *
 * @author tony_
 */
public class MyCyclicBehavior extends CyclicBehaviour{
    
      
    public void action(){
        System.out.println("Ejecucion del comportamiento CyclicBehavior");    
        myAgent.doDelete();
    
    }
    
    
}
