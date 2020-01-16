/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compiladores.jflex;

import java.util.Scanner;

/**
 *
 * @author tony_
 */
public class Palindromo 
{
    public static void main(String[] args) 
    {
       String nombre;
       System.out.println("Ingrese numero: ");
       Scanner teclado = new Scanner(System.in);
       nombre = teclado.nextLine();
       int inc = 0;
       int des = nombre.length()-1;
       boolean bError = false;
       while ((inc<des) && (!bError))
       {
           if (nombre.charAt(inc)==nombre.charAt(des))
           {				
               inc++;
               des--;
           } 
           else 
           {
               bError = true;
           }
       }
       if (!bError)
       
	System.out.println(nombre+ " es un PALINDROMO");
       else
           System.out.println(nombre + " NO es un palindromo");
    }
}
