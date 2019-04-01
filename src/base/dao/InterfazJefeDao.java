package base.dao;

import java.util.List;

import base.domain.Jefe;

public interface InterfazJefeDao {

	void persistir(String nombre);

	Jefe buscar(long id);

	List<Jefe> listar();

	List<Jefe> buscarPorAtributo(Object campo, Object valor);

	void actualizar(long id, String nombre);

	boolean borrar(long id);

}