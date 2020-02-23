package Examen.ExamenTarea;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author tony_
 */
public class AgenteVelocidadCompresor extends Agent
{
 public void setup()
    {
        System.out.println("Iniciando agente "+getLocalName());
        ciclico fusion = new ciclico();
        addBehaviour(fusion) ;
        
    }
    public void takedown()
    {
    
        System.out.println("Finalizando..");
    }
        
    private class ciclico extends CyclicBehaviour
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
            String msjfusiontemp="", msjhumeda="";    
            AID id=new AID();
            
            //Llama a agente fusion temperatura            
            ACLMessage msm2=new ACLMessage(ACLMessage.AGREE);
            id.setLocalName("fusion");            
            msm2.addReceiver(id);
            msm2.setContent("solicitofuciontemperatura");
            send(msm2);
            ACLMessage respuesta2 = blockingReceive();   
            if(msm2!=null)
            {
                msjfusiontemp=respuesta2.getContent();
                //System.out.println("FusioTemperaturas: "+msjfusiontemp);
            }
            else
            {
                block();
            }  
               
            //Llama agente humedad            
            id.setLocalName("humedad");            
            ACLMessage msm=new ACLMessage(ACLMessage.AGREE);
            msm.addReceiver(id);
            msm.setContent("solicitohumedad");
            send(msm);
            ACLMessage respuesta = blockingReceive();
            if(msm!=null)
            {
                msjhumeda=respuesta.getContent();
                //System.out.println("Humedad: "+msjhumeda);
            }
            else
            {
                block(900000000);
            }
            System.out.println("Agente compresor: Fusion temperatrua "+msjfusiontemp+" && "+msjhumeda);
            /*************************************************/
            
            /*Estado de compresor basada en 15 reglas*/       
            String msj="";
            //#1 Apagado
            if(msjfusiontemp.equals("mbajo") && msjhumeda.equals("seco"))
            {
                msj="Apagado";
            }
            //#2 
            else if(msjfusiontemp.equals("mbajo") && msjhumeda.equals("confortable"))
            {
                msj="Apagado";
            }
            //#3
            else if(msjfusiontemp.equals("mbajo") && msjhumeda.equals("humedo"))
            {
                msj="Apagado";
            }
            //#4 Bajo
            else if(msjfusiontemp.equals("mbajo") && msjhumeda.equals("pegajoso"))
            {
                msj="Bajo";
            }
            //#5 apagdo
            else if(msjfusiontemp.equals("bajo") && msjhumeda.equals("seco"))
            {
                msj="Apagado";
            }
            //#6 apagado
            else if(msjfusiontemp.equals("bajo") && msjhumeda.equals("confortable"))
            {
                msj="Apagado";
            }
            //#7 bajo
            else if(msjfusiontemp.equals("bajo") && msjhumeda.equals("humedo"))
            {
                msj="Bajo";
            }
            //#8 
            else if(msjfusiontemp.equals("bajo") && msjhumeda.equals("pegajoso"))
            {
                msj="Medio";
            }
            //#9 
            else if(msjfusiontemp.equals("alto") && msjhumeda.equals("seco"))
            {
                msj="Bajo";   
            }
            //#10 
            else if(msjfusiontemp.equals("alto") && msjhumeda.equals("confortable"))
            {
                msj="Medio";
            }
            //#11 
            else if(msjfusiontemp.equals("alto") && msjhumeda.equals("humedo"))
            {
                msj="Rapido";              
            }
            //#12 
            else if(msjfusiontemp.equals("alto") && msjhumeda.equals("pegajoso"))
            {
                msj="Rapido";
            }
            //#13 
            else if(msjfusiontemp.equals("malto") && msjhumeda.equals("seco"))
            {
                msj="Medio";
            }
            //#14 
            else if(msjfusiontemp.equals("malto") && msjhumeda.equals("confortable"))
            {
                msj="Rapido";
            }
            //#15 
            else if(msjfusiontemp.equals("malto") && msjhumeda.equals("humedo"))
            {
                msj="Rapido";
               // System.out.println("Rapido");
            }            
            System.out.println("Estado del compresor: "+msj);
            
            /*Muestra tiempo de ejecucion*/
            /***************************************************************************************/
            TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
            tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
            System.out.println("Tiempo de ejecución en milisegundos VelocidadCompresor: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
            //veces++;
            //ac=ac+tiempo;  
            //tt=ac;
            //p=tt/veces;
            //System.out.println("Numero de veces ejecutadas: "+ veces);
            //System.out.println("Tiempo total en milisegundos en generacion de Temperatura1: "+ ac);
            //System.out.println("Promedio de tiempo en minutos : "+ p);
       } 
    }       
}

