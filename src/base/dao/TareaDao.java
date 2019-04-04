package base.dao;

import base.domain.Empleado;
import base.domain.Horario;
import base.domain.Jefe;
import base.domain.Tarea;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class TareaDao implements InterfazTareaDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    private InterfazHorarioDao horarioDao;


    @Override
	public void persistir (String descripcion, Jefe jefe, List<Empleado> empleados){

        sessionFactory.getCurrentSession().save(new Tarea(empleados, jefe, descripcion, false));

    }

    @Override
	public Tarea buscar(long id){
        return sessionFactory.getCurrentSession().get(Tarea.class, id);
    }

    @Override
	public List<Tarea> listar(){
        Query q = sessionFactory.getCurrentSession().createQuery(" from Tarea");

        return q.list();
    }

    @Override
	public List<Tarea> buscarPorAtributo(Object campo, Object valor) {
        Query q = sessionFactory.getCurrentSession().createQuery("from Tarea where " + campo + " = :atributo");
        q.setParameter("atributo", valor);


        return q.list();
    }
    
    public List buscarPorEmpleado(long id) {
        Query q = sessionFactory.getCurrentSession().createNativeQuery("select tarea_id from tarea_empleado where empleado_id = ?1");
        q.setParameter(1, id);

        	List resultado = q.list();

        return resultado;
    }

    @Override
	public void actualizar(long id, String descripcion, boolean completada, Jefe jefe,
                           List<Empleado> empleados) {


        Tarea tarea = sessionFactory.getCurrentSession().get(Tarea.class, id);
        tarea.setDescripcion(descripcion);
        tarea.setCompletada(completada);
        tarea.setJefe(jefe);
        for(Empleado e: empleados){
            tarea.pushEmpleado(e);
        }

        sessionFactory.getCurrentSession().saveOrUpdate(tarea);
    }

    @Override
	public boolean borrar(long id){

        Tarea tarea = sessionFactory.getCurrentSession().get(Tarea.class, id);
        
        

        if(!horarioDao.buscarPorAtributo("tarea_id", tarea.getId()).isEmpty()){ // asignada a horario
            return false;
        }
        
        //borramos de la tabla asociada
        Query q = sessionFactory.getCurrentSession().createNativeQuery("delete from tarea_empleado where tarea_id = ?1");
        q.setParameter(1, tarea.getId());
        q.executeUpdate();

        sessionFactory.getCurrentSession().delete(tarea);
        return  true;
    }
}
