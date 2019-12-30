/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen.ExamenTarea.ContaminacionAire;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

/**
 *
 * @author tony_
 */
public class AppMain 
{
      public static void main(String args[]) throws StaleProxyException 

     {  
         jade.core.Runtime rt = jade.core.Runtime.instance();
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
                //Agente NO2
                rma1 = mainContainer.createNewAgent("no", "Examen.ExamenTarea.ContaminacionAire.NO2", new Object[0]);
		rma1.start();    
                //Agente SO2
		rma2 = mainContainer.createNewAgent("so", "Examen.ExamenTarea.ContaminacionAire.SO2", new Object[0]);
		rma2.start(); 
                //Agente AQI
		rma3 = mainContainer.createNewAgent("aqi", "Examen.ExamenTarea.ContaminacionAire.AQI", new Object[0]);
		rma3.start(); 
        } catch (StaleProxyException e) 
        {
            e.printStackTrace();   
        }
     }
}
