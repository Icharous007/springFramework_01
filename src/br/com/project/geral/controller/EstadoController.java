package br.com.project.geral.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.model.classes.Estado;
import br.com.srv.interfaces.SrvEstado;

@Controller
public class EstadoController extends ImplementacaoCrud<Estado> implements InterfaceCrud<Estado>{

	private static final long serialVersionUID = 1L;

	@Autowired
	private SrvEstado srvEstado;
	
	public List<SelectItem> getListEstados() throws Exception{
		List<SelectItem> lista = new ArrayList<>();
		List<Estado> estados = super.findListByQueryDinamica("FROM Estado");
		
		for (Estado estado : estados) {
			lista.add(new SelectItem(estado,estado.getEstado_nome()));
		}
		return lista;
	}
}
