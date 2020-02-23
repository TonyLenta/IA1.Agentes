package Examen.ExamenTarea;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author tony_
 */
public class AgenteFusion extends Agent 
{
    public void setup() 
    {
        System.out.println("Iniciando agente " + getLocalName());
        ciclico fusion = new ciclico();
        addBehaviour(fusion);
    }

    public void takedown() 
    {

        System.out.println("Finalizando..");
    }

    private class ciclico extends CyclicBehaviour 
    {
        boolean finis = false;
        float ac = 0, ac2 = 0, c1 = 0, c2 = 0, pt = 0;
        public void action() 
        {
            block();
            /*Tiempo de ejecucion*/
            //int veces=1;
            //long act=0;
            //float tt,p=0;
            long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
            TInicio = System.currentTimeMillis(); //Tom
            
            /*Comunicacion agentes*/
            String mesajecompresor = "";
            AID id = new AID();
            ACLMessage msm6 = receive();
            if (msm6 != null)
            {
                if (msm6.getContent().equals("solicitofuciontemperatura") == true) 
                {
                    ACLMessage respuesta6 = msm6.createReply();
                    //Instancia solicitando temperatura 1
                    ACLMessage msm = new ACLMessage(ACLMessage.AGREE);
                    //Instancia solicitando temperatura 2
                    ACLMessage msm2 = new ACLMessage(ACLMessage.AGREE);
                    //llama al primer agente temperatura
                    id.setLocalName("temperatura");
                    //System.out.println(getLocalName()+" solicita temperatura 1");
                    msm.addReceiver(id);
                    msm.setContent("solicitotemperatura");
                    send(msm);
                    ACLMessage respuesta = blockingReceive();
                    if (respuesta != null) 
                    {
                        //Obtiene el valor
                        float temp1 = Float.parseFloat(respuesta.getContent());
                        c1++;
                        ac = ac + temp1;
                    } else {
                        block();
                    }
                    
                    // llama al segundo agente temperatura
                    id.setLocalName("temperatura2");
                    // System.out.println(getLocalName()+" solicita temperatura 2");
                    msm2.addReceiver(id);
                    msm2.setContent("solicitotemperatura2");
                    send(msm2);
                    ACLMessage respuesta2 = blockingReceive();
                    if (respuesta2 != null) 
                    {
                        float temp2 = Float.parseFloat(respuesta2.getContent());
                        c1++;
                        ac2 = ac2 + temp2;
                        // System.out.println(respuesta2.toString());
                    } else {
                        block();
                    }

                    pt = (ac + ac2) / (c1 + c2);
                    System.out.println("Promedio temperaturas 1 y 2 :" + pt);
                    String cadena = Float.toString(pt);
                    if (pt >= 0 && pt <= 10) 
                    {
                        mesajecompresor = "mbajo";
                        //System.out.println("Muy bajo");
                    } else if (pt > 10 && pt <= 25) 
                    {
                        mesajecompresor = "bajo";
                        // System.out.println("Bajo");
                    } else if (pt > 25 && pt <= 35) 
                    {
                        mesajecompresor = "alto";
                        // System.out.println("Alto");                            
                    } else if (pt > 35 && pt <= 100) 
                    {
                        mesajecompresor = "malto";
                        // System.out.println("Muy alto");
                    } else 
                    {
                        System.out.println("Temperatura fuera de rango");
                    }
                    respuesta6.setContent(mesajecompresor/*+":"+cadena*/);
                    send(respuesta6);
                    
                    /*Muestra tiempo de ejecucion*/
                    /***************************************************************************************/
                    TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                    tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                    System.out.println("Tiempo de ejecución en milisegundos Promedio de Temperaturas: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
                    //veces++;
                    //act=act+tiempo;  
                    //tt=ac;
                    //p=tt/veces;
                    //System.out.println("Numero de veces ejecutadas: "+ veces);
                    //System.out.println("Tiempo total en milisegundos en generacion de Temperatura1: "+ ac);
                    //System.out.println("Promedio de tiempo en minutos : "+ p);
                    System.out.println("Estado promedio temperatura: " + mesajecompresor);
                }
            } else
            {
                block();
            }
        }
    }    
}
