package com.Security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/users")
	public String user() {
		return "Hello World";
	}

}
	