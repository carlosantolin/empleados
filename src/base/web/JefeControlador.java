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


import base.dao.InterfazJefeDao;
import base.dao.JefeDao;
import base.domain.Jefe;
import base.web.excepciones.ExcepcionBorrarJefe;

@Controller
@RequestMapping("/jefes")
public class JefeControlador {

private InterfazJefeDao jefeDao;
	
	@Autowired
	public void setJefeDao(JefeDao jefeDao) {
		this.jefeDao = jefeDao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String mostrarJefes(Model modelo) {
		List<Jefe> jefes = jefeDao.listar(); 
		modelo.addAttribute("jefes", jefes);
		
		return "jefes/lista";
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String getJefe(@PathVariable("id") long id, Model modelo) {
		Jefe jefe = jefeDao.buscar(id);
		modelo.addAttribute("jefe", jefe);
		
		return "jefes/ver";
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.POST)
	public String updateJefe(@PathVariable("id") long id, Jefe jefe) {
		jefe.setId(id);
		jefeDao.actualizar(id, jefe.getNombre());
		
		return "redirect:/jefes";
	}
	
	@RequestMapping(value="/borrar/{id}", method = RequestMethod.POST)
	public String deleteJefe(@PathVariable("id") long id) throws ExcepcionBorrarJefe{
		boolean estadoBorrado = jefeDao.borrar(id);
		
		if(!estadoBorrado) {
			throw new ExcepcionBorrarJefe(id);
		}
		
		return "redirect:/jefes";
	}
	
	@RequestMapping(params="nuevo", method = RequestMethod.GET)
	public String crearFormularioJefe(Model modelo) {
		modelo.addAttribute(new Jefe());
		
		return "jefes/nuevo";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String crearEmpleado(Jefe jefe) {
		jefeDao.persistir(jefe.getNombre());
		
		return "redirect:/jefes";
	}
	
	
	
	@ExceptionHandler(ExcepcionBorrarJefe.class)
	public ModelAndView manejarExcepcionBorrado(ExcepcionBorrarJefe e) {
		ModelMap modelo = new ModelMap();
		modelo.put("jefe", jefeDao.buscar(e.getId()));
		
		return new ModelAndView ("jefes/error-borrado", modelo);
	}
}
