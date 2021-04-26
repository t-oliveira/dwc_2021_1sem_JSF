package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFMessage {

	public static void adicionarMensagemDeSucesso(String _msg) {
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCESSO!", _msg);
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		contexto.addMessage(null, msg);
	}
	
	public static void adicionarMensagemDeErro(String _msg) {
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "FALHA!", _msg);
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		contexto.addMessage(null, msg);
	}
}