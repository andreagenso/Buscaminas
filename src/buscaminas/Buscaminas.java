package buscaminas;

public class Buscaminas {
	NivelJuego nivel;
	Matriz matriz;
	
	public Buscaminas(NivelJuego nivel){
		this.nivel = nivel;
		
		switch (this.nivel) {
			case BASICO:
				this.matriz = new Matriz(4);
				break;
			case MEDIO:
				this.matriz = new Matriz(15);
				break;
			case AVANZADO:
				this.matriz = new Matriz(40);
				break;
			default:	
				this.matriz = new Matriz(4);
				break;
		}					
	}	
	
	public void mostrarJugada(){
		Celda[][] celdas = matriz.getCeldas();
				
		for (int i = 0; i < celdas.length; i++) {
		    for (int j = 0; j < celdas[i].length; j++) {
		        celdas[i][j].mostrarCelda();
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
		int i = posicion.fila;
		int j = posicion.columna;
		
		return (i >= 0 && i <= matriz.getTam() -1) && (j >= 0 && j <= matriz.getTam() -1);				
	}
	
	public boolean jugar(){
		boolean continuarJuego = true;
		System.out.println("\t Ingrese posición X:");
		
		@SuppressWarnings("resource")
		java.util.Scanner in = new java.util.Scanner(System.in);
		String filaStr;
		String columnaStr;
		int fila;
		int columna;
				
		filaStr = in.next();		
		try{
			if (filaStr.equals("Q")) {
				continuarJuego = false;
				return continuarJuego;				
			} else {
				fila = Integer.parseInt(filaStr);
				
				System.out.println("\t Ingrese posición Y:");
				columnaStr = in.next();
				try{
					if (columnaStr.equals("Q")) {
						continuarJuego = false;
						return continuarJuego;
					}
					columna = Integer.parseInt(columnaStr);
					
					Posicion posicion = new Posicion(fila, columna);
					jugarPosicion(posicion);
					
					if (esJuegoGanado()){
						System.out.println("******** GANASTE! :D :D FELICIDADES! TE ANIMAS OTRA JUGADA? ******** ");
						continuarJuego = false;
					} else if (esJuegoPerdido()) {
						System.out.println("XXXXXXXX PERDISTE! :'( :'( XXXXXXXXX ");
						continuarJuego = false;
					}		
				}
				catch (java.util.InputMismatchException m){ columna =  -1;}
				catch (Exception e){ columna =  -1;}				
			} 
			
		} catch (java.util.InputMismatchException m){ fila =  -1;}
		catch (Exception e){ fila =  -1;}
						
		return continuarJuego;
	}
	
	public void mostrarInstruccionesIniciales() {
		System.out.println("**** INICIANDO JUEGO BUSCAMINAS *****");
		System.out.println("\t ingrese un numero para elegir una fila como posicion X, ");
		System.out.println("\t posteriormente otro número para elgir la columna como posición y");
		System.out.println("\t Q) Para salir del juego.");
		switch (nivel) {
		case BASICO:
			System.out.println("- NIVEL -BASICO");
			break;
		case MEDIO:
			System.out.println("- NIVEL -MEDIO");
			break;
		case AVANZADO:
			System.out.println("- NIVEL -AVANZADO");
			break;
		default:	
			System.out.println("- NIVEL -BASICO");
			break;
		}
		
	}
		
}
