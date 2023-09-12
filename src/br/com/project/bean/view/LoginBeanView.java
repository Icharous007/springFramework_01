package br.com.project.bean.view;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.geral.controller.SessionController;
import br.com.project.model.classes.Entidade;
import br.com.srv.interfaces.SrvLogin;

@Controller
@Scope(value = "request")
@ManagedBean(name = "loginBeanView")
public class LoginBeanView extends BeanManagedViewAbstract{

	private static final long serialVersionUID = 1L;
	
	private String username;
	
	private String password;

	@Autowired
	private SessionController sessionController;
	
	@Autowired
	private SrvLogin srvLogin;
	
	public void invalidarSessao(ActionEvent actionEvent) throws Exception{
		RequestContext context = RequestContext.getCurrentInstance();
		boolean loggedIn = false;
		FacesMessage message = null;
		
		if(srvLogin.isAutenticado(username, password)) {
			sessionController.invalidadeSession(getUsername());
			loggedIn=true;
		}else {
			message = new FacesMessage(FacesMessage.SEVERITY_WARN,"Acesso Negado","Login ou senha incorretos");
		}
		if(message!=null) {
			FacesContext.getCurrentInstance().addMessage("msg", message);
		}
		context.addCallbackParam("loggedIn",loggedIn);
	}
	
	@RequestMapping(value = "**/invalidar_session", method = RequestMethod.POST)
	public void invalidarSessionLogout(HttpServletRequest httpServletRequest)throws Exception{
		String logedUserSession = null;
		if(httpServletRequest.getUserPrincipal() !=null) {
			logedUserSession = httpServletRequest.getUserPrincipal().getName();
		}
		if(logedUserSession == null ||(logedUserSession!=null && (logedUserSession.trim().isEmpty()))){
			logedUserSession = httpServletRequest.getRemoteUser();
		}
		if(logedUserSession != null && !logedUserSession.isEmpty()) {
			sessionController.invalidadeSession(logedUserSession);
		}
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	protected Class<Entidade> getClassDaView() {
		return null;
	}

	@Override
	protected InterfaceCrud<?> getController() {
		return null;
	}
	
	public SessionController getSessionController() {
		return sessionController;
	}
}
