/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea.Tiempos;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import scheduler.*;


/**
 *
 * @author tony_
 */
public class Tiempos extends TaskAddUIClass{
    
    //Atributos
   String burst = burstText.getText();
   String arrival = arrivalText.getText();
   String deadline = deadlineText.getText();
   int burstTime = -10, arrivalTime = -10, deadlineTime = -10;
    
       /*Constructor por defecto*/
    
  
        /**
     * Tiempo de computo
     */
    private int ci;
    /**
     * Tiempo real
     */
    private int Ti;
    /**
     * Tiempo de plazo maximo
     */
    private int Di;

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public int getTi() {
        return Ti;
    }

    public void setTi(int Ti) {
        this.Ti = Ti;
    }

    public int getDi() {
        return Di;
    }

    public void setDi(int Di) {
        this.Di = Di;
    }
   
 
     public Tiempos() {
         this.ci = burstTime = Integer.parseInt(burst);
        this.Ti = arrivalTime = Integer.parseInt(arrival);
        this.Di = arrivalTime = Integer.parseInt(arrival);
    }
    
    /*Contructor*/

    public void Tiempos(int ci, int ti, int Ti) {
        this.ci = burstTime = Integer.parseInt(burst);
        this.Ti = arrivalTime = Integer.parseInt(arrival);
        this.Di = arrivalTime = Integer.parseInt(arrival);
    }
    
}

