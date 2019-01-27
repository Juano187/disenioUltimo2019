package Modelo;
import java.util.Date;
import Controlador.GestorBDD;

abstract class HistorialABS {
	GestorBDD gbdd = new GestorBDD();

	private Date hora_fecha_ini;
	private Date hora_fecha_fin;
	private String user;
	private Integer id_historial;
	public HistorialABS() {
		
	}
	public HistorialABS(String u, Date fecha) {
	
		this.user=u;
		this.hora_fecha_ini= fecha;
		this.hora_fecha_fin = null;
	}
	public static void main(String[] args) {
		
	}
	
	public boolean ultimaFechaVacia() {
		if(this.hora_fecha_fin == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public String getUsuario() {
		return this.user;
	}
	
	public int getIdHistorial() {
		return this.id_historial;
	}
	
	public void setfinal(Date a) {
		this.hora_fecha_fin = a;
	}
}
