package model;

import java.io.Serializable;

public class Pessoa implements Serializable {

	//Para serialização!
	private static final long serialVersionUID = 1L;
	
	private int cpf;
	private String nome;
	private String cel;
	private String email;
	
	public Pessoa() { }
	
	public Pessoa(int cpf, String nome, String cel, String email) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.cel = cel;
		this.email = email;
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
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", cel=" + cel + ", email=" + email + "]";
	}
}
