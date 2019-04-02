package base.dao;

import base.domain.Empleado;
import base.domain.Horario;
import base.domain.Tarea;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)

public class HorarioDao implements InterfazHorarioDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
	public void persistir (Empleado empleado, Tarea tarea, int horas){

        sessionFactory.getCurrentSession().save(new Horario(empleado, tarea, horas));

    }

    @Override
	public Horario buscar(long id){
        return sessionFactory.getCurrentSession().get(Horario.class, id);
    }

    @Override
	public List<Horario> listar(){
        Query q = sessionFactory.getCurrentSession().createQuery(" from Horario ");

        return q.list();
    }

    @Override
	public List<Horario> buscarPorAtributo(Object campo, Object valor) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Horario where " + campo + " = :atributo");
        q.setParameter("atributo", valor);


        return q.list();
    }


    @Override
	public void actualizar(long id, Empleado empleado, Tarea tarea, int horas) {


        Horario horario = sessionFactory.getCurrentSession().get(Horario.class, id);
        horario.setHoras(horas);
        horario.setAsignado(empleado);
        horario.setTarea(tarea);

        sessionFactory.getCurrentSession().saveOrUpdate(tarea);
    }

    @Override
	public boolean borrar(long id){

        Horario horario = sessionFactory.getCurrentSession().get(Horario.class, id);


        sessionFactory.getCurrentSession().delete(horario);
        return true;
    }

	@Override
	public List<Horario> buscarPorEmpleado(long id) {
		Query q = sessionFactory.getCurrentSession().createQuery("from Horario where empleado_id = :atributo");
        q.setParameter("atributo", id);


        return q.list();
	}

}
