package com.talycap.gestion.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talycap.gestion.domain.models.Barco;
import com.talycap.gestion.domain.ports.in.barco.CreateBarcoIn;
import com.talycap.gestion.domain.ports.in.barco.DeleteBarcoIn;
import com.talycap.gestion.domain.ports.in.barco.SelectBarcoIn;
import com.talycap.gestion.domain.ports.in.barco.UpdateBarcoIn;

@Service
public class BarcoServiceImpl implements BarcoService{
	
	
	private final CreateBarcoIn createBarcoIn;
	private final UpdateBarcoIn updateBarcoIn; 
	private final SelectBarcoIn selectBarcoIn; 
	private final DeleteBarcoIn deleteBarcoIn;
	
	
	public BarcoServiceImpl(CreateBarcoIn createBarcoIn, UpdateBarcoIn updateBarcoIn, SelectBarcoIn selectBarcoIn, DeleteBarcoIn deleteBarcoIn) {
		this.createBarcoIn = createBarcoIn;
		this.updateBarcoIn = updateBarcoIn;
		this.selectBarcoIn = selectBarcoIn;
		this.deleteBarcoIn = deleteBarcoIn;
	}

	@Override
	public Barco createBarco(Barco barco) {
		return createBarcoIn.createBarco(barco);
	}

	@Override
	public Barco updateBarco(Barco barco) {
		
		return updateBarcoIn.updateBarco(barco);
	}

	@Override
	public List<Barco> selectBarco(Barco barco) {
		
		return selectBarcoIn.selectBarco(barco);
	}

	@Override
	public boolean deleteBarco(Barco barco) {
		
		return deleteBarcoIn.deleteBarco(barco);
	}

}
