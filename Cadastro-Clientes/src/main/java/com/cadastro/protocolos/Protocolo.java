/**
 * @author stnin.stnin
 */
package com.cadastro.protocolos;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Protocolo implements Serializable {
	
	NOME_NAO_PODE_SER_VAZIO(58300, "CAMPO NOME NAO PODE SER VAZIO"),
	IDADE_NAO_PODE_SER_NULO(58400, "CAMPO IDADE NAO PODE SER VAZIO"),
	ENDERECO_NAO_PODE_SER_VAZIO(58500, "CAMPO ENDERECO NAO PODE SER VAZIO"),
	NUMERO_DE_TELEFONE_NAO_PODE_SER_VAZIO(58600, "CAMPO TELEFONE NAO PODE SER VAZIO"),
	EMAIL_NAO_PODE_SER_VAZIO(58700, "CAMPO EMAIL NAO PODE SER VAZIO"),
	CPF_NAO_PODE_SER_VAZIO(58800, "CAMPO CPF NAO PODE SER VAZIO"),
	DATA_DE_NASCIMENTO_NAO_PODE_SER_VAZIO(58900, "CAMPO DATA DE NASCIMENTO NAO PODE SER VAZIO"),
	SEXO_NAO_PODE_SER_VAZIO(59000, "CAMPO SEXO NAO PODE SER VAZIO"),
	PROFISSAO_NAO_PODE_SER_VAZIO(59100, "CAMPO PROFISSOES NAO PODE SER VAZIO"),
	VIOLACAO_DE_VALOR(59200, "CAMPO VIOLACAO DE VALOR"),
	
	CPF_NAO_VALIDO(60300, "CAMPO CPF INVALIDO"),
	DATA_DE_NASCIMENTO_NAO_VALIDO(60400, "CAMPO DATA DE NASCIMENTO INVALIDO"),
	EMAIL_NAO_VALIDO(60500, "CAMPO EMAIL INVALIDO");
	
	
	private static final String MENSAGEM_CONSTANTE = "mensagem";
	private static final String STATUS_CONSTANTE = "status";
	
	private final int status;
	private final String mensagem;
	
	Protocolo( int status, String mensagem ){
		this.status = status;
		this.mensagem = mensagem;
	}
	
	@JsonProperty
	public int getStatus() {
		return status;
	}
	
	@JsonProperty
	public String getMessage() {
		return mensagem;
	}
	
	@JsonCreator
	public static Protocolo fromNode(JsonNode node) {

		if (!node.has(STATUS_CONSTANTE) || !node.has(MENSAGEM_CONSTANTE))
			return null;

		int status = node.get(STATUS_CONSTANTE).asInt();

		Optional<Protocolo> protocoloPossivel = Arrays.stream(Protocolo.values())
				.filter(protocolo -> protocolo.getStatus() == status).findFirst();

		return protocoloPossivel.orElse(null);
	}

}
