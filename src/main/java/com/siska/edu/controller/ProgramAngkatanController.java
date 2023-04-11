package com.siska.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siska.edu.dao.ProgramAngkatanDao;
import com.siska.edu.model.ProgramAngkatan;
import com.siska.edu.model.ProgramAngkatanId;

@RestController
@RequestMapping("/programAngkatan")
@CrossOrigin(origins = "*")
public class ProgramAngkatanController {
	
	@Autowired
	private ProgramAngkatanDao service;
	
	@GetMapping("/")
	public ResponseEntity<List<ProgramAngkatan>> getProgramAngkatan() {
		return new ResponseEntity<List<ProgramAngkatan>>(service.listAll(), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Void> saveOrUpdateCustomer(@RequestBody ProgramAngkatan program) {
		service.save(program);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteCustomer(@RequestBody ProgramAngkatanId id) {
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<ProgramAngkatan> getCustomer(@RequestBody ProgramAngkatanId id) {
		return new ResponseEntity<ProgramAngkatan>(service.get(id),HttpStatus.OK);
	}
	
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<ProgramAngkatan>> searchCustomer(@PathVariable String keyword) {
		return new ResponseEntity<List<ProgramAngkatan>>(service.search(keyword), HttpStatus.OK);
	}
	
}
