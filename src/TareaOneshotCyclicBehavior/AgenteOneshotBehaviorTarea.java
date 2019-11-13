/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TareaOneshotCyclicBehavior;
import jade.core.Agent;
import jade.core.behaviours.*;
import java.util.Scanner;
/**
 *
 * @author tony_
 */
public class AgenteOneshotBehaviorTarea  extends Agent {
    int numero1 = 0;
        int numero2 = 0;
        int resultado=0;

      public void setup(){
        MyOoneShotBehavior c = new MyOoneShotBehavior();
        addBehaviour(c);
        Scanner lectura = new Scanner(System.in);
        
        System.out.println("Introduce el primer número:");			
        numero1 = lectura.nextInt();

        System.out.println("Introduce el segundo número:");
        numero2 = lectura.nextInt();
        if (numero1<numero2) {
                System.out.println("Numero 1 debe ser mayor para la divicion");
            }
    }
      protected void takeDown(){
        System.out.println("Ejecucion finalzada.");
    }

    private class MyOoneShotBehavior extends OneShotBehaviour{
    public void action(){
        System.out.println("Ejecucion del comportamiento OneShotBehavior");
        
        resultado = numero1+numero2;
        System.out.println("Resultado de la suma:"+resultado);
        resultado = numero1-numero2;
        System.out.println("Resultado de la resta:"+resultado);
        resultado = numero1*numero2;
        System.out.println("Resultado de la multiplicacion:"+resultado);
        resultado = numero1/numero2;
        System.out.println("Resultado de la divicion:"+resultado);
        
                
            
        myAgent.doDelete();
        }
    }
}
