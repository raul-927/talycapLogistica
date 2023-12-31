package com.talycap.gestion;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.math.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.talycap.gestion.application.usecases.logistica.CreateLogisticaUseCase;
import com.talycap.gestion.domain.ports.in.logistica.CreateLogisticaIn;
import com.talycap.gestion.domain.ports.out.LogisticaOut;
import com.talycap.gestion.infrastructure.adapters.LogisticaAdapter;
import com.talycap.gestion.domain.models.Logistica;
import com.talycap.gestion.domain.models.LogisticaMaritima;
import com.talycap.gestion.domain.models.LogisticaTerrestre;
import com.talycap.gestion.infrastructure.rest.mappers.LogisticaEntityMapper;
import com.talycap.gestion.infrastructure.repository.mybatis.mappers.LogisticaMapper;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CreateLogisticaUseCaseTest {
	private final int CANTIDAD_MENOR_DE_10 = 9;
	private final int CANTIDAD_IGUAL_A_10 = 10;
	private final int CANTIDAD_MAYOR_A_10 = 11;
	
	@Mock
	private LogisticaMapper logisticaMapper;
	
	@Autowired
	private LogisticaEntityMapper logisticaEntityMapper;
	
	private final BigDecimal PRECIO_ENVIO = new BigDecimal(8000);
	
	@Test
	void createLogisticaMaritimaMenorDe10() {
		LogisticaOut lOut = new LogisticaAdapter(logisticaMapper, logisticaEntityMapper);
		LogisticaMaritima lMaritima = new LogisticaMaritima();
		LogisticaTerrestre lTerrestre = new LogisticaTerrestre();
		lMaritima.setLogisticaMaritimaId(1);
		lTerrestre.setLogisticaTerrestreId(1);
		Logistica logistica = new Logistica();
		logistica.setLogisticaMaritima(lMaritima);
		logistica.setCantidadProducto(CANTIDAD_MENOR_DE_10);
		logistica.setPrecioEnvio(PRECIO_ENVIO);
		CreateLogisticaIn createLogistica = new CreateLogisticaUseCase(lOut);
		Logistica logisticaResult = createLogistica.createLogistica(logistica);
		assertEquals( new BigDecimal(72000), logisticaResult.getTotal() );
		
		
	}
	
	@Test
	void createLogisticaMaritimaIgual10() {
		LogisticaOut lOut = new LogisticaAdapter(logisticaMapper, logisticaEntityMapper);
		LogisticaMaritima lMaritima = new LogisticaMaritima();
		LogisticaTerrestre lTerrestre = new LogisticaTerrestre();
		lMaritima.setLogisticaMaritimaId(1);
		lTerrestre.setLogisticaTerrestreId(1);
		Logistica logistica = new Logistica();
		logistica.setLogisticaMaritima(lMaritima);
		logistica.setCantidadProducto(CANTIDAD_IGUAL_A_10);
		logistica.setPrecioEnvio(PRECIO_ENVIO);
		CreateLogisticaIn createLogistica = new CreateLogisticaUseCase(lOut);
		Logistica logisticaResult = createLogistica.createLogistica(logistica);
		assertEquals( new BigDecimal(80000), logisticaResult.getTotal() );
		
		
	}
	
	@Test
	void createLogisticaMaritimaMayor10() {
		LogisticaOut lOut = new LogisticaAdapter(logisticaMapper, logisticaEntityMapper);
		LogisticaMaritima lMaritima = new LogisticaMaritima();
		LogisticaTerrestre lTerrestre = new LogisticaTerrestre();
		lMaritima.setLogisticaMaritimaId(1);
		lTerrestre.setLogisticaTerrestreId(1);
		Logistica logistica = new Logistica();
		logistica.setLogisticaMaritima(lMaritima);
		logistica.setCantidadProducto(CANTIDAD_MAYOR_A_10);
		logistica.setPrecioEnvio(PRECIO_ENVIO);
		CreateLogisticaIn createLogistica = new CreateLogisticaUseCase(lOut);
		Logistica logisticaResult = createLogistica.createLogistica(logistica);
		assertEquals( new BigDecimal(85360), logisticaResult.getTotal() );
		
		
	}
	
	
	
	@Test
	void createLogisticaTerrestreMenorDe10() {
		LogisticaOut lOut = new LogisticaAdapter(logisticaMapper, logisticaEntityMapper);
		LogisticaTerrestre lTerrestre = new LogisticaTerrestre();
		lTerrestre.setLogisticaTerrestreId(1);
		Logistica logistica = new Logistica();
		logistica.setLogisticaTerrestre(lTerrestre);
		logistica.setCantidadProducto(CANTIDAD_MENOR_DE_10);
		logistica.setPrecioEnvio(PRECIO_ENVIO);
		CreateLogisticaIn createLogistica = new CreateLogisticaUseCase(lOut);
		Logistica logisticaResult = createLogistica.createLogistica(logistica);
		assertEquals( new BigDecimal(72000), logisticaResult.getTotal() );
		
		
	}
	
	@Test
	void createLogisticaTerrestreIgual10() {
		LogisticaOut lOut = new LogisticaAdapter(logisticaMapper, logisticaEntityMapper);
		LogisticaTerrestre lTerrestre = new LogisticaTerrestre();
		lTerrestre.setLogisticaTerrestreId(1);
		Logistica logistica = new Logistica();
		logistica.setLogisticaTerrestre(lTerrestre);
		logistica.setCantidadProducto(CANTIDAD_IGUAL_A_10);
		logistica.setPrecioEnvio(PRECIO_ENVIO);
		CreateLogisticaIn createLogistica = new CreateLogisticaUseCase(lOut);
		Logistica logisticaResult = createLogistica.createLogistica(logistica);
		assertEquals( new BigDecimal(80000), logisticaResult.getTotal() );
		
		
	}
	
	@Test
	void createLogisticaTerrestreMayor10() {
		LogisticaOut lOut = new LogisticaAdapter(logisticaMapper, logisticaEntityMapper);
		
		LogisticaTerrestre lTerrestre = new LogisticaTerrestre();
		lTerrestre.setLogisticaTerrestreId(1);
		Logistica logistica = new Logistica();
		logistica.setLogisticaTerrestre(lTerrestre);
		logistica.setCantidadProducto(CANTIDAD_MAYOR_A_10);
		logistica.setPrecioEnvio(PRECIO_ENVIO);
		CreateLogisticaIn createLogistica = new CreateLogisticaUseCase(lOut);
		Logistica logisticaResult = createLogistica.createLogistica(logistica);
		assertEquals( new BigDecimal(83600), logisticaResult.getTotal() );
		
		
	}
	

}
