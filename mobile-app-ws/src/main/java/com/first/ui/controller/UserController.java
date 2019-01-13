package com.first.ui.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.web.header.Header;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.Headers;
import com.first.users.req.UserDetailsRequest;
import com.first.users.resp.UserRest;

@RestController
@RequestMapping("users") //http://localhost:8081/users
public class UserController {
	
	@GetMapping(path="/{userId}",produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		UserRest returnValue=new UserRest();
		if(userId.equals("1001")) {
			returnValue.setFirstName("Hidayath");
			returnValue.setLastName("S");
			returnValue.setEmail("hiddu91@gmail.com");
			returnValue.setUserId(userId);
			
		}else {
			returnValue.setFirstName("Salman");
			returnValue.setLastName("S");
			returnValue.setEmail("sms9211@gmail.com");
			returnValue.setUserId(userId);
		}
		
		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
		//return new ResponseEntity<UserRest>(returnValue, "ContentType" "application/Json", HttpStatus.ok)
		
	}
	
	@GetMapping()
	public String getUsers(@RequestParam(value="page") int page,@RequestParam(value="limit") int limit) {
		return "get user was called with page="+page+" and limit="+limit ;
	}
	
	
	
	//@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	@PostMapping(produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequest userDetails) {
		
		UserRest returnValue= new UserRest();
	returnValue.setMessage("User Created successfully");
	returnValue.setUserId("1001");
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		 return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	@PutMapping
	public String updateUser() {
		return"update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}
	

}
