/**
 * @author stnin.stnin 
 */
package com.cadastro.dto;

public class ClienteDto {
	
	private String nome;
	
	private int idade;
	
	private String endereco;
	
	private String numeroTelefone;
	
	private String email;
	
	private String cpf;
	
	private String dataNascimento;
	
	private char sexo;
	
	private String profissao;

	
	public String getNome() {
		return nome;
	}

	public ClienteDto setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public int getIdade() {
		return idade;
	}

	public ClienteDto setIdade(int idade) {
		this.idade = idade;
		return this;
	}

	public String getEndereco() {
		return endereco;
	}

	public ClienteDto setEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public ClienteDto setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public ClienteDto setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getCpf() {
		return cpf;
	}

	public ClienteDto setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public ClienteDto setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}

	public char getSexo() {
		return sexo;
	}

	public ClienteDto setSexo(char sexo) {
		this.sexo = sexo;
		return this;
	}

	public String getProfissao() {
		return profissao;
	}

	public ClienteDto setProfissao(String profissao) {
		this.profissao = profissao;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
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
		ClienteDto other = (ClienteDto) obj;
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
