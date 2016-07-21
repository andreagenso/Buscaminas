package test;

import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.*;
import buscaminas.*;
import static org.hamcrest.CoreMatchers.*;

public class TestingMatriz {

	@Test
    public void validarTam() {
		Matriz matriz = new Matriz(1);
		int resultado = matriz.getTam();		
		assertThat(resultado,is(1));
	}
	
	@Test
	public void validarTodoMinas() {
		int cantMinas = 0;
		Matriz matriz = new Matriz(2);
		for (int i=0; i<matriz.getTam(); i++) {
			for (int j=0; j < matriz.getTam(); j++) {
				if (matriz.getPos(i,j).esMina())
					cantMinas++;
			}
		}
		assertNotEquals(matriz.getTam()*matriz.getTam(),cantMinas);
	}
	
	@Test
	public void validarTodoVacios() {
		int cantVacios = 0;
		Matriz matriz = new Matriz(2);
		for (int i=0; i<matriz.getTam(); i++) {
			for (int j=0; j < matriz.getTam(); j++) {
				if (matriz.getPos(i,j).esVacio())
					cantVacios++;
			}
		}
		assertNotEquals(matriz.getTam()*matriz.getTam(),cantVacios);
	}
	
	@Test
	public void llenarConMinas() {
		Matriz matriz = new Matriz(2);
		boolean visible = true;
		int cantAdyacente = 0;
		Celda aux = new Celda(visible,EstadoCelda.MINA,cantAdyacente);
		int cantMinas = 0;
		int randX = new Random().nextInt(matriz.getTam()-1)+1;
		int randY = new Random().nextInt(matriz.getTam()-1)+1;
		
		while (cantMinas <= matriz.getTam()/2) {
			matriz.setPos(randX,randY,aux);
		}
	}
}