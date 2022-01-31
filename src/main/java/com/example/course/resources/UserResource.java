package com.example.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.User;

@RestController
@RequestMapping(value="/users") //define a url para acesso aos dados 
public class UserResource {
	    
	    @GetMapping  //define que a requisição  com o method= GET vai ser para essa função
        public ResponseEntity<User> findAll(){
        	User u = new User(1L, "maria", "maria@gmail.com", "98987978", "1234");
        	
        	return ResponseEntity.ok().body(u);/*lança o status 200 e joga no corpo da resposta 
        	 o usuario já no formato json */
        }
}
