/** ******************************************************************* */
/*

 * Programa que permite jugar al tres en raya o tic tac toe contra otra
 * persona o contra la m�quina. Implementando el algoritmo minimax, �rboles,
 * recursi�n, etc.
 *
/**********************************************************************/
package MiniMax;

import java.applet.AudioClip;

public class Sonidos {

    /*Objeto audioclip*/
    AudioClip sonido;
    boolean silencio = false;

    /*Crea una nueva instancia de sonidos.*/
    public Sonidos() {
    }

    /*M�todo que imprime un sonido al error.*/
    public void sonidoFicha() {
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/MiniMax/sonidos/error.wav"));
        if (!silencio) {
            sonido.play();
        }
    }

    /*M�todo que imprime un sonido al ganar.*/
    public void sonidoGano() {
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("sonidos/victoria.wav"));
        if (!silencio) {
            sonido.play();
        }
    }

    /*M�todo que imprime un sonido al perder.*/
    public void sonidoPerdio() {
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("sonidos/perdio.wav"));
        if (!silencio) {
            sonido.play();
        }
    }
}
