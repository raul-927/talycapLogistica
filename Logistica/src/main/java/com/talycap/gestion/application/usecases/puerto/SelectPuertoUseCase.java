package com.talycap.gestion.application.usecases.puerto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Puerto;
import com.talycap.gestion.domain.ports.in.puerto.SelectPuertoIn;
import com.talycap.gestion.domain.ports.out.PuertoOut;

@Component
public class SelectPuertoUseCase implements SelectPuertoIn {
	
	private final PuertoOut puertoOut;
	
	
	public SelectPuertoUseCase(PuertoOut puertoOut) {
		this.puertoOut = puertoOut;
	}

	@Override
	public List<Puerto> selectPuerto(Puerto puerto) {
		
		return puertoOut.selectPuerto(puerto);
	}

}
