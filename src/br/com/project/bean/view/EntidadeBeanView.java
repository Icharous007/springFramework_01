package br.com.project.bean.view;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.geral.controller.EntidadeController;

@Controller
@Scope(value = "session")//infomações com o tempo de vida de sessão.
@ManagedBean(name = "entidadeBeanView")
public class EntidadeBeanView extends BeanManagedViewAbstract{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ContextoBean contextoBean;
	
	
	public String getUsuarioLogadoSecurity() {
		return contextoBean.getAuthentication().getName();
	}
	
	public Date getUltimoAcesso() throws Exception {
		return contextoBean.getEntidadeLogada().getEnt_ultimoacesso();
	}
}
