/**
 * @author Julio de Souza Novaes 
 */


package com.cadastro.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.dto.ClienteDto;
import com.cadastro.modelo.Cliente;
import com.cadastro.servicos.CadastroServico;

@RestController
public class CadastroControler {
	
	private final CadastroServico servico;
	
	@Autowired
	public CadastroControler(CadastroServico servico) {
		this.servico = servico;
	}
	
	@GetMapping(path = "/clientes/listar")
	public List<Cliente> obterCliente(){
		return servico.obterClientes();
		
	}
	
	@PostMapping(path = "/clientes/cadastro")
	public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody ClienteDto clienteDto){
		return servico.cadastrarCliente(clienteDto);
	
	}

}
