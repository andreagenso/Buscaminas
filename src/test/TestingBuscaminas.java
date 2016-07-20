package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import buscaminas.*;


public class TestingBuscaminas {
           
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
    	    	
        assertTrue(true);
    }
       
}
