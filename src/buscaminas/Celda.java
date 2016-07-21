package buscaminas;

public class Celda {
	private boolean visible;
	private EstadoCelda estado;
    private int cantAdyacentes;
    
	public Celda(boolean visible, EstadoCelda estado, int cantAdyacentes){
		this.visible = visible;
		this.estado = estado;
		this.cantAdyacentes = cantAdyacentes;
	}
	    
    public boolean esMina(){
    	return (estado.equals(EstadoCelda.MINA) && cantAdyacentes == 0);    	
    }
    
    public boolean esVacio(){
    	return (estado.equals(EstadoCelda.VACIO) && cantAdyacentes == 0);    	
    }
    
    public int getCantidadDeAdyacentes() { return cantAdyacentes; }
    
    public void setCantidadAdyacentes(int val) { cantAdyacentes = val; };
    
    public boolean esVisible(){	return visible;	}
    
    public void setVisible(){ visible = true; }
    
}