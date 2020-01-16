/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LicoreraOntology;

import jade.content.Predicate;

/**
 *
 * @author josec
 */
public class Formadepagoefectivo implements Predicate{
    private Efectivo efectivo;

    public Efectivo getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(Efectivo efectivo) {
        this.efectivo = efectivo;
    }
    
}
