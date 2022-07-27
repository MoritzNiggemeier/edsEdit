package com.encoway.edsedit.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartPageController {

    @RequestMapping( value = "/", method = RequestMethod.GET )
	public ResponseEntity<String> startPageController(){

    	HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "http://localhost:8088/");
		return new ResponseEntity<String>( headers, HttpStatus.FOUND );

    }

}