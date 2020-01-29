package Grupal.heuristicas;

import java.util.Random;
import Grupal.heuristicas.Heuristica;
import Grupal.mochila.Mochila;
import Grupal.mochila.Solution;

public class Grasp extends Heuristica {

        /**********
        tiempo inicio
        **********/
      
    int veces=1;
       long ac=0;
       float tt,p=0;
       long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
       TInicio = System.currentTimeMillis(); //Tom
           
    
    
	private double alpha;
	
	private int interations;
	
	private Solution solucao;
	
	private Random random = new Random();
	
	public Grasp( double alpha, int interations ){
		
		this.alpha = alpha;
		this.interations = interations;
	}
	
	public void solve( Mochila mochila ){
		
		Solution solucaoAlternativa;
		
		for( int i = 0; i < this.interations; i++ ){
			
			// asignar una codiciosa solución inicial
			this.solucao = this.solucaoInicial( mochila );
			
			// iterando sobre cada par de la solución
			solucaoAlternativa = this.buscaLocal( mochila );
			
			if( solucaoAlternativa.z() > this.solucao.z() )
				this.solucao = solucaoAlternativa;
		}
		
		System.out.println( this.solucao.toString(false,true) );
	}
	
	protected Solution solucaoInicial( Mochila mochila ){
		
		this.solucao = this.chuteInicial( mochila, false );

		while( !this.solucao.isFull() ){
			
			if( this.random.nextDouble() <= this.alpha )
				this.solucao.addNextBestItem();
			else
				this.solucao.addNextItem( true );
		}
		
		return solucao;
	}
	
	private Solution buscaLocal( Mochila mochila ){
		
		Solution solution, newSolution, bestSolution = this.solucao;
		
		if( this.random.nextDouble() < this.alpha ){
			
// realice 2-opt en el 20% de las cantidades de artículos de la mochila al azar y elija la mejor solución entre ellas
			int numSolucoes = (int) (0.2 * this.solucao.size()) + 1;
			
			solution = this.solucao;
			
			for( int i = 0; i < numSolucoes; i++ ){
				
				newSolution = this.opt2( solution );
				newSolution.tryAddOneMore();
				
				if( newSolution.z() > solution.z() ){
				
					solution = newSolution;
					
					if( !newSolution.estoura() )
						bestSolution = newSolution;
				}
			}
			
		} else {
			
			// ejecuta 2-opt solo una vez al azar
			newSolution = this.opt2( this.solucao );
			
			if( !newSolution.estoura() ){
				
				bestSolution = newSolution;
				bestSolution.tryAddOneMore();
			}
		}
		
		return bestSolution;
	}
	
	private Solution opt2( Solution solution ){
		
		int index1, index2;
		
		// elegir al azar un elemento seleccionado
		do {
			
			index1 = this.random.nextInt( solution.size() );
			
		} while( solution.selecionado( index1 ) );
		
		// retirando este item da mochila
		solution.retiraItem( index1 );
		
		// agregue otro elemento no seleccionado todavía
		do {
			
			index2 = this.random.nextInt( solution.size() );
			
		} while( !solution.selecionado( index2 ) );

		return new Solution( solution, index2 );
	}
	
        
        
        /**
         tiempo final*/
        
        ac=ac+tiempo;   
        tt=ac;
        p=tt/veces;
        TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
        tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
        System.out.println("Numero de veces ejecutadas: "+ veces);
        System.out.println("Tiempo total en milisegundos: "+ ac);
        System.out.println("Promedio de tiempo en minutos : "+ p);
}