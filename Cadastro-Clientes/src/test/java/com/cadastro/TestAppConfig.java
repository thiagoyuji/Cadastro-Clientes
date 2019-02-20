/**
 * @author Julio de Souza Novaes 
 */

package com.cadastro;

import org.springframework.context.annotation.Bean;

import com.cadastro.config.Config;
import com.cadastro.fabricas.FabricaDeClientes;

class TestAppConfig extends Config {

	@Bean
	public FabricaDeClientes fabricaDeClientes() {
		
		return new FabricaDeClientes(super.modelMapper());
		
		
	}
}
