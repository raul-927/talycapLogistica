package com.talycap.gestion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.talycap.gestion.domain.models.Camion;
import com.talycap.gestion.infrastructure.adapters.CamionAdapter;
import com.talycap.gestion.infrastructure.repository.mybatis.mappers.CamionMapper;
import com.talycap.gestion.infrastructure.rest.mappers.CamionEntityMapper;
import com.talycap.gestion.domain.ports.out.CamionOut;
import com.talycap.gestion.application.usecases.camion.CreateCamionUseCase;
import com.talycap.gestion.domain.ports.in.camion.CreateCamionIn;
import com.talycap.gestion.infrastructure.exceptions.ErrorField;
import com.talycap.gestion.infrastructure.exceptions.ResourceNotFoundException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import javax.validation.constraints.Pattern;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CreateCamionUseCaseTest {
	
	private static final String MARCA_CAMION = "JAC";
	private static final String MODELO_CAMION = "2023";
	private static final String PLACA_CORRECTA = "ABC123";
	private static final String PLACA_NUMERO_CARACTER = "123ABC";
	
	private static final String MENSAJE_PLACA_INVALIDA = "Placa inválida";
	
	
	@Mock
	private CamionMapper camionMapper;
	
	@Autowired
	private CamionEntityMapper camionEntityMapper;
	
	
	@Test
	public void createCamionPlacaCorrecta() {
		RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
			Camion camion = new Camion();
			camion.setMarca(MARCA_CAMION);
			camion.setModelo(MODELO_CAMION);
			camion.setPlaca(PLACA_NUMERO_CARACTER);
			CamionOut cOut = new CamionAdapter(camionMapper, camionEntityMapper);
			CreateCamionIn createCamion = new CreateCamionUseCase(cOut);
			Camion camionResult = createCamion.createCamion(camion);
		    assertNotNull(createCamion);
		    //assertEquals(PLACA_NUMERO_CARACTER, camionResult.getPlaca());
		});
		 Assertions.assertEquals(MENSAJE_PLACA_INVALIDA, thrown.getMessage());
		
	}

}
