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
		
		if (aux.esMina()) {
			while (cantMinas <= matriz.getTam()/2) {
				int randX = new Random().nextInt(matriz.getTam()-1)+1;
				int randY = new Random().nextInt(matriz.getTam()-1)+1;
			
				matriz.setPos(randX,randY,aux);
				cantMinas++;
			}
		}
	}

	
	@Test
	public void contarAdyacentesParaCelda(int x,int y) {
		Matriz matriz = new Matriz(4);
		int limiteInferior = 0, limiteSuperior = matriz.getTam() - 1, cantidad = 0;

		for (int i=0; i<matriz.getTam(); i++) {
			for (int j=0; j<matriz.getTam(); j++) {
				if (!matriz.getPos(i, j).getEstado().equals(EstadoCelda.MINA)) {
					for (int a = x-1; a = x+1; a++) {
						for (int b= y-1; b=y+1; b++) {
							if (a >= limiteInferior && a<= limiteSuperior && b >= limiteInferior && b<= limiteSuperior) {
								if (a != i && b!=j && matriz.getPos(a, b).getEstado().equals(EstadoCelda.MINA))
									cantidad++;
							}
						}
					}
					if (cantidad > 0) {
						matriz.getPos(x, y).setEstado(EstadoCelda.NUMERO);
						matriz.getPos(x, y).setCantidadAdyacentes(matriz.getPos(x, y).getCantidadDeAdyacentes()+1);	
					}
					else
						matriz.getPos(x, y).setEstado(EstadoCelda.VACIO);
				}
			}
		}
	}
}