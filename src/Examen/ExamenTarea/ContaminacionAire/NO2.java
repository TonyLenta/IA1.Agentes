/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen.ExamenTarea.ContaminacionAire;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;

/**
 *
 * @author tony_
 */
public class NO2 extends Agent{
    
    public void setup()
    {
    Ciclico c = new Ciclico();
        System.out.println("Iniciando NO2");
        addBehaviour(c);
    }
    
    public void takedown()
    {
        System.out.println("Finalizando..");    
    }
    
    private class Ciclico extends CyclicBehaviour
    {
        public void action()
        {
            String estado="";      
            int cont = (int) (Math.random() * 150) + 1;
            
            ACLMessage msm=receive();
            
            if (msm!=null)
            {
                if(msm.getContent().equals("solicitono2")==true)
            
                {
                      ACLMessage respuesta = msm.createReply();    
                    if(cont>0 && cont <=50)
                    {
                        estado="good";
                        respuesta.setContent(estado);
                        send(respuesta);
                        //System.out.println("good");
                    }
                    else if(cont>50 && cont <=100)
                            {
                                 estado="moderate";
                                  respuesta.setContent(estado);
                                 send(respuesta);
                               // System.out.println("moderate");
                            }
                    else if(cont>100 && cont <=150)
                    {
                         estado="poor";
                          respuesta.setContent(estado);
                         send(respuesta);
                        //System.out.println("poor");
                    }else
                    {
                        System.out.println("fuera de rango");
                    }
                    System.out.println("Agente NO2, Contaminacion: "+estado);
                }else
                {
                    System.out.println("Esperando..");
                }
            }
            else 
            {
                block();
            }
        }
    
    }
    
    
}
