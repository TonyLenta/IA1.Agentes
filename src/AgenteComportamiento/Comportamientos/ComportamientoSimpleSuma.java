package AgenteComportamiento.Comportamientos;

import jade.core.behaviours.SimpleBehaviour;

/**
 *
 * @author tony_
 */
public class ComportamientoSimpleSuma extends SimpleBehaviour{
    
    /*One shot” behaviours: se ejecuta una sola vez
    ! Finalizan inmediatamente y sus método action() se ejecuta sólo una vez.
    ! Su método done() devuelve true.
    ! Clase jade.core.behaviours.OneShotBehaviour*/
    boolean finished = true;
    public void action()
    {
        System.out.println("Ejecucion del comportamiento Suma");    
        //myAgent.doDelete();
       
    }
    
    public boolean done(){
    return finished;
    }
   
    
}
