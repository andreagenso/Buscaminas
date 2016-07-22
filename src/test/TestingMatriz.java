package test;

import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.*;
import buscaminas.*;

public class TestingMatriz {

	@Test
    public void validarTam() {
		Matriz matriz = new Matriz(2);
		int resultado = matriz.getTam();		
		assertEquals(resultado,2);
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
	public void contarAdyacentesParaCelda() {
		Matriz matriz = new Matriz(4);
		int x = 0, y = 3;
		int limiteInferior = 0, limiteSuperior = matriz.getTam() - 1, cantidad = 0;
	
		for (int i=0; i<matriz.getTam(); i++) {
			for (int j=0; j<matriz.getTam(); j++) {
				if (matriz.getPos(i, j).getEstado() != EstadoCelda.MINA) {
					
					for (int a = x-1; a <= x+1; a++) {
						for (int b= y-1; b <= y+1; b++) {
							if (a >= limiteInferior && a<= limiteSuperior && b >= limiteInferior && b<= limiteSuperior) {
								if (matriz.getPos(a,b) != matriz.getPos(x,y))
								{	
									if (matriz.getPos(a,b).getEstado().equals(EstadoCelda.MINA))
										cantidad++;
								}
							}
						}
					}
					if (cantidad > 0) {
						matriz.getPos(x, y).setEstado(EstadoCelda.NUMERO);
						matriz.getPos(x, y).setCantidadAdyacentes(cantidad);	
					}
				}
			}
		}
	}
	
		@Test
		public void llenarCeldasConVacio() {
			int tam = 5;
			Matriz matriz = new Matriz(tam);
			for (int i=0; i< matriz.getTam(); i++) {
				for (int j=0; j<matriz.getTam(); j++) {
					matriz.getPos(i,j).setVisible();
					matriz.getPos(i,j).setEstado(EstadoCelda.VACIO);
					matriz.getPos(i,j).setCantidadAdyacentes(0);
				}
			}
		}
	
		//@Test
		public void mostrarMatriz() {
			int tam = 5;
			Matriz matriz = new Matriz(tam);
			for (int i=0; i< matriz.getTam(); i++) {
				for (int j=0; j<matriz.getTam(); j++)
					matriz.getPos(i,j).mostrarCelda();
				System.out.println(" ");
			}
		}
		
		@Test
		public void llenarMatrizAleatoriamente() {
			int tam = 5;
			Matriz matriz = new Matriz(tam);
			matriz.llenarConMinas();
			for (int i=0; i< matriz.getTam(); i ++) {
				for (int j=0; j<matriz.getTam(); j++)
					matriz.contarAdyacentesParaCelda(i, j);
			}
			matriz.mostrarMatriz();
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
	public void mostrarAdyacentes() {
		Matriz matriz = new Matriz(5);
		Celda aux = new Celda(true,EstadoCelda.VACIO,0);
		Celda c1 = new Celda(true,EstadoCelda.MINA,0);
		Celda c2 = new Celda(true,EstadoCelda.MINA,0);
		Celda c3 = new Celda(true,EstadoCelda.MINA,0);
		Celda c4 = new Celda(true,EstadoCelda.MINA,0);
		Celda c5 = new Celda(true,EstadoCelda.VACIO,0);
		int x = 0, y =3;
		matriz.setPos(x, y, aux);
		matriz.setPos(0, 2, c1); 
		matriz.setPos(1, 2, c2);
		matriz.setPos(1, 3, c3);
		matriz.setPos(1, 4, c4); 
		matriz.setPos(0, 4, c5);
		
		int limiteInferior = 0, limiteSuperior = matriz.getTam() - 1, cantidad = 0;

		for (int a = x-1; a <= x+1; a++) {

			for (int b= y-1; b <= y+1; b++) {
				if (a >= limiteInferior && a<= limiteSuperior && b >= limiteInferior && b<= limiteSuperior) {
					if (matriz.getPos(a,b) != matriz.getPos(x,y))
					{	
						if (matriz.getPos(a, b).getEstado().equals(EstadoCelda.MINA))
							cantidad++;
					}
				}
			}
		}
		if (cantidad > 0) {
			matriz.getPos(x, y).setEstado(EstadoCelda.NUMERO);
			matriz.getPos(x, y).setCantidadAdyacentes(cantidad);	
		}
		else
			matriz.getPos(x, y).setEstado(EstadoCelda.VACIO);
	
	//System.out.println(matriz.getPos(x, y).getCantidadDeAdyacentes()+" " + matriz.getPos(x, y).getEstado().toString());
	}
	
	
}

