package base.web.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.dao.*;
import base.domain.*;
import base.service.TareaService;

@Service
public class GeneradorEntidades {
	
	@Autowired
	InterfazEmpleadoDao empleadoDao;
	
	@Autowired
	InterfazJefeDao jefeDao;
	
	@Autowired
	InterfazTareaDao tareaDao;
	
	@Autowired
	InterfazHorarioDao horarioDao;
	
	@Autowired
	TareaService tareaService;

	
	public void generar() {
		
		
		empleadoDao.persistir("Carlos", "Desarrollo");
		empleadoDao.persistir("Laura", "Marketing");
		empleadoDao.persistir("Peyu", "Reclusos");

		empleadoDao.persistir("Frodo", "Aventura");
		empleadoDao.persistir("Sam", "Aventura");
		empleadoDao.persistir("Pippin", "Aventura");
		empleadoDao.persistir("Merry", "Aventura");
		
		jefeDao.persistir("Gustavo");
		jefeDao.persistir("Andy");

		jefeDao.persistir("Kira");
		jefeDao.persistir("Nala");
		
		Empleado carlos = empleadoDao.buscarPorAtributo("nombre", "Carlos").get(0);
		Empleado laura = empleadoDao.buscarPorAtributo("nombre", "Laura").get(0);
		Empleado peyu = empleadoDao.buscarPorAtributo("nombre", "Peyu").get(0);
		
		Jefe gustavo = jefeDao.buscarPorAtributo("nombre", "Gustavo").get(0);
		Jefe andy = jefeDao.buscarPorAtributo("nombre", "Andy").get(0);

		
		List<Empleado> una = new ArrayList<Empleado>();
		una.add(carlos);
		una.add(laura);
		
		List<Empleado> otra = new ArrayList<Empleado>();
		otra.add(peyu);
		
		List<Empleado> otramas = new ArrayList<Empleado>();
		otramas.add(carlos);

	
		tareaDao.persistir("Trasteando con spring", andy, una);
		tareaDao.persistir("Tambien hibernate", gustavo, otra);
		tareaDao.persistir("Y springMVC", andy, otramas);
		
		
		horarioDao.persistir(carlos, tareaService.tareasDeEmpleado(carlos).get(0), 10);
		
		horarioDao.persistir(peyu, tareaService.tareasDeEmpleado(peyu).get(0), 10);
		
	}
	
	public void borrar() {
		List<Horario> horario = horarioDao.listar();
		for(Horario h: horario) {
			horarioDao.borrar(h.getId());
		}
		
		List<Tarea> tarea = tareaDao.listar();
		for(Tarea t: tarea) {
			tareaDao.borrar(t.getId());
		}
		
		List<Jefe> jefe = jefeDao.listar();
		for(Jefe j: jefe) {
			jefeDao.borrar(j.getId());
		}
		
		
		List<Empleado> empleado = empleadoDao.listar();
		for(Empleado e: empleado) {
			empleadoDao.borrar(e.getId());
		}
	}
}
