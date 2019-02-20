/**
 * @author stnin.stnin 
 */
package com.cadastro.fabricas;

import com.cadastro.dto.ClienteDto;

public interface FabricaDeClientesDto {
	
	default ClienteDto construirClienteDto( String nome, int idade, String endereco, String numeroTelefone, String email, String cpf, String dataNascimento, char sexo, String profissao ) {
		return new ClienteDto().setNome(nome).setIdade(idade).setEndereco(endereco).setNumeroTelefone(numeroTelefone).setEmail(email).setCpf(cpf).setDataNascimento(dataNascimento).setSexo(sexo).setProfissao(profissao);
	}

}
