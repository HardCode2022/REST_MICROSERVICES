/**
 * 
 */
package com.formation.microservices.web.services.RestFullwebservice.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ordinateur
 *
 */
@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource; 
	
	public HelloWorldController() {
		// TODO Auto-generated constructor stub
	}
	
    @GetMapping(path="/hello-World")
	public String helloWorld(){
		return "Bonjour Toute la france";
	}
    
    @GetMapping(path="/hello-World-Bean")
	public HelloWordBean helloWorldBean(){
    	return new HelloWordBean("Bonjour tout le monde Bean");
	}
    
    @GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWordBean helloWordBeanParameters(@PathVariable String name ){
		return new HelloWordBean(String.format(" Bonjour tout monde %s", name));
	}
    
    @GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("good.morning.message", null, 
									LocaleContextHolder.getLocale());
	}

}
