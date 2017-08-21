package net.km.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultException {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "The page is ot costructed");
		mv.addObject("errorDescription", "The page you are lookig for is ot aailable");
		
		mv.addObject("title", "404 Error page");
		
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductotFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "The Product is not available!");
		mv.addObject("errorDescription", "The product you are lookig for is not available");
		
		mv.addObject("title", "Product Unavailable!");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception e){
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Contact your Administrator!!");
		
		//oly for debuggig
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		mv.addObject("errorDescription", sw.toString());
		
		mv.addObject("title", "Error");
		
		return mv;
	}
}
