package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.User;
import com.example.course.services.UserService;

@RestController
@RequestMapping(value="/users") //define a url para acesso aos dados 
public class UserResource {
	    @Autowired
	    private  UserService service;
	    @GetMapping  //define que a requisição  com o method= GET vai ser para essa função
        public ResponseEntity<List<User>> findAll(){
            List<User> list=service.findAll();
        	
        	return ResponseEntity.ok().body(list);/*lança o status 200 e joga no corpo da resposta 
        	 o usuario já no formato json */
        }
	   
	    @GetMapping(value="/{id}")
	    public ResponseEntity<User>findById(@PathVariable Long id){
	    	 User obj= service.findById(id);
	    	 
	    	 return ResponseEntity.ok().body(obj);
	    	
	    }
	    
	    
	    
}
