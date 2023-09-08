package br.com.project.geral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Pais;
import br.com.repository.interfaces.RepositoryPais;
import br.com.srv.interfaces.SrvPais;

@Controller
public class PaisController extends ImplementacaoCrud<Pais> implements InterfaceCrud<Pais>{

	private static final long serialVersionUID = 1L;

	@Autowired
	private SrvPais srvPais;
	
	@Autowired
	private RepositoryPais repositoryPais;
}
