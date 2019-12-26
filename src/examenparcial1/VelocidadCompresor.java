/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenparcial1;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;

/**
 *
 * @author MI PC
 */
public class VelocidadCompresor extends Agent{
String nombre="";
    public void setup(){
       
        addBehaviour(new CyclicBehaviour(){
            public void action(){
		String descripcion="";
                ACLMessage msg = receive();
                Random rn = new Random();
                int  temperatura = rn.nextInt(100) + 1;

		

		if(temperatura<30){
			descripcion="apagado";
 		}else{
			if(temperatura>30 && temperatura<50){
			descripcion="bajo";
 		}else{
			if(temperatura>50 && temperatura<70){
			descripcion="medio";
 		}else{
			if(temperatura>70 && temperatura<100){
			descripcion="rapido";
 		}
			
		}
			
		}
		}

                if(msg.getContent().equals("velocidad")){
				 ACLMessage ms4 = msg.createReply();
                   		 ms4.setPerformative(ACLMessage.INFORM);
                    		//enviar la palabra temperatura1
                    		ms4.setContent("description");
                    		send(ms4);
		}else{
                    block();
                }
                
                
            }
        });
    }
}