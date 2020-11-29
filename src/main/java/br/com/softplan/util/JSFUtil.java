package br.com.softplan.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 * @author LSDuarte
 *
 * Desáfio QA Avançado | Softplan
 *
 */
public class JSFUtil {

	public static void adicionarMensagemSucesso(String mensagem, String tittleMessage) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, tittleMessage);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}

}