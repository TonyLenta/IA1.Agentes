/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocolos.request;

/**
 *
 * @author tony_
 */
import protocolos.query.*;
import jade.BootProfileImpl;

import jade.core.Runtime;

import jade.core.Profile;

import jade.core.ProfileImpl;

import jade.util.leap.Properties;


import jade.wrapper.*;

public class AddNew3 {

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
        

	try {

		rma = mainContainer.createNewAgent("Hospital1", "protocolos.request.Hospital", new Object[0]);
                rma.start();
                
                rma = mainContainer.createNewAgent("Hospital2", "protocolos.request.Hospital", new Object[0]);
		rma.start(); 
                
                rma2 = mainContainer.createNewAgent("Testigo", "protocolos.request.Testigo", new Object[0]);
		rma2.start();
                
             
	} catch (StaleProxyException e) {

		e.printStackTrace();

	}


     }


}