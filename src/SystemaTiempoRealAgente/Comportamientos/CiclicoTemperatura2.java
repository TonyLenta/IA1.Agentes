/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemaTiempoRealAgente.Comportamientos;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import SystemaTiempoRealAgente.Agentes.AgenteTemperatura2;

/**
 *
 * @author tony_
 */
 public class CiclicoTemperatura2 extends CyclicBehaviour
   {   
      
      
       public void action()
       {
           AgenteTemperatura2 llama = new AgenteTemperatura2();
           ACLMessage msm=llama.receive();
           int temp = (int)(Math.random() * 100) + 1;  
          
                if (msm!=null)
                {
                    if(msm.getContent().equals("solicitotemperatura2")==true)
                    {         
                        //Instancia para valor en temperatura
                        ACLMessage respuesta = msm.createReply(); 
                        if (temp >=0 && temp <=10)
                        {                         
                        respuesta.setContent(String.valueOf(temp));
                        llama.send(respuesta);                                  
                        //System.out.println("Muy bajo");
                        } 
                        else if (temp >10 && temp <=25)
                        {
                            respuesta.setContent(String.valueOf(temp));
                            llama.send(respuesta);    
                          //  System.out.println("Bajo");
                        } else if (temp >25 && temp <=35) 
                        {
                            respuesta.setContent(String.valueOf(temp));                         
                            llama.send(respuesta);  
                           // System.out.println("Alto");                                                               
                        }
                        else if (temp >35 && temp <=100)
                        {
                            respuesta.setContent(String.valueOf(temp));
                            llama.send(respuesta);  
                           // System.out.println("Muy alto");
                        } 
                        else 
                        { 
                            System.out.println("Temperatura fuera de rango");
                        }
                        System.out.println("temp2:"+temp);
                    } 
                }else 
                {
                block();
                }   
                //System.out.println("Enviando temp2");
       }
   } 