/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaginasAmarillas;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

/**
 *
 * @author tony_
 */
public class Agente2 extends Agent{
    
    public void setup(){
        
        // Clase para definir los servicios de la pagina amarilla
        DFAgentDescription dex = new DFAgentDescription();
        dex.setName(getAID());
        dex.addLanguages("castellano");
        
        //Clase de servicio en el cual la vamos a describir
        //servicio 1
        ServiceDescription s1 = new ServiceDescription();
        s1.setType("type1");
        s1.setName("service1");
        dex.addServices(s1);
        
       
        
        try {
        DFService.register(this, dex);
        System.out.println(getAID()+"ha resgistrado los servicios con exito");    
        } catch (Exception e) {
            System.out.println(e+"error");}
            
             
    }
    
   
    //Este es el comportamiento.
    private class MiComportamiento1 extends Behaviour{
        public void action(){
        
            System.out.println("Comportamiento Behavio agente 2");
    }
        public boolean done(){
            return true;
        }
    }


    
    
    
}