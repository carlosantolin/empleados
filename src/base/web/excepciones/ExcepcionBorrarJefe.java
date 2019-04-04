package base.web.excepciones;

public class ExcepcionBorrarJefe extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	
	public ExcepcionBorrarJefe(long id) {
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}

}