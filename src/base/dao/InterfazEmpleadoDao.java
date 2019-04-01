package base.dao;

import java.util.List;

import base.domain.Empleado;

public interface InterfazEmpleadoDao {

	void persistir(String nombre, String departamento);

	Empleado buscar(long id);

	List<Empleado> listar();

	List<Empleado> buscarPorAtributo(Object campo, Object valor);

	void actualizar(long id, String nombre, String departamento);

	boolean borrar(long id);

}