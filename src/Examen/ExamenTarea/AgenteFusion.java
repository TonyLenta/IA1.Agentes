package Examen.ExamenTarea;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Scanner;

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
        float ac = 0, ac2 = 0, c1 = 0, c2 = 0, pt = 0;
        public void action() 
        { 
            /*Comunicacion agentes*/
            ACLMessage msm6 = receive();
            String mesajecompresor = "";
            AID id = new AID();
            
            if (msm6 != null)
            {
                ACLMessage respuesta6 = msm6.createReply();

                if (msm6.getContent().equals("solicitofuciontemperatura") == true) 
                {
                    long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
                        TInicio = System.currentTimeMillis(); //Tom
                        /* tiempos   */
                        Scanner reader = new Scanner(System.in);
                        float di = 0;
                        float u=0;
                        float utemp1=0;
                        float utemp2=0;
                        float utt=0;
                        System.out.println("Ingrese tiempo de plazo maximo de sensor fusion temperaturas");
                        di = reader.nextFloat();
                        
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
                    ACLMessage respuestafactutemp1 = blockingReceive();
                    if (respuesta != null) 
                    {
                        //Obtiene el valor
                        float temp1 = Float.parseFloat(respuesta.getContent());
                        c1++;
                        ac = ac + temp1;
                        
                        /*Factor u de temp1*/
                        utemp1 = Float.parseFloat(respuestafactutemp1.getContent());
                        System.out.println("Factor u de temp1: "+utemp1);
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
                    ACLMessage respuestafactutemp2 = blockingReceive();
                    if (respuesta2 != null) 
                    {
                        float temp2 = Float.parseFloat(respuesta2.getContent());
                        c1++;
                        ac2 = ac2 + temp2;
                      
                        /*Factor u de temp2*/
                        utemp2 = Float.parseFloat(respuestafactutemp2.getContent());
                        System.out.println("Factor u de temp2: "+utemp2);
                        
                    } else {
                        block();
                    }

                    pt = (ac + ac2) / (c1 + c2);
                    System.out.println("Promedio temperaturas 1 y 2 :" + pt);
                    
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
                    System.out.println("Sensor de fusion temperaturas 1 y 2: "+mesajecompresor);
                    
                     
                        
                        /****************************************/
                      /*Muestra tiempo de ejecucion
                        /**************************************************************************************/
                        TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                        tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                        System.out.println("Tiempo de ejecución en milisegundos sensor fusion de temperaturas 1 y 2: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
                                               
                        /*Factor de utilizacion*/
                        u=(float)tiempo/di;
                        System.out.println("Factor u de fusion temperatrua 1 y 2: "+u);
                        utt=u+utemp1+utemp2;
                        
                       
                        System.out.println("Total de factor u: "+utt);
                        
                        
                        
                        String cadena = Float.toString(utt);                         
                        respuesta6.setContent(mesajecompresor/*+"Factor U:"+cadena*/);
                        send(respuesta6);
                        
                        ACLMessage respuesta3 = msm6.createReply();
                        respuesta3.setContent(cadena);
                        send(respuesta3);
                        System.out.println("Envia factor utilizacion de sensor fusion de temperaturas 1 y 2 a compresor");
                        
                }
            } else
            {
                block();
            }
        }
    }    
}
