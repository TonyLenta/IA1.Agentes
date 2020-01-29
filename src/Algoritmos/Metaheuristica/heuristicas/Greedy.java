package Algoritmos.Metaheuristica.heuristicas;


import Metaheuristica.mochila.*;

public class Greedy extends Heuristica {

	private Solution solucao;
	
	public void solve( Mochila mochila ){
		
		this.solucao = this.chuteInicial( mochila, false );
		
		while( !this.solucao.isFull() )
			this.solucao.addNextBestItem();
		
		this.printBestSolution();
	}
	
	protected void printBestSolution(){
		
		System.out.println( "GULOSO:\n" + this.solucao.toString( true, true ) + "\n" );
	}
	
}