package SystemaTiempoRealAgente.Agentes;

import jade.core.Agent;
import SystemaTiempoRealAgente.Comportamientos.CiclicoTemperatura2;
/**
 *
 * @author tony_
 */
public class AgenteTemperatura2  extends Agent
{
    
   protected void setup()
   {
       CiclicoTemperatura2 temperatura2 = new CiclicoTemperatura2();
       addBehaviour(temperatura2) ;             
       System.out.println("Iniciando agente "+getLocalName());
   }
   protected void takedown ()
   {
       System.out.println("Finalizando..");
   }
   
  
}
