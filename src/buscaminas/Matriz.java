package buscaminas;
import java.util.Random;
//import buscaminas.Posicion;

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
		while (validarTodoMinas() || validarTodoVacios()) llenarCeldas(tam);
		return celdas;
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
	
	public boolean validarTodoVacios() {
		
		int cantVacios = 0;
		for (int i=0; i<tam; i++) {
			for (int j=0; j < tam; j++) {
				if (celdas[i][j].esVacio())
					cantVacios++;
			}
		}
		return (tam*tam == cantVacios); 
	}

	public void setPos(int i, int j, Celda aux) { celdas[i][j] = aux; };

	public void llenarConMinas() {
		boolean visible = true;
		int cantMinas = 0, cantAdyacentes = 0;
		Celda aux = new Celda(visible,EstadoCelda.MINA,cantAdyacentes);
	
		while (cantMinas <= tam/2) {
			int randX = new Random().nextInt(tam-1)+1;
			int randY = new Random().nextInt(tam-1)+1;
			celdas[randX][randY] = aux;
			cantMinas++;
		}
	}


	
	
	
	public void hacerVisible(Posicion posicion) {
		celdas[posicion.x][posicion.y].setVisible();
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
	

//llenar adyacentes -> funcion para contar minas
// construitCeldaRandom() -> llenarMinas(), llenarAdyacentes()
}