package buscaminas;
import java.util.Random;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class Matriz {
	private int tam;
	private Celda[][] celdas;
	
	public Celda[][] getCeldas() { return celdas; };
	
	public Matriz(int tam) {
		this.tam = tam;
		this.celdas = llenarCeldas(tam);
	}
	
	public int getTam() { 		
		return tam; 
	}
	
	private Celda[][] llenarCeldas(int tam){
		this.celdas = new Celda[tam][tam];
		for (int i=0; i<tam;i++){
			for (int j=0; j<tam; j++) {
				celdas[i][j] = construirCeldaRandom();
			}
		}
		while (validarTodoMinas()) llenarCeldas(tam);
		return celdas;
	}

	private Celda construirCeldaRandom() {
		boolean visible = true;
		int cantAdyacente = 0;
		int estadoRandom = new Random().nextInt(EstadoCelda.values().length);	
		EstadoCelda estado = EstadoCelda.values()[estadoRandom];
		if (estado.equals(EstadoCelda.NUMERO))
			cantAdyacente = new Random().nextInt(8)+1;
		Celda celda = new Celda(visible,estado,cantAdyacente);
		return celda;
	}
	
	public Celda getPos(int i, int j) { return celdas[i][j]; };
	
	public boolean validarTodoMinas() {
		
		int cantMinas = 0;
		for (int i=0; i<tam; i++) {
			for (int j=0; j < tam; j++) {
				if (celdas[i][j].esMina())
					cantMinas++;
			}
		}
		return (tam*tam == cantMinas); 
	}
}

