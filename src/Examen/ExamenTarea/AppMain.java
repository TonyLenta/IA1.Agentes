package Examen.ExamenTarea;

/**
 *
 * @author tony_
 */
 
import jade.core.Runtime;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.*;

public class AppMain 
{
    public static void main(String args[]) throws StaleProxyException 
    {          
        Runtime rt = Runtime.instance();
	rt.setCloseVM(true);
	// Create a default profile
	Profile profile = new ProfileImpl("localhost", 1069, "main");
	AgentContainer mainContainer = jade.core.Runtime.instance().createMainContainer(profile);
        AgentController rma1 = null;
        AgentController rma2 = null;
        AgentController rma3 = null;
        AgentController rma4 = null;
        AgentController rma5 = null;
        
	try 
        {
            //Agente humedad   
            rma2 = mainContainer.createNewAgent("humedad", "Examen.ExamenTarea.AgenteHumedad", new Object[0]);
            rma2.start();   
            
            // Agente temperatura 1
            rma4 = mainContainer.createNewAgent("temperatura", "Examen.ExamenTarea.AgenteTemperatura1", new Object[0]);
            rma4.start();
          
            
            //Agente Compresor
            rma1 = mainContainer.createNewAgent("compresor", "Examen.ExamenTarea.AgenteVelocidadCompresor", new Object[0]);
            rma1.start();
            
        } 
        catch (StaleProxyException e) 
        {
            e.printStackTrace();
	}
     }
}
