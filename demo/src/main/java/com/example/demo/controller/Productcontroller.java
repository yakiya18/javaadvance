package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Productentity;
import com.example.demo.repository.Productrepo1;

@RestController
public class Productcontroller {
	
@Autowired
public Productrepo1 repo;
	
	@PutMapping("/updateproduct")
	public String updateproduct(@RequestBody Productentity pro) {
		try {
			repo.save(pro);
			return "product added successfully";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/getproduct")
	public List<Productentity>getproduct() {
		try {
			return repo.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DeleteMapping("/deleteproduct/{id}")
	public String deleteproduct(@PathVariable int id ) {
		try {
			Productentity pro = repo.getOne(id);
			repo.delete(pro);
			return "product deleted successfully";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
