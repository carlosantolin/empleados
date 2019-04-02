package base.web.excepciones;

public class ExcepcionBorrarEmpleado extends Exception {
	
	private long id;
	
	public ExcepcionBorrarEmpleado(long id) {
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}

}
