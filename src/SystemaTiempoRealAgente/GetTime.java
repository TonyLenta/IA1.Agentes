/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemaTiempoRealAgente;

import jade.lang.acl.ACLMessage;

/**
 *
 * @author tony_
 */
public class GetTime 
{
   public static void main(String[] args) 
   {
       
       int veces=1;
       long ac=0;
       float tt,p=0;
       while (veces<=99) {
           long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
           TInicio = System.currentTimeMillis(); //Tom
           /**************************************************************************************/    
           int temp = (int) (Math.random() * 100) + 1; 
           System.out.println("\n temp1: \n"+temp);
           if (temp >=0 && temp <=10) 
           {  
               System.out.println("Muy bajo");
           }
           else if (temp >10 && temp <=25) 
           {  
               System.out.println("Bajo");
           } 
           else if (temp >25 && temp <=35) 
           {           
               System.out.println("Alto");
           }
           else if (temp >35 && temp <=100)
           {
               System.out.println("Muy alto");
           }
           else 
           {
               System.out.println("Temperatura fuera de rango");
           } 
           /***************************************************************************************/
           TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
           tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
           System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
   
           ac=ac+tiempo;
           veces++;
   
            tt=ac;
            p=tt/veces;
   }
       
       System.out.println("Numero de veces ejecutadas: "+ veces);
       System.out.println("Tiempo total en milisegundos: "+ ac);
        System.out.println("Promedio de tiempo en minutos : "+ p);
       
   }
}
