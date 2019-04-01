package base.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bienvenido")
public class BienvenidaControlador {
	
	@RequestMapping(method = RequestMethod.GET)
	public String muestraMenu(Model modelo) {
		modelo.addAttribute("hoy", new Date());
		return "index";
	}
	

}
