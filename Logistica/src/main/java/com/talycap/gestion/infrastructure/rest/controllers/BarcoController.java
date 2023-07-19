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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.talycap.gestion.application.services.BarcoService;
import com.talycap.gestion.domain.models.Barco;
import com.talycap.gestion.infrastructure.exceptions.BindingResultException;
import com.talycap.gestion.infrastructure.exceptions.ErrorField;
import com.talycap.gestion.infrastructure.exceptions.ErrorFieldVerify;
import com.talycap.gestion.infrastructure.exceptions.ResourceNotFoundException;


@RestController
@RequestMapping("/barcos")
@CrossOrigin(origins = "*")
public class BarcoController {
	
	@Autowired
	private BarcoService barcoService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	
	@PostMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> createBarco(@RequestBody @Valid Barco barco, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Barco barcoResult = this.barcoService.createBarco(barco);
		
		return new ResponseEntity<Barco>(barcoResult, headers, HttpStatus.CREATED);
		
	}
	
	@PutMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> updateBarco(@RequestBody Barco barco) throws ResourceNotFoundException{
		HttpHeaders headers = new HttpHeaders();
		verificarBarco(barco);
		if(barco.getBarcoId() == 0) {
			throw new BindingResultException("barcoId no debe ser cero");
		}
		Barco barcoResult = this.barcoService.updateBarco(barco);
		
		return new ResponseEntity<Barco>(barcoResult, headers, HttpStatus.OK);
	}
	
	@PostMapping(
			value ="/select",
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> selectBarco(@RequestBody Barco barco){
		HttpHeaders headers = new HttpHeaders();
		
		List<Barco> barcoResult = this.barcoService.selectBarco(barco);
		
		return new ResponseEntity<List<Barco>>(barcoResult, headers, HttpStatus.OK);
		
	}
	
	@DeleteMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> deleteBarco(@RequestHeader(value = "body") int barcoId) throws ResourceNotFoundException{
		HttpHeaders headers = new HttpHeaders();
		Barco barco = new Barco();
		barco.setBarcoId(barcoId);
		
		verificarBarco(barco);
		if(barco.getBarcoId() == 0) {
			throw new BindingResultException("barcoId no debe ser cero");
		}
		boolean deleteResult = this.barcoService.deleteBarco(barco);
		
		return new ResponseEntity<Boolean>(deleteResult, headers, HttpStatus.OK);
		
	}
	
	private void verificarBarco(Barco barco) throws ResourceNotFoundException{
		String message ="";
		List<Barco> barcoResult = this.barcoService.selectBarco(barco);
		if(barcoResult.isEmpty()) {
			if(barco.getBarcoId()> 0 || barco.getNombreBarco()!=null) {
				if(barco.getBarcoId() > 0) {
					message = "Barco con id: "+barco.getBarcoId()+" no encontrado";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "Barco no encontrado";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "BARCO: No existen registros disponibles para mostrar";
				throw new ResourceNotFoundException(message);
			}
		}
	}

}
