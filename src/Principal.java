import buscaminas.Buscaminas;
import buscaminas.NivelJuego;

public class Principal {

	public static void main(String[] args) {
		
		Buscaminas buscaminas;
		
		// interaccion con el teclado
		@SuppressWarnings("resource")
		java.util.Scanner in = new java.util.Scanner(System.in);		
		String opcionStr;
		
				
		boolean continuarJuego = true;
		boolean jugar = true;
				
		System.out.println("BIENVENIDO AL JUEGO BUSCAMINAS * * *");
		while(continuarJuego){									
			System.out.println("POR FAVOR ELIJA UNA DE LAS OPCIONES: ");
			System.out.println("\t B) Para elegir el nivel BASICO de juego");
			System.out.println("\t M) Para elegir el nivel MEDIO de juego");
			System.out.println("\t A) Para elegir el nivel AVANZADO de juego");
			System.out.println("\t E) Para empezar el juego");
			System.out.println("\t Q) Para salir del juego");			
						
			opcionStr = in.next();
			switch (opcionStr) {
			case "B" :
				buscaminas = new Buscaminas(NivelJuego.BASICO);
				buscaminas.mostrarJugada();
				
				System.out.println("INICIANDO JUEGO .... ");
				System.out.println("\t ingrese un numero para elegir una fila como posicion X, "
						+ "posteriormente otro número para elgir la columna como posición y");
				System.out.println("\t Q) Para salir del juego.");
								
				while(jugar){
					buscaminas.jugar(jugar);	
					buscaminas.mostrarJugada();
				}																								
				break;
			case "M" :
				buscaminas = new Buscaminas(NivelJuego.MEDIO);
				buscaminas.mostrarJugada();
				
				System.out.println("INICIANDO JUEGO .... bla bla instrucciones para jugo MEDIO ");
				System.out.println("\t ingrese un numero para elegir una fila como posicion X, "
						+ "posteriormente otro número para elgir la columna como posición y");
				System.out.println("\t Q) Para salir del juego.");
								
				while(jugar){
					buscaminas.jugar(jugar);
					buscaminas.mostrarJugada();
				}																								
				break;				
			case "A" :
				buscaminas = new Buscaminas(NivelJuego.BASICO);
				buscaminas.mostrarJugada();
				
				System.out.println("INICIANDO JUEGO .... bla bla instrucciones para juego AVANZADO ");
				System.out.println("\t ingrese un numero para elegir una fila como posicion X, "
						+ "posteriormente otro número para elgir la columna como posición y");
				System.out.println("\t Q) Para salir del juego.");
								
				while(jugar){
					buscaminas.jugar(jugar);	
					buscaminas.mostrarJugada();
				}																								
				break;						
			case "Q" :
				System.out.println("\t ADIOS ... ");
				continuarJuego = false;
				break;			
			default :	
				System.out.println("\tOPCION DESCONOCIDA, POR FAVOR ELIJA UNA OPCION NUEVAMENTE!");
				break;
			}
		}		

		
	}

}
