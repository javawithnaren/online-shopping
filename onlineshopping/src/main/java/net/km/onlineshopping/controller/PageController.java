package net.km.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = {"/" , "/home" , "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("Greeting", "Welcome to spring web MVC");
		return  mv;
	}
	/*@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable(value="greeting",required=false)String greeting) {
		
		if(greeting==null){
			greeting="Hello There";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("Greeting",greeting);
		return  mv;
	}*/
}
