package com.labtwin.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.labtwin.assignment.service.FileHandleService;

/**
 * This class defines rest services for Hello Service 
 * @author Sougata Maitra
 * @version 1.0
 */

@RestController
public class HelloController {
	
	@Autowired
	FileHandleService fileHandleService;
	
	@GetMapping("/hello/{message}")
	public String hello(@PathVariable ("message") String hello) {
		return fileHandleService.helloService(hello);
	}

}
