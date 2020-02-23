package Examen.ExamenTarea;

/**
 *
 * @author tony_
 */

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
public class AgenteHumedad extends Agent
{   
     public void setup()
     {    
        MyCyclicBehavior c = new MyCyclicBehavior();
        addBehaviour(c);
         System.out.println("Iniciando agente "+getLocalName());
     }
    protected void takeDown()
    {
        System.out.println("Ejecucion finalzada.");
    }
    
    private class MyCyclicBehavior extends CyclicBehaviour
    {
        public void action()
        {
            block();
            /*Tiempo de ejecucion*/
            //int veces=1;
            //long ac=0;
            //float tt,p=0;
            long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
            TInicio = System.currentTimeMillis(); //Tom
            
            /*Comunicacion agentes*/
            
            ACLMessage msm=receive();           
            int humd = (int) (Math.random() * 100) + 1;   
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
                        send(respuesta);      
                    } else if (humd >20 && humd <=40) 
                    {
                        mjss="confortable";
                        respuesta.setContent(mjss);
                    send(respuesta);  
                    } else if (humd >40 && humd <=70) 
                    {
                        mjss="humedo";
                        respuesta.setContent(mjss);
                        send(respuesta);  
                    }     
                    else if (humd >70 && humd <=100)
                    {
                        mjss="pegajoso";
                        respuesta.setContent(mjss);
                        send(respuesta);  
                    } else 
                    {  
                        //mjss="Fuerarango";
                        System.out.println("Humedad fuera de rango");
                    }
                   System.out.println("Humedad: "+humd+" ==> "+mjss);
                   
                   /*Muestra tiempo de ejecucion*/
                   /***************************************************************************************/
                   TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                   tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                   System.out.println("Tiempo de ejecución en milisegundos Humedad: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
                   //veces++;
                   //ac=ac+tiempo;  
                   //tt=ac;
                   //p=tt/veces;
                   //System.out.println("Numero de veces ejecutadas: "+ veces);
                   //System.out.println("Tiempo total en milisegundos en generacion de Temperatura1: "+ ac);
                   //System.out.println("Promedio de tiempo en minutos : "+ p);
                   
              }
            }else 
           {   
           block();
           }
        }  
    }    
}

