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
import com.system.day.DTO.AlimentoDTO;
import com.system.day.service.AlimentoService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/alimentos")
@CrossOrigin(origins = "http://localhost:4200")
public class AlimentoController {

	@Autowired
	private AlimentoService alimentoService;
	
	@GetMapping(value = "/{id}")
	public @ResponseBody ResponseEntity<?> getById(@PathVariable Long id){
		try {
			AlimentoDTO alimentoDTO = getAlimentoService().getById(id);
			return new ResponseEntity<>(alimentoDTO, HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed Trying to find the Alimento, Please try Again latter", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping()
	public @ResponseBody ResponseEntity<?> getAll(){
		try {
			List<AlimentoDTO> alimentos = getAlimentoService().getAll();
			return new ResponseEntity<>(alimentos, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>("Failed Trying to find the Alimento, Please try Again latter", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping()
	public @ResponseBody ResponseEntity<?> post(@RequestBody AlimentoDTO alimentoDTO){
		try {
			getAlimentoService().create(alimentoDTO);
			return new ResponseEntity<>("Alimento Created Successfully " ,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed Trying to Create the Alimento, Please try Again latter" ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping()
	public @ResponseBody ResponseEntity<?> delete(@RequestParam Long id){
		try {
			getAlimentoService().delete(id);
			return new ResponseEntity<>("Alimento Deleted Successfully", HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed Trying to delete the Alimento, Please Try again latter", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping()
	public @ResponseBody ResponseEntity<?> update(@RequestBody AlimentoDTO alimentoDTO){
		try {
			getAlimentoService().update(alimentoDTO);
			return new ResponseEntity<>("Alimento Updated Succesfully", HttpStatus.OK);
		} catch(EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch(Exception e) {
			return new ResponseEntity<>("Failed Trying to update the Alimento, Please Try Again latter" ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private AlimentoService getAlimentoService() {
		return this.alimentoService;
	}
}
