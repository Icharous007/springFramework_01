package br.com.project.geral.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Entidade;
import br.com.srv.interfaces.SrvEntidade;

@Controller
public class EntidadeController extends ImplementacaoCrud<Entidade> implements InterfaceCrud<Entidade>{

	@Autowired
	private SrvEntidade srvEntidade;
	
	private static final long serialVersionUID = 1L;
	
	public void updateUltimoAcessoUser(String name) {
		srvEntidade.updateUltimoAcessoUser(name);
	}
	
	public Date getUltimoAcessoEntidadeLogada(String login) {
		return srvEntidade.getUltimoAcessoEntidadeLogada(login);
	}
	
	public Entidade findUserLogado(String userLogado) throws Exception {
		Entidade entidade = super.findUniqueByProperty(Entidade.class, userLogado, "ent_login", "and entity.ent_inativo is false");
		if(entidade != null) {
			
			return entidade;
		}
		return null;
	}
	
}
