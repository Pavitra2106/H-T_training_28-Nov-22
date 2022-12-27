package com.digitalBook.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	    @GetMapping("/api/v1/digitalbooks/sign/{id}")
	    public Integer authenticateUser1(@PathVariable Integer id){
	     
	        return id;
	    }

}
