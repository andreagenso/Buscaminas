package test;

import org.junit.Test;
import static org.junit.Assert.*;
import buscaminas.*;

public class TestingCelda {
           
    @Test
    public void testEsMina() {    	
    	boolean visible = true;
    	EstadoCelda estado = EstadoCelda.MINA;
    	int cantAdyacente = 0;
    	
    	Celda celda = new Celda(visible, estado, cantAdyacente);
    	
    	boolean result = celda.esMina();
        assertTrue(result);
    }
    
    @Test
    public void testSiVacio(){
    	boolean visible = true;
    	EstadoCelda estado = EstadoCelda.VACIO;
    	int cantAdyacente = 0;
    	
    	Celda celda = new Celda(visible, estado, cantAdyacente);
    	
    	boolean result = celda.esVacio();
        assertTrue(result);
    }
    
    @Test
    public void testEsAdyacenteValido(){
    	boolean visible = true;
    	EstadoCelda estado = EstadoCelda.NUMERO;
    	int cantAdyacente = 5;
    	
    	Celda celda = new Celda(visible, estado, cantAdyacente);    	
    	
        boolean result = (celda.getCantidadDeAdyacentes() >= 1 && celda.getCantidadDeAdyacentes() <= 8);
        assertTrue(result);            	
    }
    
    @Test
    public void testEsVisible(){
    	boolean visible = true;
    	EstadoCelda estado = EstadoCelda.NUMERO;
    	int cantAdyacente = 5;
    	
    	Celda celda = new Celda(visible, estado, cantAdyacente);    	
    	
        boolean result = (celda.esVisible());
        assertTrue(result);            	
    }
    
    @Test
    public void mostrarCelda() {
    	boolean visible = true;
    	EstadoCelda estado = EstadoCelda.VACIO;
    	int cantAdyacente = 4;
 
    	if (visible)
    	{
    		if (estado == EstadoCelda.MINA) System.out.print(" [*]");
    		if (estado == EstadoCelda.NUMERO) System.out.print(" [" + cantAdyacente + "]");
    	}
    	if (!visible || estado == EstadoCelda.VACIO) System.out.println(" [ ]");
    }
}






