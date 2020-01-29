package SystemaTiempoRealAgente.Agentes;

import jade.core.Agent;
import SystemaTiempoRealAgente.Comportamientos.CiclicoCompresor;
/**
 *
 * @author tony_
 */
public class AgenteVelocidadCompresor extends Agent
{
 public void setup()
    {
        System.out.println("Iniciando agente "+getLocalName());
        CiclicoCompresor fusion = new CiclicoCompresor();
        addBehaviour(fusion) ;
        
    }
    public void takedown()
    {
    
        System.out.println("Finalizando..");
    }    
          
}

