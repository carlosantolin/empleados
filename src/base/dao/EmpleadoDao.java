package base.dao;

import base.domain.Empleado;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)

public class EmpleadoDao implements InterfazEmpleadoDao {

    @Autowired
    private SessionFactory sessionFactory;
    private InterfazTareaDao tareaDao;
    private InterfazHorarioDao horarioDao;


    @Override
	public void persistir (String nombre, String departamento){

        sessionFactory.getCurrentSession().save(new Empleado(nombre, departamento));

    }

    @Override
	public Empleado buscar(long id){
        return sessionFactory.getCurrentSession().get(Empleado.class, id);
    }

    @Override
	public List<Empleado> listar(){
        Query q = sessionFactory.getCurrentSession().createQuery(" from Empleado");

        return q.list();
    }

    @Override
	public List<Empleado> buscarPorAtributo(Object campo, Object valor) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Empleado where " + campo + " = :atributo");
        q.setParameter("atributo", valor);


        return q.list();
    }


    @Override
	public void actualizar(long id, String nombre, String departamento) {


        Empleado empleado = sessionFactory.getCurrentSession().get(Empleado.class, id);
        empleado.setDepartamento(departamento);
        empleado.setNombre(nombre);


        sessionFactory.getCurrentSession().saveOrUpdate(empleado);
    }

    @Override
	public boolean borrar(long id){

        Empleado empleado = sessionFactory.getCurrentSession().get(Empleado.class, id);
        if(!tareaDao.buscarPorAtributo("empleado_id", empleado.getId()).isEmpty()){ //No asignado a ningua tarea
            return false;
        }

        if(!horarioDao.buscarPorAtributo("empleado_id", empleado.getId()).isEmpty()){//No asignado a horario
            return false;
        }

        sessionFactory.getCurrentSession().delete(empleado);
        return true;
    }


}
