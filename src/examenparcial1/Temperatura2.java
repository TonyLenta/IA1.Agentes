/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenparcial1;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;

/**
 *
 * @author MI PC
 */
public class Temperatura2 extends Agent{
String nombre="";
    public void setup(){
       
        addBehaviour(new CyclicBehaviour(){
            public void action(){
		String descripcion="";
                ACLMessage msg = receive();
                Random rn = new Random();
                int  temperatura = rn.nextInt(45) + 1;

		

		if(temperatura<10){
			descripcion="muy bajo";
 		}else{
			if(temperatura>10 && temperatura<25){
			descripcion="bajo";
 		}else{
			if(temperatura>25 && temperatura<35){
			descripcion="alto";
 		}else{
			if(temperatura>35 && temperatura<45){
			descripcion="muy alto";
 		}
			
		}
			
		}
		}

                if(msg.getContent().equals("Temperatura2")){
				 ACLMessage ms3 = msg.createReply();
                   		 ms3.setPerformative(ACLMessage.INFORM);
                    		//enviar la palabra temperatura1
                    		ms3.setContent("description");
                    		send(ms3);
		}else{
                    block();
                }
                
                
            }
        });
    }
}