package com.cadastro;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.cadastro.dto.ClienteDto;
import com.cadastro.fabricas.FabricaDeClientes;
import com.cadastro.modelo.Cliente;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = TestAppConfig.class)
public class ClienteTest extends FabricaClienteAbs{

	@Autowired
	private FabricaDeClientes fabricaDeClientes;
	
	@Test
	public void doisClientesDTOIguaisTest() {
		
		
		ClienteDto A = construtorClienteDTO();
		ClienteDto B = construtorClienteDTO();
		
		Assert.assertEquals(A, B);
		Assert.assertEquals(A, A);
		Assert.assertEquals(B, B);
		Assert.assertEquals(A.hashCode(), B.hashCode());
	}
	
	@Test
	public void doisClientesIguaisTest() {
		
		
		ClienteDto ADTO = construtorClienteDTO();
		ClienteDto BDTO = construtorClienteDTO();
		
		Cliente A = fabricaDeClientes.construirCliente(ADTO);
		Cliente B = fabricaDeClientes.construirCliente(BDTO);
		
		Assert.assertEquals(A, B);
		Assert.assertEquals(A, A);
		Assert.assertEquals(B, B);
		Assert.assertEquals(A.hashCode(), B.hashCode());
	}
	
	@Test
	public void doisClientesDTODiferentesTest() {
		
		
		ClienteDto A = construtorClienteDTO();
		ClienteDto B = construirClienteDto("B", 14, "Rua Cara palida", "1612156625", "cara@palida", "999.888.777-66", "01/05/2017", 'M', "antropologo sem carteira");
		
		Assert.assertNotEquals(A, B);
		Assert.assertNotEquals(A, null);
		Assert.assertNotEquals(B, null);
		Assert.assertNotEquals(A, new Object());
		Assert.assertNotEquals(new ClienteDto(), B);

	}
	
	@Test
	public void doisClientesDiferentesTest() {
		
		
		ClienteDto ADTO = construtorClienteDTO();
		ClienteDto BDTO = construirClienteDto("B", 14, "Rua Cara palida", "1612156625", "cara@palida", "999.888.777-66", "01/05/2017", 'M', "antropologo sem carteira");
		
		Cliente A = fabricaDeClientes.construirCliente(ADTO);
		Cliente B = fabricaDeClientes.construirCliente(BDTO);
		
		Assert.assertNotEquals(A, B);
		Assert.assertNotEquals(A, null);
		Assert.assertNotEquals(B, null);
		Assert.assertNotEquals(A, new Object());
		Assert.assertNotEquals(new ClienteDto(), B);
	}
	
}
