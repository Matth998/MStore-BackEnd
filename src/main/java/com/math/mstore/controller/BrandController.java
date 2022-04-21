package com.math.mstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.math.mstore.model.BrandModel;
import com.math.mstore.repository.BrandRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandRepository repository;
	
	@GetMapping
	public ResponseEntity<List<BrandModel>>  getAll(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BrandModel> getById(@PathVariable long id){
		
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).
				orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<List<BrandModel>> getByName(@PathVariable String name){
		
		return ResponseEntity.ok(repository.findAllByDescriptionContainingIgnoreCase(name));
	}
	
	@PostMapping
	public ResponseEntity<BrandModel> post(@RequestBody BrandModel brand){
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(brand));
		
	}
	
	@PutMapping
	public ResponseEntity<BrandModel> put (@RequestBody BrandModel brand){
		
		return ResponseEntity.ok(repository.save(brand));
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		
		repository.deleteById(id);
		
	}
	
}
