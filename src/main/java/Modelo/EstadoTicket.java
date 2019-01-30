package Modelo;

public enum EstadoTicket {
	
	TODOS("Cerrado" , String.class), 
	ABIERTOSINDERIVAR("AbiertoSinDerivar" , String.class) ,
	ABIERTODERIVADO("AbiertoDerivado" , String.class) , 
	SOLUCIONADOALAESPERAOK("SolucionadoAlaEsperaOK" , String.class),
	CERRADO("Cerrado" , String.class);
	
	private final String paramName;
	private final Class<?> type;
	
	private EstadoTicket(String paramName, Class<?> type) {
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