package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Texto;

@Controller
public class ControladorTexto {
	/*@RequestMapping(value = "/cambiarTexto", method=RequestMethod.GET)
	public ModelAndView cambiarTexto(){
		ModelMap modeloTexto = new ModelMap();
		Texto texto = new Texto();
		modeloTexto.put("texto", texto);
		return new ModelAndView("cambiarTexto", modeloTexto);
	}
	
	@RequestMapping("/cambiarTexto")
	public ModelAndView formulario(@ModelAttribute("texto") Texto texto){
		return new ModelAndView();
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
	}*/
	
	@RequestMapping(path="resultado-texto/{opcion}/{txt}", method = RequestMethod.GET)
	public ModelAndView resultado(@PathVariable("opcion") Integer opcion, @PathVariable("txt") String txt) {
		ModelMap modelo = new ModelMap();
		Integer op  = opcion;
		String recibido = txt;
		String resultado = null;
			switch(op) {
			case 1: resultado= recibido.toUpperCase();
			break;
			case 2: resultado = recibido.toLowerCase();
			break;
			case 3: for (int x=recibido.length()-1;x>=0;x--)resultado = resultado + recibido.charAt(x);
			break;
			case 4: resultado = Integer.toString(recibido.length());
			break;
			default:resultado = "error";
			}
		modelo.put("valor", opcion);
		modelo.put("original", recibido);
		modelo.put("res", resultado);
		return new ModelAndView ("resultado-texto",modelo);
	}
}