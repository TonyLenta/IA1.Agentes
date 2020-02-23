/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgenteComportamiento.Comportamientos;

import jade.core.behaviours.SimpleBehaviour;

/**
 *
 * @author tony_
 */
public class ComportamiendoSimpleResta extends SimpleBehaviour{
    boolean finished = true;
    public void action()
    {
        System.out.println("Ejecucion del comportamiento Resta");    
       // myAgent.doDelete();
       
    }
    
    public boolean done(){
    return finished;
    }
}
