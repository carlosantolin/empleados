package base.dao;

import java.util.List;

import base.domain.Empleado;
import base.domain.Horario;
import base.domain.Tarea;

public interface InterfazHorarioDao {

	void persistir(Empleado empleado, Tarea tarea, int horas);

	Horario buscar(long id);

	List<Horario> listar();

	List<Horario> buscarPorAtributo(Object campo, Object valor);

	void actualizar(long id, Empleado empleado, Tarea tarea, int horas);

	boolean borrar(long id);

	List<Horario> buscarPorEmpleado(long id);

}