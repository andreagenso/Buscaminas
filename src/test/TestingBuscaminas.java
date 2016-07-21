package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestingBuscaminas {

	@Test
	public void test() {
		NivelJuego nivel = NivelJuego.BASICO;
		Posicion posicion = new Posicion(0,0);
		
		Buscaminas buscaminas = new Buscaminas(nivel);
		buscaminas.jugarPosicion(posicion);
		
		assertTrue("validar posicion", buscaminas.validarPosicion(posicion));						
	}

}
