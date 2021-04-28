package control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

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
	
	//----------------------------------
	public void onRowEdit(RowEditEvent<Pessoa> event) {
        FacesMessage msg = new FacesMessage("Pessoa editada", event.getObject().getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent<Pessoa> event) {
        FacesMessage msg = new FacesMessage("Edição cancelada", event.getObject().getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Celula alterada", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
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
