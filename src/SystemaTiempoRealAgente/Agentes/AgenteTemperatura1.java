/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemaTiempoRealAgente.Agentes;

import jade.core.Agent;
import SystemaTiempoRealAgente.Comportamientos.CiclicloTemperatura1;

/**
 *
 * @author tony_
 */
public class AgenteTemperatura1  extends Agent
{
    
   protected void setup()
   {
       System.out.println("Iniciando agente "+getLocalName());      
       CiclicloTemperatura1 temperatura1 = new CiclicloTemperatura1();
       addBehaviour(temperatura1);
   }

   protected void takedown ()
   {
       System.out.println("Finalizando..");
   }
   
}
