/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ontologias.frutas;
import jade.content.Predicate;
/**
 *
 * @author MI PC
 */
public class Oferta implements Predicate{
  private Fruta fruta;
 
   public Fruta getFruta() {
     return fruta;
   }
 
   public void setFruta(Fruta f) {
     fruta = f;
   }
}
 

