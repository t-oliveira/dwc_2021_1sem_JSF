package control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import model.Pessoa;
import util.JSFMessage;
import util.PessoaService;

@ManagedBean(name = "PagPessoa")
@ViewScoped
public class PessoaBean {

	private List<Pessoa> listaPessoas;
	private ListDataModel<Pessoa> novaListaPessoas;
	private Pessoa pessoa;
	
	public PessoaBean() {
		//Popular Lista
	}

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
	
	public ListDataModel<Pessoa> getNovaListaPessoas() {
		return novaListaPessoas;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setNovaListaPessoas(ListDataModel<Pessoa> pessoas) {
		this.novaListaPessoas = pessoas;
	}

	public void PrepararEditar() {
		this.pessoa = novaListaPessoas.getRowData();
	}
	
	public void PrepararDeletar() {
		this.pessoa = novaListaPessoas.getRowData();
	}
	
	public void Clear() {
		this.pessoa = new Pessoa();
	}
	
	public void PrepararCadastrar() {
		this.pessoa = new Pessoa();
	}
	
	public void Cadastrar() {
		try {
			this.listaPessoas.add(this.pessoa);
			
			this.novaListaPessoas = new ListDataModel<Pessoa>(this.listaPessoas);
			
			JSFMessage.adicionarMensagemDeSucesso("Pessoa cadastrada com sucesso!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void Update() {
		try {
			JSFMessage.adicionarMensagemDeSucesso("Pessoa atualizada com sucesso!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void Deletar() {
		try {

			this.listaPessoas.remove(this.pessoa);
			
			this.novaListaPessoas = new ListDataModel<Pessoa>(this.listaPessoas);
			
			JSFMessage.adicionarMensagemDeSucesso("Pessoa deletada com sucesso!");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@PostConstruct
	public void iniciar() {
		try {
			//Popular Lista de Pessoas
			PessoaService serv = new PessoaService();
			this.listaPessoas = serv.getListaDePessoas();
			
			this.novaListaPessoas = new ListDataModel<Pessoa>(this.listaPessoas);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
