/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemaTiempoRealAgente.Agentes;


import SystemaTiempoRealAgente.Comportamientos.CiclicoFusion;
import jade.core.Agent;


/**
 *
 * @author tony_
 */
public class AgenteFusion extends Agent
{   
    public void setup()
    {
        System.out.println("Iniciando agente "+getLocalName());
        CiclicoFusion fusion = new CiclicoFusion();
        addBehaviour(fusion) ;
        
        
    }
    public void takedown()
    {
    
        System.out.println("Finalizando..");
    }
    
    
   
}
