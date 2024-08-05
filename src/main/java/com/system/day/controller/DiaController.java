package com.system.day.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.system.day.DTO.DiaDTO;
import com.system.day.service.DiaService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/dias")
@CrossOrigin(origins = "http://localhost:4200")
public class DiaController {

	@Autowired
	private DiaService diaService;
	
	@GetMapping(value = "/{id}")
	public @ResponseBody ResponseEntity<?> getById(@PathVariable Long id){
		try {
			DiaDTO diaDTO = getDiaService().getById(id);
			return new ResponseEntity<>(diaDTO, HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed Trying to find the Dia, Please try Again latter", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping()
	public @ResponseBody ResponseEntity<?> getAll(){
		try {
			List<DiaDTO> dias = getDiaService().getAll();
			return new ResponseEntity<>(dias, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>("Failed Trying to find the Dia, Please try Again latter", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping()
	public @ResponseBody ResponseEntity<?> post(@RequestBody DiaDTO diaDTO){
		try {
			getDiaService().create(diaDTO);
			return new ResponseEntity<>("Dia Created Successfully " ,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed Trying to Create the Dia, Please try Again latter" ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping()
	public @ResponseBody ResponseEntity<?> delete(@RequestParam Long id){
		try {
			getDiaService().delete(id);
			return new ResponseEntity<>("Dia Deleted Successfully", HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed Trying to delete the Dia, Please Try again latter", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping()
	public @ResponseBody ResponseEntity<?> update(@RequestBody DiaDTO diaDTO){
		try {
			getDiaService().update(diaDTO);
			return new ResponseEntity<>("Dia Updated Succesfully", HttpStatus.OK);
		} catch(EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch(Exception e) {
			return new ResponseEntity<>("Failed Trying to update the Dia, Please Try Again latter" ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private DiaService getDiaService() {
		return this.diaService;
	}
}
