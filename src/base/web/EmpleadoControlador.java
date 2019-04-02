package base.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import base.dao.EmpleadoDao;
import base.dao.InterfazEmpleadoDao;
import base.domain.Empleado;
import base.web.excepciones.ExcepcionBorrarEmpleado;

@Controller
@RequestMapping("/empleados")
public class EmpleadoControlador {
	
	private InterfazEmpleadoDao empleadoDao;
	
	@Autowired
	public void setEmpleadoDao(EmpleadoDao empleadoDao) {
		this.empleadoDao = empleadoDao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String mostrarEmpleados(Model modelo) {
		List<Empleado> empleados = empleadoDao.listar(); 
		modelo.addAttribute("empleados", empleados);
		
		return "empleados/lista";
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String getEmpleado(@PathVariable("id") long id, Model modelo) {
		Empleado empleado = empleadoDao.buscar(id);
		modelo.addAttribute("empleado", empleado);
		
		return "empleados/ver";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.POST)
	public String getEmpleado(@PathVariable("id") long id, Empleado empleado) {
		empleado.setId(id);
		empleadoDao.actualizar(id, empleado.getNombre(), empleado.getDepartamento());
		
		return "redirect:/empleados";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public String deleteEmpleado(@PathVariable("id") long id) throws ExcepcionBorrarEmpleado{
		boolean estadoBorrado = empleadoDao.borrar(id);
		
		if(!estadoBorrado) {
			throw new ExcepcionBorrarEmpleado(id);
		}
		
		return "redirect:/empleados";
	}
	
	@RequestMapping(params="new", method = RequestMethod.GET)
	public String crearFormularioEmpleado(Model modelo) {
		modelo.addAttribute(new Empleado());
		
		return "empleados/nuevo";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String crearEmpleado(Empleado empleado) {
		empleadoDao.persistir(empleado.getNombre(), empleado.getDepartamento());
		
		return "redirect:/empleados";
	}
	
	
	
	@ExceptionHandler(ExcepcionBorrarEmpleado.class)
	public ModelAndView manejarExcepcionBorrado(ExcepcionBorrarEmpleado e) {
		ModelMap modelo = new ModelMap();
		modelo.put("empleado", empleadoDao.buscar(e.getId()));
		
		return new ModelAndView ("empleados/error-borrado", modelo);
	}
}
