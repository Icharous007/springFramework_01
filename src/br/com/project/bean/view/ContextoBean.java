package br.com.project.bean.view;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.project.geral.controller.EntidadeController;
import br.com.project.geral.controller.SessionController;
import br.com.project.model.classes.Entidade;

@Scope(value = "session")
@Component(value = "contextoBean")//anotação generica que permite a sua utilização em qualquer lugar da aplicação.
public class ContextoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static final String USER_LOGADO_SESSAO = "userLogadoSessao";
	
	@Autowired
	private EntidadeController entidadeController;
	
	@Autowired
	private SessionController sessionController;
	
	/**
	 * Retorna o dados do usuário logado pelo spring security.
	 * @return
	 */
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	public Entidade getEntidadeLogada() throws Exception {
		
		Entidade entidade = (Entidade) getExternalContext().getSessionMap().get(USER_LOGADO_SESSAO);
		if(entidade==null || (entidade!=null && !entidade.getEnt_login().equals(getUserPrincipal()))) {//o usuario foi trocado ou nao.
			if(getAuthentication().isAuthenticated()) {
				entidadeController.updateUltimoAcessoUser(getAuthentication().getName());
				entidade = entidadeController.findUserLogado(getAuthentication().getName());
				getExternalContext().getSessionMap().put(USER_LOGADO_SESSAO, entidade);
				sessionController.addSession(entidade.getEnt_login(), (HttpSession) getExternalContext().getSession(true));
				
			}
		}
		
		return entidade;
	}
	
	private String getUserPrincipal() {
		
		return getExternalContext().getUserPrincipal().getName();
	}

	public ExternalContext getExternalContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		return externalContext;
	}

}
