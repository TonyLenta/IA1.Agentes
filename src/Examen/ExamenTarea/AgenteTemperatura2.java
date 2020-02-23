package Examen.ExamenTarea;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author tony_
 */
public class AgenteTemperatura2  extends Agent
{
    
   protected void setup()
   {
       ciclico comportamientosimple = new ciclico();
       addBehaviour( comportamientosimple) ;             
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
           block();
           /*Tiempo de ejecucion*/
           // int veces=1;
           // long ac=0;
           // float tt,p=0;
           long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
           TInicio = System.currentTimeMillis(); //Tom
            
           /*Comunicacion agentes*/
           ACLMessage msm=receive();
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
                        send(respuesta);
                        } 
                        else if (temp >10 && temp <=25)
                        {
                            respuesta.setContent(String.valueOf(temp));
                            send(respuesta); 
                        } else if (temp >25 && temp <=35) 
                        {
                            respuesta.setContent(String.valueOf(temp));                         
                            send(respuesta);                                                           
                        }
                        else if (temp >35 && temp <=100)
                        {
                            respuesta.setContent(String.valueOf(temp));
                            send(respuesta); 
                        } 
                        else 
                        { 
                            System.out.println("Temperatura fuera de rango");
                        }
                        System.out.println("temp2:"+temp);           
                        
                        /*Muestra tiempo de ejecucion*/
                         /***************************************************************************************/
                        TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                        tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                        System.out.println("Tiempo de ejecución en milisegundos Temperatura2: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
                        //veces++;
                        //ac=ac+tiempo;  
                        //tt=ac;
                        //p=tt/veces;

                        //System.out.println("Numero de veces ejecutadas: "+ veces);
                        //System.out.println("Tiempo total en milisegundos en generacion de Temperatura2: "+ ac);
                        //System.out.println("Promedio de tiempo en minutos : "+ p);
                    } 
                }else 
                {
                block();
                }   
       }
   } 
}
