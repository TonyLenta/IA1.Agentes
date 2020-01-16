/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LicoreraOntology;

import jade.content.AgentAction;

/**
 *
 * @author josec
 */
public class VentaEnEfectivo implements AgentAction{
    private Licor licor;
    private Efectivo efectivo;

    public Licor getLicor() {
        return licor;
    }

    public void setLicor(Licor licor) {
        this.licor = licor;
    }

    public Efectivo getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(Efectivo efectivo) {
        this.efectivo = efectivo;
    }
   
    
}
