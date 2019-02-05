

public class ClasificacionDTO {
	
	private String nombre;
	
	private Integer codCla;



	public ClasificacionDTO() {
		
	}
	
	
	public ClasificacionDTO(String a, Integer codCla) {
		this.codCla= codCla;
		this.nombre = a;
	}
	public ClasificacionDTO(String a) {
		
		this.nombre = a;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getCodCla() {
		return codCla;
	}

	public void setCodCla(Integer codCla) {
		this.codCla = codCla;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
}

