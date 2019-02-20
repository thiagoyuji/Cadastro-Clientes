/**
 * @author stnin.stnin 
 */
package com.cadastro.excessoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.metadata.ConstraintDescriptor;

import com.cadastro.anotacoes.Anotacao;
import com.cadastro.protocolos.Protocolo;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Violacoes {
	
	private List<Protocolo> protocolos;
	
	Violacoes() {
		protocolos = new ArrayList<>();
	}
	
	public List<Protocolo> getProtocolos() {
		
		System.out.println("\n\n\n\n\n\nAAA" + protocolos.size() + " : " + protocolos + "\n\n\n\n\n\n");
		return protocolos;
	}

	public void setProtocolos(List<Protocolo> protocolos) {
		this.protocolos = protocolos;
	}

	void inserirViolacao(ConstraintViolation<?> violacao) {
		Object protocolo = obterProtocoloDeConstraintDescriptor(violacao.getConstraintDescriptor());
		protocolos.add((Protocolo) protocolo);
	}
	
	private Object obterProtocoloDeConstraintDescriptor( ConstraintDescriptor<?> constraintDescriptor ) {
		return obterProtocoloDeAtributos(constraintDescriptor.getAttributes());
	}
	
	private Object obterProtocoloDeAtributos(Map<String, Object> atributos) {
		return atributos.get(Anotacao.PROTOCOLO);
	}
	
}
