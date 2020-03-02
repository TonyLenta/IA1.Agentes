package Examen.ExamenTarea;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Scanner;

/**
 *
 * @author tony_
 */
public class AgenteTemperatura1  extends Agent
{    
   protected void setup()
   {
       ciclico comportamientosimple = new ciclico();
       addBehaviour( comportamientosimple);              
       System.out.println("Iniciando agente "+getLocalName());       
       
   }

   protected void takedown ()
   {
       System.out.println("Finalizando..");
   }

   private class ciclico extends CyclicBehaviour 
   { 
       public void action()
       {           
           ACLMessage msm=receive();
          
           
           if (msm!=null)
                {
                    if(msm.getContent().equals("solicitotemperatura")==true)
                    { /*tiempo computo*/
                         long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
                        TInicio = System.currentTimeMillis(); //Tom
                        /* tiempos   */
                        Scanner reader = new Scanner(System.in);
                        float di = 0;
                        float u=0;
                        System.out.println("Ingrese tiempo de plazo maximo de sensor temperatura 1");
                        di = reader.nextFloat();
                        int temp = (int) (Math.random() * 100) + 1;
                        String tempchar="";
                       /* Tarea*/
                        
                        ACLMessage respuesta = msm.createReply();                      
                        if (temp >=0 && temp <=10) 
                        {
                            tempchar=String.valueOf(temp);                                                      
                        }
                        else if (temp >10 && temp <=25) 
                        {  
                            tempchar=String.valueOf(temp);  
                        } 
                        else if (temp >25 && temp <=35) 
                        {
                           tempchar=String.valueOf(temp);  
                            
                        }                                                           
                        else if (temp >35 && temp <=100)
                        {
                             tempchar=String.valueOf(temp);                             
                        }
                        else 
                        {
                                   System.out.println("Temperatura fuera de rango");
                        }
                        System.out.println("temp1:"+temp);
                        
                        
                        
                        /*Muestra tiempo de ejecucion*/
                        /***************************************************************************************/
                        TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                        tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                        System.out.println("Tiempo de ejecución en milisegundos sensor  de temperatura 1 : " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
                                                
                        /*Factor de utilizacion*/
                        u=(float)tiempo/di;
                        System.out.println("Factor u de temp1: "+u);
                        String cadena = Float.toString(u); 
                        //Enviando valor
                        respuesta.setContent(tempchar);
                        send(respuesta);
                        ACLMessage respuesta3 = msm.createReply();
                        respuesta3.setContent(cadena);
                        send(respuesta3);
                        System.out.println("Enviando factor utilizacion de sensor  temperaturas 1 a fusion");
                    }
                      
                }else 
           {   
           block();
           }            
        }
    }       
}   


