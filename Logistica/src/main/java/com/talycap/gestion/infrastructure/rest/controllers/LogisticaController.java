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

import com.talycap.gestion.application.services.LogisticaService;
import com.talycap.gestion.domain.models.Logistica;
import com.talycap.gestion.infrastructure.exceptions.BindingResultException;
import com.talycap.gestion.infrastructure.exceptions.ErrorField;
import com.talycap.gestion.infrastructure.exceptions.ErrorFieldVerify;
import com.talycap.gestion.infrastructure.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/logisticas")
@CrossOrigin(origins = "*")
public class LogisticaController {
	
	
	@Autowired
	private LogisticaService logisticaService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	
	
	@PostMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> createLogistica(@RequestBody @Valid Logistica logistica, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		Logistica logisticaResult = logisticaService.createLogistica(logistica);
		
		return new ResponseEntity<Logistica>(logisticaResult, headers, HttpStatus.CREATED);
	}
	
	
	@PutMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> updateLogistica(@RequestBody Logistica logistica){
		HttpHeaders headers = new HttpHeaders();
		
		verificarLogistica(logistica);
		if(logistica.getLogisticaId() ==0) {
			throw new BindingResultException("logisticaId no debe ser cero");
		}
		Logistica logisticaResult = logisticaService.updateLogistica(logistica);
		
		return new ResponseEntity<Logistica>(logisticaResult, headers, HttpStatus.OK);
	}
	
	
	@PostMapping(
			value ="/select",
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> selectLogistica(@RequestBody Logistica logistica){
		HttpHeaders headers = new HttpHeaders();
		
		List<Logistica> logisticaResult = logisticaService.selectLogistica(logistica);
		
		return new ResponseEntity<List<Logistica>>(logisticaResult, headers, HttpStatus.OK);
	}
	
	
	@DeleteMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> deleteLogistica(@RequestHeader(value = "body") int logisticaId){
		HttpHeaders headers = new HttpHeaders();
		Logistica logistica = new Logistica();
		logistica.setLogisticaId(logisticaId);
		verificarLogistica(logistica);
		if(logistica.getLogisticaId() ==0) {
			throw new BindingResultException("logisticaId no debe ser cero");
		}
		Boolean logisticaResult = logisticaService.deleteLogistica(logistica);
		
		return new ResponseEntity<Boolean>(logisticaResult, headers, HttpStatus.OK);
	}
	
	
	private void verificarLogistica(Logistica logistica) throws ResourceNotFoundException{
		String message ="";
		List<Logistica> logisticaResult = this.logisticaService.selectLogistica(logistica);
		if(logisticaResult.isEmpty()) {
			if(logistica.getLogisticaId()> 0 || logistica.getTipoProducto()!=null) {
				if(logistica.getLogisticaId() > 0) {
					message = "Logistica con id: "+logistica.getLogisticaId()+" no encontrada";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "Puerto no encontrado";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "LOGISTICA: No existen registros disponibles para mostrar";
				throw new ResourceNotFoundException(message);
			}
		}
	}

}
