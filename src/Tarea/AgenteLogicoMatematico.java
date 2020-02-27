/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea;

import Tarea.Comportamientos.*;
import jade.core.Agent;
import java.util.Scanner;

/**
 *
 * @author tony_
 * -gui -port 1098 superagente:Tarea.AgenteLogicoMatematico
 */
public class AgenteLogicoMatematico extends Agent{
    
    // Programacion del Agente
    public void setup(){
        Scanner entrada = new Scanner (System.in);
        // boolean salir = false;
        int opcion;
        
        System.out.println("Sistema de Comportamientos Logicos Matematicos:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");    
        System.out.println("4. Todos los comportamientos");
        System.out.println("5. Salir");
        
        System.out.print("Elija una Opcion: ");
        opcion = entrada.nextInt();
        
        switch (opcion){
            case 1:
                ComportamientoSuma s = new ComportamientoSuma();                
                addBehaviour(s);
                break;
            case 2:
                ComportamientoResta r = new ComportamientoResta();
                addBehaviour(r);
                break;
            case 3:
                ComportamientoMultiplicacion m = new ComportamientoMultiplicacion();
                addBehaviour(m);
                break;
                
           case 4:
              addBehaviour(new ComportamientoSuma());
              addBehaviour(new ComportamientoResta());
              addBehaviour(new ComportamientoMultiplicacion());
              
             
              
                break;
            case 5:
                doDelete();
              //  salir = true;
                break;
            default:
                System.out.println("Solo numeros entre 1 y 4");
        }
    }
    
    protected void takeDown(){
        System.out.println("Comportamientos finalizados bye");
    }
    
}
