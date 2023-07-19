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

import com.talycap.gestion.application.services.TipoProductoService;
import com.talycap.gestion.domain.models.TipoProducto;
import com.talycap.gestion.infrastructure.exceptions.BindingResultException;
import com.talycap.gestion.infrastructure.exceptions.ErrorField;
import com.talycap.gestion.infrastructure.exceptions.ErrorFieldVerify;
import com.talycap.gestion.infrastructure.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/tiposProductos")
@CrossOrigin(origins = "*")
public class TipoProductoController {
	
	
	@Autowired
	private TipoProductoService tipoProductoService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	
	@PostMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> createTipoProducto(@RequestBody @Valid TipoProducto tipoProducto, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		TipoProducto tipoProductoResult = tipoProductoService.createTipoProducto(tipoProducto);
		
		return new ResponseEntity<TipoProducto>(tipoProductoResult, headers, HttpStatus.CREATED);
	}
	
	
	@PutMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> updateTipoProducto(@RequestBody  TipoProducto tipoProducto ){
		HttpHeaders headers = new HttpHeaders();
		verificarTipoProducto(tipoProducto);
		if(tipoProducto.getTipoProductoId() ==0) {
			throw new BindingResultException("tipoProductoId no debe ser cero");
		}
		
		TipoProducto tipoProductoResult = tipoProductoService.updateTipoProducto(tipoProducto);
		
		return new ResponseEntity<TipoProducto>(tipoProductoResult, headers, HttpStatus.OK);
	}
	
	
	@PostMapping(
			value ="/select",
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> selectTipoProducto(@RequestBody  TipoProducto tipoProducto ){
		HttpHeaders headers = new HttpHeaders();
		List<TipoProducto> tipoProductoResult = this.tipoProductoService.selectTipoProducto(tipoProducto);
		
		return new ResponseEntity<List<TipoProducto>>(tipoProductoResult, headers, HttpStatus.OK);
	}
	
	
	@DeleteMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> deleteTipoProducto(@RequestHeader(value = "body") int tipoProductoId ){
		HttpHeaders headers = new HttpHeaders();
		TipoProducto tipoProducto = new TipoProducto();
		tipoProducto.setTipoProductoId(tipoProductoId);
		verificarTipoProducto(tipoProducto);
		if(tipoProducto.getTipoProductoId() ==0) {
			throw new BindingResultException("tipoProductoId no debe ser cero");
		}
		
		Boolean tipoProductoResult = tipoProductoService.deleteTipoProducto(tipoProducto);
		
		return new ResponseEntity<Boolean>(tipoProductoResult, headers, HttpStatus.OK);
	}
	
	
	private void verificarTipoProducto(TipoProducto tipoProducto) throws ResourceNotFoundException{
		String message ="";
		List<TipoProducto> tipoProductoResult = this.tipoProductoService.selectTipoProducto(tipoProducto);
		if(tipoProductoResult.isEmpty()) {
			if(tipoProducto.getTipoProductoId()> 0 || tipoProducto.getNombreTipoProducto()!=null) {
				if(tipoProducto.getTipoProductoId() > 0) {
					message = "TipoProducto con id: "+tipoProducto.getTipoProductoId()+" no encontrado";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "TipoProducto no encontrado";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "TIPO PRODUCTO: No existen registros disponibles para mostrar";
				throw new ResourceNotFoundException(message);
			}
		}
	}
	

}
