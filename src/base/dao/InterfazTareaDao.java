package base.dao;

import java.util.List;

import base.domain.Empleado;
import base.domain.Jefe;
import base.domain.Tarea;

public interface InterfazTareaDao {

	void persistir(String descripcion, Jefe jefe, List<Empleado> empleados);

	Tarea buscar(long id);

	List<Tarea> listar();

	List<Tarea> buscarPorAtributo(Object campo, Object valor);

	void actualizar(long id, String descripcion, boolean completada, Jefe jefe, List<Empleado> empleados);

	boolean borrar(long id);

}