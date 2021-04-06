package control;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "indexBean")
@ViewScoped
public class IndexBean {
	
	private String texto;
	
	private String textoButton;

	public IndexBean() {
		this.texto = "Teste de valor e ligação através do ManageBean";
		this.textoButton = "Ok";
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getTextoButton() {
		return textoButton;
	}

	public void setTextoButton(String textoButton) {
		this.textoButton = textoButton;
	}
}
