package Puzzle.Controlador;

import java.io.IOException;

import Puzzle.modelo.Hilo;
import Puzzle.modelo.armarPulzze;
import Puzzle.modelo.cargarArchivo;
import Puzzle.vista.panelBotones;
import Puzzle.vista.panelMovimientos;
import Puzzle.vista.panelPulzze;
import Puzzle.vista.ventanapulzze;

public class Controlador {

	private panelBotones pnBotones;
	private panelPulzze pnPuzzle;
	private panelMovimientos pnMovimientos;
	private armarPulzze armar;
	private cargarArchivo cargar;
	private ventanapulzze ventana;
	private Hilo hilo;
	
	public Controlador() {		
		cargar = new cargarArchivo();
		hilo = new Hilo(this);
	}
	
	public void cargarArchivo() throws IOException{
		
		cargar.cargarArchivo();
		armar = new armarPulzze(cargar.getArchi());
		pnPuzzle.pintar(armar.getEstadoinicial());
		pnMovimientos.pintarMovimientos(armar.recorrerGrafo());
	}
	

	
	public void conectar(panelPulzze pnlPuzzle, panelMovimientos pnlMovimientos) {
		this.pnPuzzle = pnlPuzzle;
		this.pnMovimientos = pnlMovimientos;
	}
	
	public void actualizar() {
		
		String[][] matriz = armar.getEstadoinicial();
		String cadenaMovimiento = armar.recorrerGrafo();
		hilo.setMov(cadenaMovimiento);
		hilo.setMatriz(matriz);
		hilo.star();
		hilo.start();
	}
	
	public panelPulzze getPnlPuzzle() {
		return pnPuzzle;
	}
	
	public panelMovimientos getPnlMovimientos() {
		return pnMovimientos;
	}
	
	public panelBotones getPnlBotones() {
		return pnBotones;
	}
	
}
