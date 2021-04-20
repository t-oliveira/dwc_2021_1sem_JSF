package control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Pessoa;
import util.PessoaService;

@ManagedBean(name = "PagPessoa")
@ViewScoped
public class PessoaBean {

	private List<Pessoa> listaPessoas;
	
	public PessoaBean() {
		//Popular Lista
	}

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
	
	@PostConstruct
	public void iniciar() {
		try {
			//Popular Lista de Pessoas
			PessoaService serv = new PessoaService();
			this.listaPessoas = serv.getListaDePessoas();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
