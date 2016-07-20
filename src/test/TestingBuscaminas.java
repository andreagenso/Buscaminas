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
        
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSiTieneMina() {    	
    	Celda celda = new Celda(true,1);
    	
    	boolean result = celda.getEstadoCelda();
        assertTrue(result);
    }
    
}
