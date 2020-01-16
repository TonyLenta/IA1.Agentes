/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LicoreraOntology;


import jade.content.Predicate;

/**
 *
 * @author tony_
 */
public class Disponible implements Predicate{
    private TiempoVenta tiempo;

    public TiempoVenta getTiempo() {
        return tiempo;
    }

    public void setTiempo(TiempoVenta tiempo) {
        this.tiempo = tiempo;
    }
    
}
