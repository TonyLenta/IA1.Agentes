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
public class ProductoVendido implements Predicate{
    private Licor licor;

    public Licor getLicor() {
        return licor;
    }

    public void setLicor(Licor licor) {
        this.licor = licor;
    }
    
}
