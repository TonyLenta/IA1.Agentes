/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ontologias.frutas;
import jade.content.Concept;
/**
 *
 * @author MI PC
 */
public class Fruta implements Concept {
 
   private String nombre;
   private String precio;
 
   public String getNombre() {
     return nombre;
   }
 
   public void setNombre(String n) {
     nombre = n;
   }
 
 public String getPrecio() {
     return precio;
   }
 
   public void setPrecio(String p) {
     precio = p;
   }
}
 

 
   