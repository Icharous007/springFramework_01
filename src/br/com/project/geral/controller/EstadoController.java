package br.com.project.geral.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Estado;
import br.com.repository.interfaces.RepositoryEstado;
import br.com.srv.interfaces.SrvEstado;

@Controller
public class EstadoController extends ImplementacaoCrud<Estado> implements InterfaceCrud<Estado>{

	private static final long serialVersionUID = 1L;

	@Autowired
	private SrvEstado srvEstado;
	
	@Autowired
	private RepositoryEstado repositoryEstado;
}
