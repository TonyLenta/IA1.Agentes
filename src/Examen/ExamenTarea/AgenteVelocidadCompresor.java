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
         double boundary;
        public void action()
        {            
            /*Comunicacion agentes*/
            String msjfusiontemp="", msjhumeda="";    
            AID id=new AID();
            String ufacthume="";
            //Llama a agente fusion temperatura            
            ACLMessage msm2=new ACLMessage(ACLMessage.AGREE);
            String ufactfusiontemp="";
            id.setLocalName("fusion");        
            msm2.addReceiver(id);
            msm2.setContent("solicitofuciontemperatura");
            send(msm2);    
            ACLMessage respuesta =blockingReceive();
            ACLMessage respuestafactfusiontemp =blockingReceive();
            if(msm2!=null)
            {                
               msjfusiontemp=respuesta.getContent();
               ufactfusiontemp=respuestafactfusiontemp.getContent();
               System.out.println("factor u de sensor fusion temperatura 1 y 2: "+ufactfusiontemp);
               System.out.println("Sensor de promedio temperatura 1 y 2: "+msjfusiontemp);
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
            ACLMessage respuesta2 = blockingReceive();
           ACLMessage respuestafactuhumedad =blockingReceive();
            if(msm!=null)
            {          
               msjhumeda=respuesta2.getContent();              
               ufacthume=respuestafactuhumedad.getContent();
               System.out.println("factor u de sensor humedad: "+ufacthume);
               System.out.println("Sensor de humedad: "+msjhumeda);
            }
            else
            {
                block(900000000);
            }
            
            
              String msj="";
            System.out.println("Agente compresor: Fusion temperatrua "+msjfusiontemp+" && "+msjhumeda);
            
            //System.out.println("Factor de utilizacion "+msjfusiontemp+" && "+msjhumeda);
            /*************************************************/
           
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
            }else {System.out.println("Valor no encontrador");}
                    
            System.out.println("Estado del compresor: "+msj);
            
            
            
            
            
            float u1= Float.parseFloat(ufactfusiontemp);
            float u2 = Float.parseFloat(ufacthume);
            float ut;
            ut= u1+u2;
            
            /*en UG(x)  coloan el numero de tareas en este caso las tareas 
            son 4 el sensor de temperatura fusion, temperatura1, temperatrua2,
            y humedad*/
            System.out.println("");
         double faug=Ug(4);
           if(ut<faug)
        {
            System.out.println("Si es planificable, ya que factor utilizacion es menor a factor garantizado"
                    + " \n u<ug:==>"+ut+" < "+faug);
        }
        else 
        {
            System.out.println("No es planificable, ya que factor utilizacion es mayor a factor garantizado"
                    +"  \n u>ug:==>"+ut+" > "+faug);

        }
           
       
        
        
        
     }
        
        
        /*Test de planificabilidad de factor garantizado*/
        public double Ug(int n) 
        {
		boundary = n * ( (Math.pow(2, 1/(double)n) ) - 1);
		System.out.println("Boundary : " + boundary);
                return boundary;
		
	}
    
    }    
} 

