/**
 * @author stnin.stnin 
 */
package com.cadastro.fabricas;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cadastro.dto.ClienteDto;
import com.cadastro.modelo.Cliente;

@Component
public class FabricaDeClientes {

	private final ModelMapper modelMapper;
	
	@Autowired
	public FabricaDeClientes( ModelMapper modelMapper ) {
		this.modelMapper = modelMapper;
	}
	
	public Cliente construirCliente( ClienteDto clienteDto ) {
		return modelMapper.map(clienteDto, Cliente.class);
	}
	
}
