package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pessoa implements Serializable {

	//Para serialização!
	private static final long serialVersionUID = 1L;
	
	private int cpf;
	private String nome;
	private String cel;
	private String email;
	//Relacionamento Unidirecional com a classe Endereco
	private List<Endereco> enderecos;
	private Endereco endPadrao;
	
	public Pessoa() { 
		this.enderecos = new ArrayList<Endereco>();
		this.endPadrao = new Endereco();
	}
	
	public Pessoa(int cpf, String nome, String cel, String email, List<Endereco> enderecos) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.cel = cel;
		this.email = email;
		this.enderecos = enderecos;
	}

	public int getCpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCel() {
		return cel;
	}
	
	public void setCel(String cel) {
		this.cel = cel;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public Endereco getEndPadrao() {
		return endPadrao;
	}

	public void setEndPadrao(Endereco endPadrao) {
		this.endPadrao = endPadrao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpf;
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
		Pessoa other = (Pessoa) obj;
		if (cpf != other.cpf)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", cel=" + cel + ", email=" + email + ", Endereços=" + getEnderecos() + "]" ;
	}
}
