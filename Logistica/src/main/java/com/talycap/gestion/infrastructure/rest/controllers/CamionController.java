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

import com.talycap.gestion.application.services.CamionService;
import com.talycap.gestion.domain.models.Camion;
import com.talycap.gestion.infrastructure.exceptions.BindingResultException;
import com.talycap.gestion.infrastructure.exceptions.ErrorField;
import com.talycap.gestion.infrastructure.exceptions.ErrorFieldVerify;
import com.talycap.gestion.infrastructure.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/camiones")
@CrossOrigin(origins = "*")
public class CamionController {
	
	@Autowired
	private CamionService camionService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	
	
	@PostMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> createCamion(@RequestBody @Valid Camion camion, BindingResult bindingResult){
		
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		Camion camionResult = camionService.createCamion(camion);
		
		return new ResponseEntity<Camion>(camionResult, headers, HttpStatus.CREATED);
		
	}
	
	
	@PutMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> updateCamion(@RequestBody Camion camion){
		
		HttpHeaders headers = new HttpHeaders();
		verificarCamion(camion);
		if(camion.getCamionId() == 0) {
			throw new BindingResultException("camionId no debe ser cero");
		}
		
		Camion camionResult = camionService.updateCamion(camion);
		
		return new ResponseEntity<Camion>(camionResult, headers, HttpStatus.OK);
		
	}
	
	
	@PostMapping(
			value ="/select",
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> selectCamion(@RequestBody Camion camion){
		
		HttpHeaders headers = new HttpHeaders();
		
		List<Camion> camionResult = this.camionService.selectCamion(camion);
		
		return new ResponseEntity<List<Camion>>(camionResult, headers, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> deleteCamion(@RequestHeader(value = "body") int camionId){
		HttpHeaders headers = new HttpHeaders();
		Camion camion = new Camion();
		camion.setCamionId(camionId);
		verificarCamion(camion);
		if(camion.getCamionId() == 0) {
			throw new BindingResultException("camionId no debe ser cero");
		}
		
		Boolean camionResult = camionService.deleteCamion(camion);
		
		return new ResponseEntity<Boolean>(camionResult, headers, HttpStatus.OK);
		
	}
	
	private void verificarCamion(Camion camion) throws ResourceNotFoundException{
		String message ="";
		List<Camion> camionResult = this.camionService.selectCamion(camion);
		if(camionResult.isEmpty()) {
			if(camion.getCamionId()> 0 || camion.getMarca()!=null || camion.getModelo() != null) {
				if(camion.getCamionId() > 0) {
					message = "Camion con id: "+camion.getCamionId()+" no encontrado";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "Camion no encontrado";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "CAMION: No existen registros disponibles para mostrar";
				throw new ResourceNotFoundException(message);
			}
		}
	}

}
