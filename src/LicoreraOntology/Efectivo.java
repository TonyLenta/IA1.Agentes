/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LicoreraOntology;

import jade.content.Concept;

/**
 *
 * @author josec
 */
public class Efectivo implements Concept{
    private Double monto;

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
}
