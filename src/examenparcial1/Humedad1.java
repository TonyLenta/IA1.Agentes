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
 * 
 */
public class Humedad1 extends  Agent{ 
String nombre="";
    public void setup(){
        Object[] args=getArguments();
	
        if(args!=null){
          int i=0;
          String ar1=(String) args[i];
          nombre = String.valueOf(ar1);
        }
        addBehaviour(new CyclicBehaviour(){
            public void action(){
		String descripcion="";
                ACLMessage msg = receive();
                Random rn = new Random();
                int  humedad = rn.nextInt(100) + 1;

		if(humedad<20){
			descripcion="Seco";
 		}else{
			if(humedad>20 && humedad<40){
			descripcion="Confortable";
 		}else{
			if(humedad>40 && humedad<70){
			descripcion="Humedo";
 		}else{
			if(humedad>70 && humedad<100){
			descripcion="Pegajoso";
 		}
			
		}
			
		}
		}
		if(msg!=null){
			 if(msg.getContent().equals("Humedad")){
				 ACLMessage ms2 = msg.createReply();
                   		 ms2.setPerformative(ACLMessage.INFORM);
                    		//enviar la palabra humedad
                    		ms2.setContent("description");
                    		send(ms2);
			 }
		}
            }
        });
    }
}