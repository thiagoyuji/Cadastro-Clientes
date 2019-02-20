package com.cadastro;

import java.util.List;
import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cadastro.dto.ClienteDto;
import com.cadastro.excessoes.Violacoes;
import com.cadastro.protocolos.Protocolo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CadastroClientesApplicationTests extends FabricaClienteAbs {

	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void cadastroEValidacaoDeClienteTest() {
		
		ClienteDto clienteEnviadoParaCadastro = construtorClienteDTO();
		
		ResponseEntity<ClienteDto> clienteCadastro = restTemplate.postForEntity(construtorURLCadastro(), clienteEnviadoParaCadastro, ClienteDto.class);
	
		Assert.assertEquals("Status precisa ser Ok", HttpStatus.OK, clienteCadastro.getStatusCode());
		
		Assert.assertEquals("espero o cliente cadastrado", clienteEnviadoParaCadastro, clienteCadastro.getBody());
		
		ResponseEntity<ClienteDto[]> clienteObter = restTemplate.getForEntity(construtorURLObterClientes(), ClienteDto[].class);
		
		Assert.assertEquals("Status precisa ser Ok", HttpStatus.OK, clienteObter.getStatusCode());
	
		Assert.assertEquals("Deve ter apenas um cliente cadastrado", 1L, Objects.requireNonNull(clienteObter.getBody()).length);
		
		Assert.assertEquals("espero o cliente cadastrado", clienteEnviadoParaCadastro, clienteObter.getBody()[0]);
	
	}
	
	@Test 
	public void cadastrarClienteComNomeVazio() {
		
		ClienteDto clinteEviadoParaCadastro = new ClienteDto();
		clinteEviadoParaCadastro.setNome("").setIdade(18).setEndereco("Rua cara palida").setNumeroTelefone("999999999").setEmail("cara@palida").setCpf("999.888.777-66").setDataNascimento("01/05/2017").setSexo('M').setProfissao("antropolog sem carteira");
		
		ResponseEntity<Violacoes> violacoes = restTemplate.postForEntity(construtorURLCadastro(), clinteEviadoParaCadastro, Violacoes.class);
		
		Assert.assertEquals("Status precisa ser BAD_REQUEST", HttpStatus.BAD_REQUEST, violacoes.getStatusCode());
		
		List<Protocolo> protocolos = Objects.requireNonNull(violacoes.getBody()).getProtocolos();

		Assert.assertEquals("Deve ter protocolos retornados", 1L, protocolos.size());

		//Assert.assertEquals(Protocolo.NOME_NAO_PODE_SER_VAZIO, protocolos.get(0));
		
	}
	
	@Test 
	public void cadastrarClienteComEnderecoVazio() {
		
		ClienteDto clinteEviadoParaCadastro = new ClienteDto();
		clinteEviadoParaCadastro.setNome("cara palida").setIdade(18).setEndereco("").setNumeroTelefone("999999999").setEmail("cara@palida").setCpf("999.888.777-66").setDataNascimento("01/05/2017").setSexo('M').setProfissao("antropolog sem carteira");
		
		ResponseEntity<Violacoes> violacoes = restTemplate.postForEntity(construtorURLCadastro(), clinteEviadoParaCadastro, Violacoes.class);
		
		Assert.assertEquals("Status precisa ser BAD_REQUEST", HttpStatus.BAD_REQUEST, violacoes.getStatusCode());
		
		List<Protocolo> protocolos = Objects.requireNonNull(violacoes.getBody()).getProtocolos();
		
		Assert.assertEquals("Deve ter protocolos retornados", 1L, protocolos.size());
		
		System.out.println("\n\n\n\n\n\n" + protocolos.size() + " : " + protocolos + "\n\n\n\n\n\n");
		
		//Assert.assertEquals(Protocolo.ENDERECO_NAO_PODE_SER_VAZIO, protocolos.get(0));
		
	}
	
	@Test 
	public void cadastrarClienteComTelefoneVazio() {
		
		ClienteDto clinteEviadoParaCadastro = new ClienteDto();
		clinteEviadoParaCadastro.setNome("cara palida").setIdade(18).setEndereco("Rua cara palida").setNumeroTelefone("").setEmail("cara@palida").setCpf("999.888.777-66").setDataNascimento("01/05/2017").setSexo('M').setProfissao("antropolog sem carteira");
		
		ResponseEntity<Violacoes> violacoes = restTemplate.postForEntity(construtorURLCadastro(), clinteEviadoParaCadastro, Violacoes.class);
		
		Assert.assertEquals("Status precisa ser BAD_REQUEST", HttpStatus.BAD_REQUEST, violacoes.getStatusCode());
		
		List<Protocolo> protocolos = Objects.requireNonNull(violacoes.getBody()).getProtocolos();
		
		Assert.assertEquals("Deve ter protocolos retornados", 1L, protocolos.size());
		
		//Assert.assertEquals(Protocolo.NUMERO_DE_TELEFONE_NAO_PODE_SER_VAZIO, protocolos.get(0));
		
	}
	
	@Test 
	public void cadastrarClienteComEmailVazio() {
		
		ClienteDto clinteEviadoParaCadastro = new ClienteDto();
		clinteEviadoParaCadastro.setNome("cara palida").setIdade(18).setEndereco("Rua cara palida").setNumeroTelefone("9999999999").setEmail("").setCpf("999.888.777-66").setDataNascimento("01/05/2017").setSexo('M').setProfissao("antropolog sem carteira");
		
		ResponseEntity<Violacoes> violacoes = restTemplate.postForEntity(construtorURLCadastro(), clinteEviadoParaCadastro, Violacoes.class);
		
		Assert.assertEquals("Status precisa ser BAD_REQUEST", HttpStatus.BAD_REQUEST, violacoes.getStatusCode());
		
		List<Protocolo> protocolos = Objects.requireNonNull(violacoes.getBody()).getProtocolos();
		
		Assert.assertEquals("Deve ter protocolos retornados", 2L, protocolos.size());
		
		//Assert.assertEquals(Protocolo.EMAIL_NAO_PODE_SER_VAZIO, protocolos.get(1));	
		//Assert.assertEquals(Protocolo.EMAIL_NAO_VALIDO, protocolos.get(0));	
		
	}
	
	@Test 
	public void cadastrarClienteComEmailInvalido() {
		
		ClienteDto clinteEviadoParaCadastro = new ClienteDto();
		clinteEviadoParaCadastro.setNome("cara palida").setIdade(18).setEndereco("Rua cara palida").setNumeroTelefone("9999999999").setEmail("dsffgsdfg56456rtfgx").setCpf("999.888.777-66").setDataNascimento("01/05/2017").setSexo('M').setProfissao("antropolog sem carteira");
		
		ResponseEntity<Violacoes> violacoes = restTemplate.postForEntity(construtorURLCadastro(), clinteEviadoParaCadastro, Violacoes.class);
		
		Assert.assertEquals("Status precisa ser BAD_REQUEST", HttpStatus.BAD_REQUEST, violacoes.getStatusCode());
		
		List<Protocolo> protocolos = Objects.requireNonNull(violacoes.getBody()).getProtocolos();
		
		Assert.assertEquals("Deve ter protocolos retornados", 1L, protocolos.size());
		
		//Assert.assertEquals(Protocolo.EMAIL_NAO_VALIDO, protocolos.get(0));	
		
	}
	
	@Test 
	public void cadastrarClienteComCpfVazio() {
		
		ClienteDto clinteEviadoParaCadastro = new ClienteDto();
		clinteEviadoParaCadastro.setNome("cara palida").setIdade(18).setEndereco("Rua cara palida").setNumeroTelefone("9999999999").setEmail("cara@palida").setCpf("").setDataNascimento("01/05/2017").setSexo('M').setProfissao("antropolog sem carteira");
		
		ResponseEntity<Violacoes> violacoes = restTemplate.postForEntity(construtorURLCadastro(), clinteEviadoParaCadastro, Violacoes.class);
		
		Assert.assertEquals("Status precisa ser BAD_REQUEST", HttpStatus.BAD_REQUEST, violacoes.getStatusCode());
		
		List<Protocolo> protocolos = Objects.requireNonNull(violacoes.getBody()).getProtocolos();
		
		Assert.assertEquals("Deve ter protocolos retornados", 2L, protocolos.size());

		//Assert.assertEquals(Protocolo.CPF_NAO_PODE_SER_VAZIO, protocolos.get(1));
		//Assert.assertEquals(Protocolo.CPF_NAO_VALIDO, protocolos.get(0));
		
	}
	
	@Test 
	public void cadastrarClienteComCpfInvalido() {
		
		ClienteDto clinteEviadoParaCadastro = new ClienteDto();
		clinteEviadoParaCadastro.setNome("cara palida").setIdade(18).setEndereco("Rua cara palida").setNumeroTelefone("9999999999").setEmail("cara@palida").setCpf("999.999.999-99345345345").setDataNascimento("01/05/2017").setSexo('M').setProfissao("antropolog sem carteira");
		
		ResponseEntity<Violacoes> violacoes = restTemplate.postForEntity(construtorURLCadastro(), clinteEviadoParaCadastro, Violacoes.class);
		
		Assert.assertEquals("Status precisa ser BAD_REQUEST", HttpStatus.BAD_REQUEST, violacoes.getStatusCode());
		
		List<Protocolo> protocolos = Objects.requireNonNull(violacoes.getBody()).getProtocolos();
		
		Assert.assertEquals("Deve ter protocolos retornados", 1L, protocolos.size());

		//Assert.assertEquals(Protocolo.CPF_NAO_VALIDO, protocolos.get(0));
		
	}
	
	@Test 
	public void cadastrarClienteComDataNascimentoVazio() {
		
		ClienteDto clinteEviadoParaCadastro = new ClienteDto();
		clinteEviadoParaCadastro.setNome("cara palida").setIdade(18).setEndereco("Rua cara palida").setNumeroTelefone("9999999999").setEmail("cara@palida").setCpf("888.777.666-55").setDataNascimento("").setSexo('M').setProfissao("antropolog sem carteira");
		
		ResponseEntity<Violacoes> violacoes = restTemplate.postForEntity(construtorURLCadastro(), clinteEviadoParaCadastro, Violacoes.class);
		
		Assert.assertEquals("Status precisa ser BAD_REQUEST", HttpStatus.BAD_REQUEST, violacoes.getStatusCode());
		
		List<Protocolo> protocolos = Objects.requireNonNull(violacoes.getBody()).getProtocolos();
		
		Assert.assertEquals("Deve ter protocolos retornados", 2L, protocolos.size());
		
		//Assert.assertEquals(Protocolo.DATA_DE_NASCIMENTO_NAO_PODE_SER_VAZIO, protocolos.get(1));
		//Assert.assertEquals(Protocolo.DATA_DE_NASCIMENTO_NAO_VALIDO, protocolos.get(0));
		
	}
	
	@Test 
	public void cadastrarClienteComDataNascimentoInvalido() {
		
		ClienteDto clinteEviadoParaCadastro = new ClienteDto();
		clinteEviadoParaCadastro.setNome("cara palida").setIdade(18).setEndereco("Rua cara palida").setNumeroTelefone("9999999999").setEmail("cara@palida").setCpf("888.777.666-55").setDataNascimento("12:45:67").setSexo('M').setProfissao("antropolog sem carteira");
		
		ResponseEntity<Violacoes> violacoes = restTemplate.postForEntity(construtorURLCadastro(), clinteEviadoParaCadastro, Violacoes.class);
		
		Assert.assertEquals("Status precisa ser BAD_REQUEST", HttpStatus.BAD_REQUEST, violacoes.getStatusCode());
		
		List<Protocolo> protocolos = Objects.requireNonNull(violacoes.getBody()).getProtocolos();
		
		Assert.assertEquals("Deve ter protocolos retornados", 1L, protocolos.size());
		
		//Assert.assertEquals(Protocolo.DATA_DE_NASCIMENTO_NAO_VALIDO, protocolos.get(0));
		
	}
	
	@Test 
	public void cadastrarClienteComProfissaoVazio() {
		
		ClienteDto clinteEviadoParaCadastro = new ClienteDto();
		clinteEviadoParaCadastro.setNome("cara palida").setIdade(18).setEndereco("Rua cara palida").setNumeroTelefone("9999999999").setEmail("cara@palida").setCpf("888.777.666-55").setDataNascimento("01/05/2017").setSexo('M').setProfissao("");
		
		ResponseEntity<Violacoes> violacoes = restTemplate.postForEntity(construtorURLCadastro(), clinteEviadoParaCadastro, Violacoes.class);
		
		Assert.assertEquals("Status precisa ser BAD_REQUEST", HttpStatus.BAD_REQUEST, violacoes.getStatusCode());
		
		List<Protocolo> protocolos = Objects.requireNonNull(violacoes.getBody()).getProtocolos();
		
		Assert.assertEquals("Deve ter protocolos retornados", 1L, protocolos.size());
		
		//Assert.assertEquals(Protocolo.PROFISSAO_NAO_PODE_SER_VAZIO, protocolos.get(0));
		
	}

	private String construtorURLCadastro() {
		return construtorURL() + "/clientes/cadastro";
	}

	
	private String construtorURLObterClientes() {
		return construtorURL() + "/clientes/listar";
	}


	private String construtorURL() {
		return "http://localhost:" + port;
	}
}

