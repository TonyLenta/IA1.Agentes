/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemaTiempoRealAgente.Comportamientos;


import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import SystemaTiempoRealAgente.Agentes.AgenteHumedad;
import SystemaTiempoRealAgente.Agentes.AgenteVelocidadCompresor;

/**
 *
 * @author tony_
 */
  public class CiclicoHumedad extends CyclicBehaviour
    {
        public void action()
        {
            AgenteHumedad llama = new AgenteHumedad();  
            AgenteVelocidadCompresor llama2 = new AgenteVelocidadCompresor(); 
            int humd = (int) (Math.random() * 100) + 1;
            ACLMessage msm=llama2.receive();           
            String mjss="";  
            if(msm!= null )                
            { 
                ACLMessage respuesta = msm.createReply();
                if(msm.getContent().equals("solicitohumedad")==true)
                {
                    if (humd >0 && humd <=20) 
                    { 
                        mjss="seco";
                        respuesta.setContent(mjss);
                        llama.send(respuesta);      
                    } else if (humd >20 && humd <=40) 
                    {
                        mjss="confortable";
                        respuesta.setContent(mjss);
                    llama.send(respuesta);  
                    } else if (humd >40 && humd <=70) 
                    {
                        mjss="humedo";
                        respuesta.setContent(mjss);
                        llama.send(respuesta);  
                    }     
                    else if (humd >70 && humd <=100)
                    {
                        mjss="pegajoso";
                        respuesta.setContent(mjss);
                        llama.send(respuesta);  
                    } else 
                    {
                        System.out.println("Humedad fuera de rango");
                    }
                   System.out.println("Humedad: "+humd+" ==> "+mjss);
                }
            }else 
            {   
                block();
            }
        }  
  }