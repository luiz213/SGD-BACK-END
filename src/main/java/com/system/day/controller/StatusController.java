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
import com.system.day.DTO.StatusDTO;
import com.system.day.service.StatusService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/status")
@CrossOrigin(origins = "http://localhost:4200")
public class StatusController {

	@Autowired
	private StatusService statusService;
	
	@GetMapping(value = "/{id}")
	public @ResponseBody ResponseEntity<?> getById(@PathVariable Long id){
		try {
			StatusDTO statusDTO = getStatusService().getById(id);
			return new ResponseEntity<>(statusDTO, HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed Trying to find the Status, Please try Again latter", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping()
	public @ResponseBody ResponseEntity<?> getAll(){
		try {
			List<StatusDTO> statuss = getStatusService().getAll();
			return new ResponseEntity<>(statuss, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>("Failed Trying to find the Status, Please try Again latter", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping()
	public @ResponseBody ResponseEntity<?> post(@RequestBody StatusDTO statusDTO){
		try {
			getStatusService().create(statusDTO);
			return new ResponseEntity<>("Status Created Successfully " ,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed Trying to Create the Status, Please try Again latter" ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping()
	public @ResponseBody ResponseEntity<?> delete(@RequestParam Long id){
		try {
			getStatusService().delete(id);
			return new ResponseEntity<>("Status Deleted Successfully", HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed Trying to delete the Status, Please Try again latter", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping()
	public @ResponseBody ResponseEntity<?> update(@RequestBody StatusDTO statusDTO){
		try {
			getStatusService().update(statusDTO);
			return new ResponseEntity<>("Status Updated Succesfully", HttpStatus.OK);
		} catch(EntityNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch(Exception e) {
			return new ResponseEntity<>("Failed Trying to update the Status, Please Try Again latter" ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private StatusService getStatusService() {
		return this.statusService;
	}
}
