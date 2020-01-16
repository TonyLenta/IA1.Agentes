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
public class VentaConTarjeta implements AgentAction{
    private Tarjeta tarjeta;
    private Licor licor;

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Licor getLicor() {
        return licor;
    }

    public void setLicor(Licor licor) {
        this.licor = licor;
    }
    
}
