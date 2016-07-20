package test;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import buscaminas.*;

public class TestingMatriz {

	@Test
    public void validarTam() {
		Matriz matriz = new Matriz(1);
		int resultado = matriz.getTam();
		assertEquals(1,resultado);
	}
}
