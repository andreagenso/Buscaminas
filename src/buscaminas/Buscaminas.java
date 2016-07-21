package buscaminas;

public class Buscaminas {
	NivelJuego nivel;
	Matriz matriz;
	
	public Buscaminas(NivelJuego nivel){
		this.nivel = nivel;
		
		switch (this.nivel) {
			case BASICO:
				this.matriz = new Matriz(4);
			case MEDIO:
				this.matriz = new Matriz(15);
			case AVANZADO:
				this.matriz = new Matriz(40);
			default:	
				this.matriz = new Matriz(4);
		}					
	}
	
	public Celda[][] reiniciarJuego(NivelJuego nivel){
		switch (nivel) {
		case BASICO:
			this.matriz = new Matriz(4);
		case MEDIO:
			this.matriz = new Matriz(15);
		case AVANZADO:
			this.matriz = new Matriz(40);
		default:	
			this.matriz = new Matriz(4);
		}
		
		return this.matriz.getCeldas();
	}
	
	public void mostrarJugada(){
		Celda[][] celdas = matriz.getCeldas();
				
		for (int i = 0; i < celdas.length; i++) {
		    for (int j = 0; j < celdas[i].length; j++) {
		        System.out.print("| " + celdas[i][j] + " |");
		    }
		    System.out.println();
		}
	}	
		
	public Celda[][] jugarPosicion(Posicion posicion) {
		if (validarPosicion(posicion)) {			
			matriz.hacerVisible(posicion);					
		}
		return matriz.getCeldas();
	}
	
	public boolean esJuegoGanado(){
		return matriz.validarVisiblesExito();		
	}
	
	public boolean esJuegoPerdido(){
		return matriz.validarVisiblesPierde();
	}
					
	public boolean validarPosicion(Posicion posicion) {
		int i = posicion.x;
		int j = posicion.y;
		
		return (i >= 0 && i <= matriz.getTam() -1) && (j >= 0 && j <= matriz.getTam() -1);				
	}
	
	public void jugar(boolean continuarJuego){
		System.out.println("\t Ingrese posición X");
		
		@SuppressWarnings("resource")
		java.util.Scanner in = new java.util.Scanner(System.in);
		String posicionXStr;
		String posicionYStr;
		int posicionX;
		int posicionY;
				
		posicionXStr = in.next();		
		try{
			if (posicionXStr == "Q") {
				continuarJuego = false;
				return;
			}
			posicionX = Integer.parseInt(posicionXStr);
		} catch (java.util.InputMismatchException m){ posicionX =  -1;}
		catch (Exception e){ posicionX =  -1;}
		
		System.out.println("\t Ingrese posición Y");
		posicionYStr = in.next();
		try{
			if (posicionYStr == "Q") {
				continuarJuego = false;
				return;
			}
			posicionY = Integer.parseInt(posicionXStr);
		}
		catch (java.util.InputMismatchException m){ posicionY =  -1;}
		catch (Exception e){ posicionY =  -1;}
		
		Posicion posicion = new Posicion(posicionX, posicionY);
		jugarPosicion(posicion);
		
		if (esJuegoGanado()){
			System.out.println("GANASTE!");
		} else if (esJuegoPerdido()) {
			System.out.println("PERDISTE!");
		}		
	}
		
}
