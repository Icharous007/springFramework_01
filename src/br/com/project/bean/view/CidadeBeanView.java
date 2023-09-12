package br.com.project.bean.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.geral.controller.CidadeController;
import br.com.project.model.classes.Cidade;

@Controller
@Scope(value = "session")
@ManagedBean(name = "cidadeBeanView")
public class CidadeBeanView extends BeanManagedViewAbstract{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CidadeController cidadeController;
	
	private Cidade cidadeSelecionada = new Cidade();
	
	private List<Cidade> listaDeCidades = new ArrayList<>();

	private final String url_raiz  = "/cadastro/cadastro_cidade.jsf?faces-redirect=true";
	
	private final String url_pesquisa  = "/cadastro/pesquisa_cadastro_cidade.jsf?faces-redirect=true";


	public Cidade getCidadeSelecionada() {
		return cidadeSelecionada;
	}


	public void setCidadeSelecionada(Cidade cidadeSelecionada) {
		this.cidadeSelecionada = cidadeSelecionada;
	}
	
	@Override
	public String save() throws Exception {
		cidadeSelecionada = cidadeController.merge(cidadeSelecionada);
		return "";
	}
	
	@Override
	public String novo() throws Exception {
		cidadeSelecionada = new Cidade();
		return url_raiz;
	}
	
	public List<Cidade> getListaDeCidades() throws Exception{
		listaDeCidades.clear();
		listaDeCidades = cidadeController.findList(getClassDaView());
		return listaDeCidades;
	}
	
	@Override
	public String editar() throws Exception {
		return url_raiz;
	}
	
	@Override
	public void excluir() throws Exception {
		cidadeSelecionada = (Cidade) cidadeController.getSession().get(getClassDaView(), cidadeSelecionada.getCidade_id());
		cidadeController.delete(cidadeSelecionada);
		getListaDeCidades();
		sucesso();
		cidadeSelecionada = new Cidade();
	}
	
	@Override
	public void saveNotReturn() throws Exception {
		listaDeCidades.clear();
		cidadeController.save(cidadeSelecionada);
		sucesso();
		cidadeSelecionada = new Cidade();
		getListaDeCidades();
	}
	
	@Override
	public void saveEdit() throws Exception {
		listaDeCidades.clear();
		cidadeSelecionada = cidadeController.merge(cidadeSelecionada);
		sucesso();
		cidadeSelecionada = new Cidade();
		getListaDeCidades();
	}

	@Override
	protected Class<Cidade> getClassDaView() {
		return Cidade.class;
	}
	
	@Override
	public void setarVariaveisNulas() throws Exception {
		listaDeCidades.clear();
		cidadeSelecionada= new Cidade();
	}
	
	@Override
	public String redirecionarFindEntidade() throws Exception {
		setarVariaveisNulas();
		return url_pesquisa;
	}


	@Override
	protected InterfaceCrud<Cidade> getController() {
		
		return cidadeController;
	}
}
