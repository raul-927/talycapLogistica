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

import com.talycap.gestion.application.services.ClienteService;

import com.talycap.gestion.domain.models.Cliente;
import com.talycap.gestion.infrastructure.exceptions.BindingResultException;
import com.talycap.gestion.infrastructure.exceptions.ErrorField;
import com.talycap.gestion.infrastructure.exceptions.ErrorFieldVerify;
import com.talycap.gestion.infrastructure.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
	
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ErrorFieldVerify errorFieldVerify;
	
	@PostMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> createCliente(@RequestBody @Valid Cliente cliente, BindingResult bindingResult){
		HttpHeaders headers = new HttpHeaders();
		if(bindingResult.hasErrors()) {
			List<ErrorField> fieldErrorList = errorFieldVerify.verificarCamposVacios(bindingResult.getFieldErrors());
			return new ResponseEntity<List<ErrorField>>(fieldErrorList, headers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		Cliente clienteResult = clienteService.createCliente(cliente);
		
		return new ResponseEntity<Cliente>(clienteResult, headers, HttpStatus.CREATED);
		
	}
	
	
	
	@PutMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> updateCliente(@RequestBody Cliente cliente){
		HttpHeaders headers = new HttpHeaders();
		verificarCliente(cliente);
		if(cliente.getClienteId() == 0) {
			throw new BindingResultException("clienteId no debe ser cero");
		}
		Cliente clienteResult = clienteService.updateCliente(cliente);
		
		return new ResponseEntity<Cliente>(clienteResult, headers, HttpStatus.OK);
		
	}
	
	
	@PostMapping(
			value ="/select",
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> selectCliente(@RequestBody Cliente cliente){
		HttpHeaders headers = new HttpHeaders();
		
		List<Cliente> clienteResult = clienteService.selectCliente(cliente);
		
		return new ResponseEntity<List<Cliente>>(clienteResult, headers, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping(
			consumes ={MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<?> deleteCliente(@RequestHeader(value ="body") int clienteId){
		HttpHeaders headers = new HttpHeaders();
		Cliente cliente = new Cliente();
		cliente.setClienteId(clienteId);
		verificarCliente(cliente);
		if(cliente.getClienteId() == 0) {
			throw new BindingResultException("clienteId no debe ser cero");
		}
		Boolean clienteResult = clienteService.deleteCliente(cliente);
		
		return new ResponseEntity<Boolean>(clienteResult, headers, HttpStatus.OK);
		
	}
	
	
	private void verificarCliente(Cliente cliente) throws ResourceNotFoundException{
		String message ="";
		List<Cliente> camionResult = this.clienteService.selectCliente(cliente);
		if(camionResult.isEmpty()) {
			if(cliente.getClienteId()> 0 || cliente.getNombre()!=null || cliente.getApellido()!= null || cliente.getDocumento() != null) {
				if(cliente.getClienteId() > 0) {
					message = "Cliente con id: "+cliente.getClienteId()+" no encontrado";
					throw new ResourceNotFoundException(message);
				}
				else {
					message = "Cliente no encontrado";
					throw new ResourceNotFoundException(message);
				}
			}
			else {
				message = "CLIENTE: No existen registros disponibles para mostrar";
				throw new ResourceNotFoundException(message);
			}
		}
	}
}
