package Modelo;

public enum EstadoIntervencion {
	ASIGNADO("Asignado" , String.class),
	TRABAJANDO("Trabajando", String.class) , 
	EN_ESPERA("En_Espera", String.class) , 
	TERMINADA("Terminada", String.class);
	
	private final String paramName;
	private final Class<?> type;
	
	
	private EstadoIntervencion(String paramName, Class<?> type) {
		this.paramName = paramName;
		this.type = type;
		
	}
	
	
	public String getParamName() {
        return paramName;
    }

    public String getTypeName() {
        return type.getSimpleName();
}
	
}