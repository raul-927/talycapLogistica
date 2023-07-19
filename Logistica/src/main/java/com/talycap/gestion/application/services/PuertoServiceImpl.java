package com.talycap.gestion.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talycap.gestion.domain.models.Puerto;
import com.talycap.gestion.domain.ports.in.puerto.CreatePuertoIn;
import com.talycap.gestion.domain.ports.in.puerto.DeletePuertoIn;
import com.talycap.gestion.domain.ports.in.puerto.SelectPuertoIn;
import com.talycap.gestion.domain.ports.in.puerto.UpdatePuertoIn;

@Service
public class PuertoServiceImpl implements PuertoService {
	
	private final CreatePuertoIn createPuertoIn; 
	private final UpdatePuertoIn updatePuertoIn; 
	private final SelectPuertoIn selectPuertoIn; 
	private final DeletePuertoIn deletePuertoIn;
	
	
	public PuertoServiceImpl(CreatePuertoIn createPuertoIn, UpdatePuertoIn updatePuertoIn,
			SelectPuertoIn selectPuertoIn, DeletePuertoIn deletePuertoIn) {
		this.createPuertoIn = createPuertoIn;
		this.updatePuertoIn = updatePuertoIn;
		this.selectPuertoIn = selectPuertoIn;
		this.deletePuertoIn = deletePuertoIn;
	}

	@Override
	public Puerto createPuerto(Puerto puerto) {
		
		return createPuertoIn.createPuerto(puerto);
	}

	@Override
	public Puerto updatePuerto(Puerto puerto) {
		
		return updatePuertoIn.updatePuerto(puerto);
	}

	@Override
	public List<Puerto> selectPuerto(Puerto puerto) {
		
		return selectPuertoIn.selectPuerto(puerto);
	}

	@Override
	public boolean deletePuerto(Puerto puerto) {
		
		return deletePuertoIn.deletePuerto(puerto);
	}

}
