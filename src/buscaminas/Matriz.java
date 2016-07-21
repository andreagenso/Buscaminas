package buscaminas;
import java.util.Random;

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

public void llenarConMinas() {
	Celda aux = construirCeldaRandom();
	int cantMinas = 0;
	
	if (aux.esMina()) {
		while (cantMinas <= tam/2) {
			int randX = new Random().nextInt(tam-1)+1;
			int randY = new Random().nextInt(tam-1)+1;
		
			celdas[randX][randY] = aux;
			cantMinas++;
		}
	}
}







//llenar adyacentes -> funcion para contar minas
// construitCeldaRandom() -> llenarMinas(), llenarAdyacentes()


}