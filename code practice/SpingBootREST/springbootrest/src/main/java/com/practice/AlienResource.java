package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienResource {
	@Autowired
	Aliens alien;
    AtomicInteger id = new AtomicInteger();
    
	@GetMapping("aliens")
	public Aliens getAllAliens(@RequestParam(value="name") String name) {
		alien.setId(id.incrementAndGet());
		alien.setName(name);
		alien.setPoints("70");
		
		return alien;
	}
	
	
}
