package com.thigpen.routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {

	@RequestMapping("/{place}")
	public String home(@PathVariable("place") String place) {
		return "The " + place + " is awesome!";
	}
	
	@RequestMapping("/{place}-dojo")
	public String dojo(@PathVariable("place") String place) {
		return place + " Dojo is located in Southern Cali";
	}
	
	@RequestMapping("/{place1}/{place2}")
	public String dojo2(@PathVariable("place1") String place1, @PathVariable("place2") String place2) {
		return place1.substring(0, 1) + place2.substring(0, 1)+" dojo is the headquarters ";
	}
}
