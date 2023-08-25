package com.day4_portal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.day4_portal.model.Student;
import com.day4_portal.service.ApiService;



@RestController
@RequestMapping("/api/v1/day4")
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	@PostMapping("/addUser")
	public ResponseEntity<String>addUser(@RequestBody Student student){
		boolean dataSaved= apiService.adduser(student);
		if(dataSaved) {
			return ResponseEntity.status(200).body("Student added successfully");
		}
		else {
			return ResponseEntity.status(404).body("Something went wrong");
		}
		
	}

	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<String>updateuser(@PathVariable Long id,@RequestBody Student student){
	boolean userData=apiService.updateuser(id,student);
	if(userData) {
		return ResponseEntity.status(200).body("Student data updated successfully");
		
	}else {
		return ResponseEntity.status(404).body("No record");
	}

}
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String>deleteUser(@PathVariable Long id){
		boolean userDeleted=apiService.deleteUser(id);
		if(userDeleted) {
			return ResponseEntity.status(200).body("Student data deleted successfully");
		}
		else {
			return ResponseEntity.status(404).body("No records");
		}
	}
}