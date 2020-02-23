package AgenteComportamiento;

import jade.core.Agent;
import AgenteComportamiento.Comportamientos.*;

/**
 *
 * @author tony_
 */
public class AgenteComportamineto extends Agent
{
    public void setup()
    {
        System.out.println("Soy el agente:"+getName());  
        ComportamientoSimpleSuma c = new ComportamientoSimpleSuma();
        ComportamiendoSimpleResta c2 = new ComportamiendoSimpleResta();
        addBehaviour(c);
        addBehaviour(c2);
        //doDelete();
        
    }

    protected void takeDown()
    {
        System.out.println("Bye...");
    }

    
}
