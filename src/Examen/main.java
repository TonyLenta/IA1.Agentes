
package Examen;

/**
 *
 * @author tony_
 */
import jade.BootProfileImpl;

import jade.core.Runtime;

import jade.core.Profile;

import jade.core.ProfileImpl;

import jade.util.leap.Properties;


import jade.wrapper.*;

public class main {

     public static void main(String args[]) throws StaleProxyException 

     {

  
         

         Runtime rt = Runtime.instance();


	rt.setCloseVM(true);


	// Create a default profile

	Profile profile = new ProfileImpl("localhost", 1069, "main");

	AgentContainer mainContainer = jade.core.Runtime.instance().createMainContainer(profile);




	AgentController rma = null;

	try {

		rma = mainContainer.createNewAgent("humedad", "agentes_jade.humedad", new Object[0]);
		rma.start();
                rma = mainContainer.createNewAgent("temp1", "agentes_jade.temperatura1", new Object[0]);
                rma.start();
                rma = mainContainer.createNewAgent("temp2", "agentes_jade.temperatura2", new Object[0]);
                rma.start();
                rma = mainContainer.createNewAgent("Compresor", "agentes_jade.velocidadCompresor", new Object[0]);
                rma.start();

	} catch (StaleProxyException e) {

		e.printStackTrace();

	}


     }


}