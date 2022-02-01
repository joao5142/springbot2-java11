package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.Order;
import com.example.course.services.OrderService;

@RestController
@RequestMapping(value="/orders") //define a url para acesso aos dados 
public class OrderResource {
	    @Autowired
	    private  OrderService service;
	    @GetMapping  //define que a requisição  com o method= GET vai ser para essa função
        public ResponseEntity<List<Order>> findAll(){
            List<Order> list=service.findAll();
        	
        	return ResponseEntity.ok().body(list);/*lança o status 200 e joga no corpo da resposta 
        	 o usuario já no formato json */
        }
	   
	    @GetMapping(value="/{id}")
	    public ResponseEntity<Order>findById(@PathVariable Long id){
	    	 Order obj= service.findById(id);
	    	 
	    	 return ResponseEntity.ok().body(obj);
	    	
	    }
	    
	    
	    
}
