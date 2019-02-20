/**
 * @author Julio de Souza Novaes 
 */



package com.cadastro.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cadastro.dto.ClienteDto;
import com.cadastro.fabricas.FabricaDeClientes;
import com.cadastro.modelo.Cliente;
import com.cadastro.repositorio.RepositorioCadastro;


@Service
public class CadastroServico {

	
	private final RepositorioCadastro repositorioCadastro;
	
	private final FabricaDeClientes fabricaDeClientes;
	
	@SuppressWarnings ("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	public CadastroServico(RepositorioCadastro repositorioCadastro,FabricaDeClientes fabricaDeClientes) {
		
		this.repositorioCadastro = repositorioCadastro;
		this.fabricaDeClientes = fabricaDeClientes;
		
		
	}
	
	
	public List<Cliente> obterClientes(){
		return repositorioCadastro.findAll();

	}

	public ResponseEntity<ClienteDto> cadastrarCliente(ClienteDto clienteDto){
		Cliente cliente = fabricaDeClientes.construirCliente(clienteDto);
		repositorioCadastro.save(cliente);
		return ResponseEntity.ok().body(clienteDto);
		
		
	}

}

