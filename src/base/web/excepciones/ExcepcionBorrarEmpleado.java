package base.web.excepciones;

public class ExcepcionBorrarEmpleado extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	
	public ExcepcionBorrarEmpleado(long id) {
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}

}
