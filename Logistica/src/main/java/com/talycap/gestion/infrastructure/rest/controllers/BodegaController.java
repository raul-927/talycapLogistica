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

import com.talycap.gestion.application.services.BodegaService;
import com.talycap.gestion.domain.models.Barco;
import com.talycap.gestion.domain.models.Bodega;
import com.talycap.gestion.infrastructure.exceptions.BindingResultException;
import com.talycap.gestion.infrastructure.exceptions.ErrorField;
import com.talycap.gestion.infrastructure.exceptions.ErrorFieldVerify;
import com.talycap.gestion.infrastructure.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/bodegas")
@CrossOrigin(origins = "*")
public class BodegaController {
	
	
	@Autowired
	private BodegaService bodegaService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> createBodega(@RequestBody @Valid Bodega bodega, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Bodega bodegaResult = bodegaService.createBodega(bodega);
		
		return new ResponseEntity<Bodega>(bodegaResult,headers,HttpStatus.CREATED);
	}
	
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<?> updateBodega(@RequestBody Bodega bodega){
		HttpHeaders headers = new HttpHeaders();
		verificarBodega(bodega);
		if(bodega.getBodegaId() == 0) {
			throw new BindingResultException("bodegaId no debe ser cero");
		}
		Bodega bodegaResult = bodegaService.updateBodega(bodega);
		
		return new ResponseEntity<Bodega>(bodegaResult,headers,HttpStatus.CREATED);
	}
	
	
	@PostMapping(
			value ="/select",
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> selectBodega(@RequestBody Bodega bodega){
		HttpHeaders headers = new HttpHeaders();
		List<Bodega> bodegaResult = this.bodegaService.selectBodega(bodega);
		
		return new ResponseEntity<List<Bodega>>(bodegaResult,headers,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping
	@ResponseBody
	public ResponseEntity<?> deleteBodega(@RequestHeader(value = "body") int  bodegaId){
		HttpHeaders headers = new HttpHeaders();
		Bodega bodega = new Bodega();
		bodega.setBodegaId(bodegaId);
		verificarBodega(bodega);
		if(bodega.getBodegaId() == 0) {
			throw new BindingResultException("bodegaId no debe ser cero");
		}
		Boolean bodegaResult = bodegaService.deleteBodega(bodega);
		
		return new ResponseEntity<Boolean>(bodegaResult,headers,HttpStatus.CREATED);
	}
	
	private void verificarBodega(Bodega bodega) throws ResourceNotFoundException{
		String message ="";
		List<Bodega> bodegaResult = this.bodegaService.selectBodega(bodega);
		if(bodegaResult.isEmpty()) {
			if(bodega.getBodegaId()> 0 || bodega.getNombreBodega()!=null) {
				if(bodega.getBodegaId() > 0) {
					message = "Bodega con id: "+bodega.getBodegaId()+" no encontrada";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "Bodega no encontrada";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "BODEGA: No existen registros disponibles para mostrar";
				throw new ResourceNotFoundException(message);
			}
		}
	}

}
