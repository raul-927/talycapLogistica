package com.talycap.gestion.application.usecases.logistica;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.talycap.gestion.domain.models.Logistica;
import com.talycap.gestion.domain.ports.in.logistica.CreateLogisticaIn;
import com.talycap.gestion.domain.ports.out.LogisticaOut;

@Component
public class CreateLogisticaUseCase implements CreateLogisticaIn {
	
	private final LogisticaOut logisticaOut;
	
	
	public CreateLogisticaUseCase(LogisticaOut logisticaOut) {
		this.logisticaOut = logisticaOut;
	}

	@Override
	public Logistica createLogistica(Logistica logistica) {
		BigDecimal precioEnvio = logistica.getPrecioEnvio();
		int cantidadProducto = logistica.getCantidadProducto();
		BigDecimal subTotal = new BigDecimal(0);
		BigDecimal total = new BigDecimal(0);
		if(logistica.getLogisticaMaritima()!=null) {
			if(logistica.getCantidadProducto() >10) {
				logistica.setPorcentajeDescuento(3.00F);
				subTotal = new BigDecimal(cantidadProducto * precioEnvio.intValue());
				total = subTotal.subtract(subTotal.multiply(new BigDecimal(3)).divide(new BigDecimal(100)));
				
			}
			else {
				logistica.setPorcentajeDescuento(0.00F);
				subTotal = new BigDecimal(cantidadProducto * precioEnvio.intValue());
				total = subTotal;
			}
			
		}else if(logistica.getLogisticaTerrestre()!=null) {
			if(logistica.getCantidadProducto() >10) {
				logistica.setPorcentajeDescuento(5.00F);
				subTotal = new BigDecimal(cantidadProducto * precioEnvio.intValue());
				total = subTotal.subtract(subTotal.multiply(new BigDecimal(5)).divide(new BigDecimal(100)));
			}else {
				logistica.setPorcentajeDescuento(0.00F);
				subTotal = new BigDecimal(cantidadProducto * precioEnvio.intValue());
				total = subTotal;
			}
			
		}
		logistica.setSubTotal(subTotal);
		logistica.setTotal(total);
		
		return logisticaOut.createLogistica(logistica);
	}

}
