/**
 * @author Julio de Souza Novaes 
 */
	

package com.cadastro;


import com.cadastro.dto.ClienteDto;
import com.cadastro.fabricas.FabricaDeClientesDto;

abstract class FabricaClienteAbs implements FabricaDeClientesDto {

	
	final ClienteDto construtorClienteDTO(){
		return construirClienteDto("Cara Palida", 15, "Rua palida",
				"numeroTelefone", "cara@palida", "99999999999",
				"12/12/2006", 'm', "antropologo sem carteira");
		
	}
	
	
	
		
	
}
