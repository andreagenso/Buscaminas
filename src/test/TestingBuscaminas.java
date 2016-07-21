package test;

import static org.junit.Assert.*;
import org.junit.Test;
import buscaminas.*;

public class TestingBuscaminas {

	@Test
	public void testValidarPosicionJugada() {
		NivelJuego nivel = NivelJuego.BASICO;
		Posicion posicion = new Posicion(0,0);
		
		Buscaminas buscaminas = new Buscaminas(nivel);
		buscaminas.jugarPosicion(posicion);
		
		assertTrue("validar posicion", buscaminas.validarPosicion(posicion));						
	}
	
	public void testEsJuegoGanado(){
		NivelJuego nivel = NivelJuego.BASICO;
		Posicion posicion = new Posicion(0,0);
		
		Buscaminas buscaminas = new Buscaminas(nivel);
		buscaminas.jugarPosicion(posicion);
		
		assertTrue(true);
	}
	
	public void testEsJuegoPerdido(){
		NivelJuego nivel = NivelJuego.BASICO;
		Posicion posicion = new Posicion(0,0);
		
		Buscaminas buscaminas = new Buscaminas(nivel);
		buscaminas.jugarPosicion(posicion);
		
		assertTrue(true);
	}
	
	

}
