package com.spring.info.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.spring.info.beans.HelloWorldBean;

@RestController
public class HelloWorldController {
    @Autowired
	private MessageSource messageSource;

	/**
	 * its regarding returing Bean class note: here we can
	 * use @ReqestMapping(Mehthod =RequestMethod.GET,path = "/helloWorld") also
	 * 
	 * @return
	 */

	@GetMapping(path = "/helloWorld")
	public HelloWorldBean beanReturn() {
		return new HelloWorldBean("Hello , here we are retuning bean object");

	}

	// its regarding @PathVarible Which we can give values from URI;
	@GetMapping("/helloWorld/path/{name}")
	public HelloWorldBean pathVaribleInfo(@PathVariable String name) {
		return new HelloWorldBean("pathVArible  : " + String.format("value would be, %s", name));
	}

	@GetMapping(path = "/internalizationCheck")
	public String internalizationExample(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.messeges", null, locale);

	}

}
