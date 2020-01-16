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
public class Tarjeta implements Concept{
    private Integer numtarjeta;
    private Double monto;
    private Cliente cliente;

    public Integer getNumtarjeta() {
        return numtarjeta;
    }

    public void setNumtarjeta(Integer numtarjeta) {
        this.numtarjeta = numtarjeta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
