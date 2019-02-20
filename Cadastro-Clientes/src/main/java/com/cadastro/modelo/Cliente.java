/**
 * @author stnin.stnin
 */
package com.cadastro.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import com.cadastro.anotacoes.CpfInvalido;
import com.cadastro.anotacoes.DataInvalida;
import com.cadastro.anotacoes.EmailInvalido;
import com.cadastro.anotacoes.NaoVazio;
import com.cadastro.protocolos.Protocolo;

@Entity
@Table(name = "Clientes")
public class Cliente {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	
	@NaoVazio(protocolo = Protocolo.NOME_NAO_PODE_SER_VAZIO)
	private String nome;
	
	private int idade;
	
	@NaoVazio(protocolo = Protocolo.ENDERECO_NAO_PODE_SER_VAZIO)
	private String endereco;
	
	@NaoVazio(protocolo = Protocolo.NUMERO_DE_TELEFONE_NAO_PODE_SER_VAZIO)
	private String numeroTelefone;
	
	@NaoVazio(protocolo = Protocolo.EMAIL_NAO_PODE_SER_VAZIO)
	@EmailInvalido(protocolo = Protocolo.EMAIL_NAO_VALIDO)
	private String email;
	
	@NaoVazio(protocolo = Protocolo.CPF_NAO_PODE_SER_VAZIO)
	@CpfInvalido(protocolo = Protocolo.CPF_NAO_VALIDO)
	private String cpf;
	
	@NaoVazio(protocolo = Protocolo.DATA_DE_NASCIMENTO_NAO_PODE_SER_VAZIO)
	@DataInvalida(protocolo = Protocolo.DATA_DE_NASCIMENTO_NAO_VALIDO)
	private String dataNascimento;
	
	private char sexo;
	
	@NaoVazio(protocolo = Protocolo.PROFISSAO_NAO_PODE_SER_VAZIO)
	private String profissao;
	
	
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	@Validated
	public Cliente setNome(String nome) {
		this.nome = nome;
		return this;
	}
	public int getIdade() {
		return idade;
	}
	@Validated
	public Cliente setIdade(int idade) {
		this.idade = idade;
		return this;
	}
	public String getEndereco() {
		return endereco;
	}
	@Validated
	public Cliente setEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}
	public String getNumeroTelefone() {
		return numeroTelefone;
	}
	@Validated
	public Cliente setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
		return this;
	}
	public String getEmail() {
		return email;
	}
	@Validated
	public Cliente setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getCpf() {
		return cpf;
	}
	@Validated
	public Cliente setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	@Validated
	public Cliente setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}
	public char getSexo() {
		return sexo;
	}
	@Validated
	public Cliente setSexo(char sexo) {
		this.sexo = sexo;
		return this;
	}
	public String getProfissao() {
		return profissao;
	}
	@Validated
	public Cliente setProfissao(String profissao) {
		this.profissao = profissao;
		return this;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", idade=" + idade + ", endereco=" + endereco
				+ ", numeroTelefone=" + numeroTelefone + ", email=" + email + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + ", sexo=" + sexo + ", profissao=" + profissao + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroTelefone == null) ? 0 : numeroTelefone.hashCode());
		result = prime * result + ((profissao == null) ? 0 : profissao.hashCode());
		result = prime * result + sexo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else
			return getCpf().equals(other.cpf);
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else 
			return getDataNascimento().equals(other.dataNascimento);
		if (email == null) {
			if (other.email != null)
				return false;
		} else 
			return getEmail().equals(other.email);
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else
			return getEndereco().equals(other.endereco);
		if (getId() != other.id)
			return false;
		if (idade != other.idade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else 
			return getNome().equals(other.nome);
		if (numeroTelefone == null) {
			if (other.numeroTelefone != null)
				return false;
		} else 
			return getNumeroTelefone().equals(other.numeroTelefone);
		if (profissao == null) {
			if (other.profissao != null)
				return false;
		} else 
			return getProfissao().equals(other.profissao);
		if (sexo != other.sexo)
			return false;
		return true;
	}

	
}
