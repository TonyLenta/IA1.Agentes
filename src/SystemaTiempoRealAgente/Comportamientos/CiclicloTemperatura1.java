/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemaTiempoRealAgente.Comportamientos;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import SystemaTiempoRealAgente.Agentes.AgenteTemperatura1;

import jade.core.Agent;
import SystemaTiempoRealAgente.Agentes.AgenteTemperatura1;
/**
 *
 * @author tony_
 */
public class CiclicloTemperatura1 extends CyclicBehaviour
   { 
    public void action()
       {
           // se agrego
           AgenteTemperatura1 llama = new AgenteTemperatura1();
           ACLMessage msm=llama.receive();        
           int temp = (int) (Math.random() * 100) + 1; 
                if (msm!=null)
                {
                    if(msm.getContent().equals("solicitotemperatura")==true)
                    { 
                        //Instancia para valor en temperatura
                        ACLMessage respuesta = msm.createReply();                      
                        if (temp >=0 && temp <=10) 
                        {
                           //Enviando valor
                           respuesta.setContent(String.valueOf(temp));
                           llama.send(respuesta);                                                                           
                          //System.out.println("Muy bajo");
                        }
                        else if (temp >10 && temp <=25) 
                        {  
                           //Enviando valor
                           respuesta.setContent(String.valueOf(temp));
                           llama.send(respuesta);                      
                         //System.out.println("Bajo");
                        } 
                        else if (temp >25 && temp <=35) 
                        {
                           //Enviando valor
                           respuesta.setContent(String.valueOf(temp));
                           llama.send(respuesta);                  
                          // System.out.println("Alto");
                            
                        }                                                           
                        else if (temp >35 && temp <=100)
                        {
                           //Enviando valor
                           respuesta.setContent(String.valueOf(temp));
                           llama.send(respuesta);                       
                          //System.out.println("Muy alto");
                        }
                        else 
                        {
                                   System.out.println("Temperatura fuera de rango");
                        }
                        System.out.println("temp1:"+temp);
                    } 
                }
                else 
                {
                block();
                }        
       }      

  
   }
