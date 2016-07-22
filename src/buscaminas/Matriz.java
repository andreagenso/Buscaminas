package buscaminas;
import java.util.Random;
//import buscaminas.Posicion;

public class Matriz {
	private int tam;
	private Celda[][] celdas;
	
	public Celda[][] getCeldas() { return celdas; };
	
	public Matriz(int tam) {
		this.tam = tam;
		this.celdas = llenarCeldasConVacio();
	}
	
	public int getTam() { return tam; }
	
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
	
		while (cantMinas <= ((tam*tam)/2)) {
			int randX = new Random().nextInt(tam-1) + 1; 
			int randY = new Random().nextInt(tam-1) + 1;
			celdas[randX][randY] = aux;
			cantMinas++;
		}
	}
	
	public void contarAdyacentesParaCelda(int x, int y) {
		int limiteInferior = 0, limiteSuperior = tam - 1, cantidad = 0;
	
		for (int i=0; i<tam; i++) {
			for (int j=0; j<tam; j++) {
				if (!getPos(i,j).getEstado().equals(EstadoCelda.MINA)) {
					
					for (int a = x-1; a <= x+1; a++) {
						for (int b= y-1; b <= y+1; b++) {
							if (a >= limiteInferior && a<= limiteSuperior && b >= limiteInferior && b<= limiteSuperior) {
								if (getPos(a,b) != getPos(x,y))
								{	
									if (getPos(a, b).getEstado().equals(EstadoCelda.MINA))
										cantidad++;
								}
							}
						}
					}
					if (cantidad > 0) {
						getPos(x, y).setEstado(EstadoCelda.NUMERO);
						getPos(x, y).setCantidadAdyacentes(cantidad);	
					}
					else
						getPos(x, y).setEstado(EstadoCelda.VACIO);
				}
			}
		}
	}
	
	public Celda[][] llenarCeldasConVacio() {
		this.celdas = new Celda[tam][tam];
		boolean visible = true;
		EstadoCelda estado = EstadoCelda.VACIO;
		int cantAdyacentes = 0;
		for (int i=0; i< tam; i++) {
			for (int j=0; j < tam; j++) {
				celdas[i][j] = new Celda(visible, estado, cantAdyacentes);
				celdas[i][j].setVisible();
				celdas[i][j].setEstado(EstadoCelda.VACIO);
				celdas[i][j].setCantidadAdyacentes(0);
			}
		}
		return celdas;
	}

	public void mostrarMatriz() {
		for (int i=0; i< tam; i++) {
			for (int j=0; j < tam; j++)
				celdas[i][j].mostrarCelda();
			System.out.println(" ");
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
	
	/*
	 * Verifica si todas las celdas que no son mina, estan visibles
	 * @return true si todas las celdas que no son minas estan visibles
	 */
	public boolean validarVisiblesExito(){
		boolean resultado = true;
		for (int i=0; i<tam;i++){
			for (int j=0; j<tam; j++) {
				if (!celdas[i][j].esMina())
					if (!celdas[i][j].esVisible()) {
						resultado = false;
						break;
					}
			}
		}
		return resultado;
	}
	
	/*
	 * @return true si al menos una mina es visible
	 */
	public boolean validarVisiblesPierde(){
		boolean resultado = false;
		for (int i=0; i<tam;i++){
			for (int j=0; j<tam; j++) {
				if (celdas[i][j].esMina() && celdas[i][j].esVisible()) {
					resultado = true;
					break;
				}					
			}
		}
		return resultado;
	}

//llenar adyacentes -> funcion para contar minas
// construitCeldaRandom() -> llenarMinas(), llenarAdyacentes()
}