package base.web;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import base.web.utils.GeneradorEntidades;

@Controller
@RequestMapping("/bienvenido")
public class BienvenidaControlador {
	
	@Autowired
	 private GeneradorEntidades generadorEntidades;
	
	@RequestMapping(method = RequestMethod.GET)
	public String muestraMenu(Model modelo) {
		modelo.addAttribute("hoy", new Date());
		return "index";
	}
	
	
	  @PostConstruct public void prepararDatosFalsos() {
	  generadorEntidades.borrar(); generadorEntidades.generar(); }
	 

}
