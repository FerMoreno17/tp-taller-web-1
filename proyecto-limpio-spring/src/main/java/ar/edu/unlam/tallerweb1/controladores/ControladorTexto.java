package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Texto;

@Controller
public class ControladorTexto {
	@RequestMapping(value = "/cambiarTexto", method=RequestMethod.GET)
	public ModelAndView cambiarTexto(){
		ModelMap modeloTexto = new ModelMap();
		Texto texto = new Texto();
		modeloTexto.put("texto", texto);
		return new ModelAndView("cambiarTexto", modeloTexto);
	}
	
	@RequestMapping(value = "/resultado-texto", method=RequestMethod.GET)
	public ModelAndView irResultadoTexto(@RequestParam("opcion")Integer opcion, @RequestParam("txt")String txt) {
		ModelAndView mv = new ModelAndView();
        mv.addObject("valor", opcion);
        mv.addObject("original", txt);
        Texto modificado = new Texto();
        String resultado = modificado.cambiarTextoIngresado(opcion, txt);
        mv.addObject("res",resultado);
        return mv;
		//return new ModelAndView("resultado-texto");
	}
}
