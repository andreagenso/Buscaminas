package buscaminas;

public class Celda {
	private boolean estado;
    private int cantAdyacente;
    
	public Celda(boolean estado, int cantAdyacente){
		this.estado = estado;
		this.cantAdyacente = cantAdyacente;
	}
	
    
    public boolean getEstadoCelda(){ return estado; }
    
    public int getCantidadDeAdyacentes() { return cantAdyacente; };
    
}
