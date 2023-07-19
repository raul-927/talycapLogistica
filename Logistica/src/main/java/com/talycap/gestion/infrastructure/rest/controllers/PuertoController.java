package com.talycap.gestion.infrastructure.rest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.talycap.gestion.application.services.PuertoService;
import com.talycap.gestion.domain.models.Puerto;
import com.talycap.gestion.infrastructure.exceptions.BindingResultException;
import com.talycap.gestion.infrastructure.exceptions.ErrorField;
import com.talycap.gestion.infrastructure.exceptions.ErrorFieldVerify;
import com.talycap.gestion.infrastructure.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/puertos")
@CrossOrigin(origins = "*")
public class PuertoController {
	
	@Autowired
	private PuertoService puertoService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	@PostMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> createPuerto(@RequestBody @Valid Puerto puerto, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Puerto puertoResult = puertoService.createPuerto(puerto);
		
		return new ResponseEntity<Puerto>(puertoResult, headers, HttpStatus.CREATED);
	}
	
	
	@PutMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> updatePuerto(@RequestBody Puerto puerto){
		HttpHeaders headers = new HttpHeaders();
		verificarPuerto(puerto);
		if(puerto.getPuertoId()==0) {
			throw new BindingResultException("puertoId no debe ser cero");
		}
		Puerto puertoResult = puertoService.updatePuerto(puerto);
		
		return new ResponseEntity<Puerto>(puertoResult, headers, HttpStatus.OK);
	}
	
	
	@PostMapping(
			value ="/select",
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> selectPuerto(@RequestBody Puerto puerto){
		HttpHeaders headers = new HttpHeaders();
		
		List<Puerto> puertoResult = puertoService.selectPuerto(puerto);
		
		return new ResponseEntity<List<Puerto>>(puertoResult, headers, HttpStatus.OK);
	}
	
	
	
	@DeleteMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> deletePuerto(@RequestHeader(value = "body") int puertoId){
		HttpHeaders headers = new HttpHeaders();
		Puerto puerto = new Puerto();
		puerto.setPuertoId(puertoId);
		verificarPuerto(puerto);
		if(puerto.getPuertoId()==0) {
			throw new BindingResultException("puertoId no debe ser cero");
		}
		Boolean puertoResult = puertoService.deletePuerto(puerto);
		
		return new ResponseEntity<Boolean>(puertoResult, headers, HttpStatus.OK);
	}
	
	
	
	private void verificarPuerto(Puerto puerto) throws ResourceNotFoundException{
		String message ="";
		List<Puerto> puertoResult = this.puertoService.selectPuerto(puerto);
		if(puertoResult.isEmpty()) {
			if(puerto.getPuertoId()> 0 || puerto.getDescripcion()!=null) {
				if(puerto.getPuertoId() > 0) {
					message = "Puerto con id: "+puerto.getPuertoId()+" no encontrado";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "Puerto no encontrado";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "PUERTO: No existen registros disponibles para mostrar";
				throw new ResourceNotFoundException(message);
			}
		}
	}

}
