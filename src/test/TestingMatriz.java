package test;

import org.junit.Test;
import static org.junit.Assert.*;
import buscaminas.*;

public class TestingMatriz {

	@Test
    public void validarTam() {
		Matriz matriz = new Matriz(1);
		int resultado = matriz.getTam();
		assertEquals(1,resultado);
	}
	
	@Test
	public void validarTodoMinas() {
		int cantMinas = 0;
		Matriz matriz = new Matriz(2);
		for (int i=0; i<matriz.getTam(); i++) {
			for (int j=0; j < matriz.getTam(); i++) {
				if (matriz.getPos(i,j).esMina())
					cantMinas++;
			}
		}
		assertNotEquals(matriz.getTam()*matriz.getTam(),cantMinas);
	}
}
