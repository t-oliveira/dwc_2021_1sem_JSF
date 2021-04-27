package util;

import java.util.ArrayList;
import java.util.List;
import java.time.*;

import model.Pessoa;

public class PessoaService {
	
	private List<Pessoa> listaDePessoas;
	
	public PessoaService() {
		
		this.listaDePessoas = new ArrayList<Pessoa>();
		
		for (int i = 1; i <= 5; i++) {
			
			Pessoa p = new Pessoa();
			
			p.setCpf(i);
			p.setNome("Teste" + i);
			p.setCel("(21) " + i + "1111-1111");
			p.setEmail("teste" + i + "@gmail.com");
			p.setNascimento(LocalDate.now());
		
			
			EnderecoService serv = new EnderecoService(i -1);
			
			p.setEnderecos(serv.getListaEnderecos());
			
			listaDePessoas.add(p);
		}
		/*
		listaDePessoas.add(new Pessoa(1, "Teste1", "(21) 11111-1111", "teste1@gmail.com"));
		listaDePessoas.add(new Pessoa(2, "Teste2", "(21) 21111-1111", "teste2@gmail.com"));
		listaDePessoas.add(new Pessoa(3, "Teste3", "(21) 31111-1111", "teste3@gmail.com"));
		listaDePessoas.add(new Pessoa(4, "Teste4", "(21) 41111-1111", "teste4@gmail.com"));
		listaDePessoas.add(new Pessoa(5, "Teste5", "(21) 51111-1111", "teste5@gmail.com"));
		*/
	}

	public List<Pessoa> getListaDePessoas() {
		return listaDePessoas;
	}
}
