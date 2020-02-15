/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemaTiempoRealAgente.Main;

/**
 *
 * @author tony_
 */

import jade.core.Runtime;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.*;

public class AppMain 
{
    public static void main(String args[]) throws StaleProxyException 
    {          
        Runtime rt = Runtime.instance();
	rt.setCloseVM(true);
	// Create a default profile
	Profile profile = new ProfileImpl("localhost", 1069, "main");
	AgentContainer mainContainer = jade.core.Runtime.instance().createMainContainer(profile);
        AgentController rma1 = null;
        AgentController rma2 = null;
        AgentController rma3 = null;
        AgentController rma4 = null;
        AgentController rma5 = null;
        
	try 
        {
              //Agente Fucion temperatura
         //   rma3 = mainContainer.createNewAgent("fusion", "SystemaTiempoRealAgente.Agentes.AgenteFusion", new Object[0]);
          //  rma3.start();
               /**********************Probando**********************/
            //Agente humedad   
            rma2 = mainContainer.createNewAgent("humedad", "SystemaTiempoRealAgente.Agentes.AgenteHumedad", new Object[0]);
            rma2.start();
            
            //Agente Compresor
            rma1 = mainContainer.createNewAgent("compresor", "SystemaTiempoRealAgente.Agentes.AgenteVelocidadCompresor", new Object[0]);
            rma1.start();
            
             
            
            
          
           
            
            // Agente temperatura 1
           rma4 = mainContainer.createNewAgent("temperatura", "SystemaTiempoRealAgente.Agentes.AgenteTemperatura1", new Object[0]);
           rma4.start();
          
            //Agente temperatura 2
            rma5 = mainContainer.createNewAgent("temperatura2", "SystemaTiempoRealAgente.Agentes.AgenteTemperatura2", new Object[0]);
            rma5.start();  
  
            
             
        } 
        catch (StaleProxyException e) 
        {
            e.printStackTrace();
	}
     }
}
