package com.spring.info.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.info.beans.SomeBeanforStaticFilter;

@RestController
public class StaticFilterController {

	@GetMapping(path = "filter1")
	public SomeBeanforStaticFilter filterOne() {

		return new SomeBeanforStaticFilter("ramaiah", "somaiah", "chaitu");

	}

	@GetMapping(path = "filter2")
	public List<SomeBeanforStaticFilter> filterTwo() {

		return Arrays.asList(new SomeBeanforStaticFilter("ramaiah1", "somaiah1", "chaitu"),
				new SomeBeanforStaticFilter("ramaiah2", "somaiah2", "chaitu2"));
	}

}
