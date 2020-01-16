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
import jade.core.Agent;

import jade.core.behaviours.Behaviour;

import jade.domain.DFService;

import jade.domain.FIPAAgentManagement.*;

import java.util.Iterator;


public class Agente3 extends Agent

{


     protected void setup()

    {

        

        addBehaviour( new MiComportamiento() );

               

    }

     

     protected void takeDown()

    {

        System.out.println("****Agente finalizado****");

    }

     

     

     private class MiComportamiento extends Behaviour

    {

         public void action() {

         block(9000000);
         block(1000000);
         block(1000000);

         ServiceDescription servicio = new ServiceDescription();

         servicio.setType("type1");

         //servicio.setName("N1");

 

         // Plantilla de descripción que busca el agente

         DFAgentDescription descripcion = new DFAgentDescription();

         descripcion.addLanguages("castellano");

 

         // Servicio que busca el agente

        descripcion.addServices(servicio);

        try

        {

        // Todas las descripciones que encajan con la plantilla proporcionada en el DF

            DFAgentDescription[] resultados = DFService.search(myAgent,descripcion);

 

            if (resultados.length == 0)

                System.out.println("Ningun agente ofrece el servicio deseado");

 

            for (int i = 0; i < resultados.length; ++i)

            {

                System.out.println("El agente "+resultados[i].getName().getLocalName()+" ofrece el servicio buscado");

                Iterator servicios = resultados[i].getAllServices();

                int j = 1;

                while(servicios.hasNext())

                {

                  servicio = (ServiceDescription)servicios.next();

                   System.out.println(servicio.getName());

                  System.out.println();

                   j++;

                }

            }

        }

        catch (Exception e)

        {

            e.printStackTrace();

        }

           

           

         }

         

         public boolean done()

         {

             return true;

         }

         

     }

}