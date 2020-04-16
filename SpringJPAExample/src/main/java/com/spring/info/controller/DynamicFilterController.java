package com.spring.info.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.info.beans.DynamicFilterBean;

@RestController
public class DynamicFilterController {
	
	@GetMapping(path ="/dynamicFilter")
	public MappingJacksonValue getDynamicInfo() {
		DynamicFilterBean filterBean = new DynamicFilterBean("Somaiah", "Ramaiah", "chaitu", "Amma");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filed1","filed2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("mappingToController",filter);
		MappingJacksonValue mapping = new MappingJacksonValue(filterBean);
		mapping.setFilters(filters);
		return mapping;
	}

}
