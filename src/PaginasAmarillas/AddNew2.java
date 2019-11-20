/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaginasAmarillas;

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

public class AddNew2 {

     public static void main(String args[]) throws StaleProxyException 

     {

     /*    Properties pp = new Properties();

    pp.setProperty(Profile.MAIN, Boolean.FALSE.toString());

    pp.setProperty(Profile.MAIN_HOST, "127.0.0.1");

    pp.setProperty(Profile.MAIN_PORT, Integer.toString(1099));

    Profile p = new ProfileImpl(pp);

    AgentContainer ac = jade.core.Runtime.instance().createAgentContainer(p);

    

        ac.acceptNewAgent("JumpingAgent", new AgenteBasico()).start();

    */

         

         Runtime rt = Runtime.instance();


	// Exit the JVM when there are no more containers around

	rt.setCloseVM(true);


	// Create a default profile

	Profile profile = new ProfileImpl("localhost", 1069, "main");

	AgentContainer mainContainer = jade.core.Runtime.instance().createMainContainer(profile);




	AgentController rma = null;
        AgentController rma2 = null;
        AgentController rma3 = null;

	try {

		rma = mainContainer.createNewAgent("Agente1", "PaginasAmarillas.Agente1", new Object[0]);
		rma.start();
                
                rma2 = mainContainer.createNewAgent("Agente2", "PaginasAmarillas.Agente2", new Object[0]);
		rma2.start();
                
                rma3 = mainContainer.createNewAgent("Agente3", "PaginasAmarillas.Agente3", new Object[0]);
		rma3.start();

	} catch (StaleProxyException e) {

		e.printStackTrace();

	}


     }


}
