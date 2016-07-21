package buscaminas;

public class Buscaminas {
	NivelJuego nivel;
	Matriz matriz;
	
	public Buscaminas(NivelJuego nivel){
		this.nivel = nivel;
		
		switch (this.nivel) {
			case BASICO:
				matriz = new Matriz(4);
			case MEDIO:
				matriz = new Matriz(15);
			case AVANZADO:
				matriz = new Matriz(40);
			default:	
				matriz = new Matriz(4);
		}		
			
	}
	
	public Celda[][] jugarPosicion(Posicion posicion) {
		if (validarPosicion(posicion)) {			
			matriz.hacerVisible(posicion);					
		}
		return matriz.getCeldas();
	}
	
	public boolean esJuegoGanado(){
		//return matriz.validarVisiblesExitosas;
		return true;
	}
	
	public boolean esJuegoPerdido(){
		return true;
	}
					
	public boolean validarPosicion(Posicion posicion) {
		int i = posicion.x;
		int j = posicion.y;
		
		return (i >= 0 && i <= matriz.getTam() -1) && (j >= 0 && j <= matriz.getTam() -1);				
	}
		
}
