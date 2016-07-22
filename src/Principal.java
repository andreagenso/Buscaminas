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
			
			System.out.println("---------------------------------------");
			System.out.println("POR FAVOR ELIJA UNA DE LAS OPCIONES: ");
			System.out.println("\t B) Para elegir el nivel BASICO de juego");
			System.out.println("\t M) Para elegir el nivel MEDIO de juego");
			System.out.println("\t A) Para elegir el nivel AVANZADO de juego");			
			System.out.println("\t Q) Para salir del juego");			
						
			opcionStr = in.next();
								
			switch (opcionStr) {
			case "B" :
				jugar = true;
				buscaminas = new Buscaminas(NivelJuego.BASICO);
				buscaminas.mostrarInstruccionesIniciales();							
				buscaminas.mostrarJugada();
								
				
				while(jugar){
					jugar = buscaminas.jugar();					
					buscaminas.mostrarJugada();
				}																								
				break;
			case "M" :
				jugar = true;				
				buscaminas = new Buscaminas(NivelJuego.MEDIO);
				buscaminas.mostrarInstruccionesIniciales();
				buscaminas.mostrarJugada();
								
				while(jugar){
					jugar = buscaminas.jugar();
					buscaminas.mostrarJugada();
				}																								
				break;				
			case "A" :
				jugar = true;				
				buscaminas = new Buscaminas(NivelJuego.AVANZADO);
				buscaminas.mostrarInstruccionesIniciales();
				buscaminas.mostrarJugada();
								
				while(jugar){
					jugar = buscaminas.jugar();	
					buscaminas.mostrarJugada();
				}																								
				break;						
			case "Q" :
				jugar = true;
				System.out.println("\t ADIOS ... *** VUELVE PRONTO ... SI TE ATREVES :D *** ");
				continuarJuego = false;
				break;			
			default :	
				jugar = true;
				System.out.println("\tOPCION DESCONOCIDA, POR FAVOR ELIJA UNA OPCION NUEVAMENTE!");
				break;
			}
		}		

		
	}

}
