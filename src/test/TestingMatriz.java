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
	public void validarVisiblesPierdeConTodoMinasVisible(){
		Matriz matriz = new Matriz(4);
		// hacer todas las minas visibles
		for (int i=0; i<matriz.getTam(); i++) {
			for (int j=0; j < matriz.getTam(); j++) {
				if (matriz.getPos(i,j).esMina())
					matriz.getCeldas()[i][j].setVisible();
			}
		}
		
		assertTrue("validar que al menos hay una mina visible, entonces pierde", matriz.validarVisiblesPierde());
	}
	
	@Test
	public void validarVisiblesPierdeConUnaMinaVisible(){
		Matriz matriz = new Matriz(4);
		// hacer todas las minas visibles
		for (int i=0; i<matriz.getTam(); i++) {
			for (int j=0; j < matriz.getTam(); j++) {
				if (matriz.getPos(i,j).esMina()){
					matriz.getCeldas()[i][j].setVisible();
					break;
				}
			}
		}
		
		assertTrue("validar que al menos hay una mina visible, entonces pierde", matriz.validarVisiblesPierde());
	}
	
	@Test
	public void validarVisiblesExito(){
		Matriz matriz = new Matriz(4);
		// hacer todas las celdas que no son mina visibles
		for (int i=0; i<matriz.getTam(); i++) {
			for (int j=0; j < matriz.getTam(); j++) {
				if (!matriz.getPos(i,j).esMina()){
					matriz.getCeldas()[i][j].setVisible();
					break;
				}
			}
		}
		
		assertTrue("validar que todas las celdas que no son mina son visibles, entonces gana", matriz.validarVisiblesExito());
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

	
	
	
	/*
	public void contarAdyacentesParaCelda(int i,int j) {
		Matriz matriz = new Matriz(2);
		int cantAdyacente = 0;
		boolean visible = true;
	
			
			int estadoRandom = new Random().nextInt(EstadoCelda.values().length);	
			EstadoCelda estado = EstadoCelda.values()[estadoRandom];
			Celda aux = new Celda(visible,estado,cantAdyacente);
			
			matriz.setPos(i-1, j-1, aux);
			matriz.setPos(i-1, j, aux);
			matriz.setPos(i-1, j+1, aux);
			matriz.setPos(i, j, aux);
			matriz.setPos(i+1, j+1, aux);
			matriz.setPos(i+1, j, aux);
			matriz.setPos(i+1, j-1, aux);
			matriz.setPos(i, j-1, aux);	
		
		
	
	}
	
}

[i][j+1],[i+1][j+1],[i+1][j],[i+1][j-1],[i][j-1]
		if (estado.equals(EstadoCelda.NUMERO))
			Celda aux = new Celda(visible.);

*/
}