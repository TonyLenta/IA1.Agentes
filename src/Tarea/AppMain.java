package Tarea;

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
            rma2 = mainContainer.createNewAgent("agentelogicomatematico", "Tarea.AgenteLogicoMatematico", new Object[0]);
            rma2.start();              
        } 
        catch (StaleProxyException e) 
        {
            e.printStackTrace();
	}
     }
}
