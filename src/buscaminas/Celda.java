package buscaminas;

public class Celda {
	private boolean visible;
	private EstadoCelda estado;
    private int cantAdyacente;
    
	public Celda(boolean visible, EstadoCelda estado, int cantAdyacente){
		this.visible = visible;
		this.estado = estado;
		this.cantAdyacente = cantAdyacente;
	}	      
    
}