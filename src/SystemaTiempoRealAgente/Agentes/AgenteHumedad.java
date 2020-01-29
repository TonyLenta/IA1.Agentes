package SystemaTiempoRealAgente.Agentes;

import jade.core.Agent;
import SystemaTiempoRealAgente.Comportamientos.CiclicoHumedad;
/**
 *
 * @author tony_
 */

public class AgenteHumedad extends Agent
{   
     public void setup()
     { 
        System.out.println("Iniciando agente "+getLocalName());
        CiclicoHumedad humedad= new CiclicoHumedad();
        addBehaviour(humedad);
         
     }
    protected void takeDown()
    {
        System.out.println("Ejecucion finalzada.");
    }
    
  
}    


