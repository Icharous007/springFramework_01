package br.com.project.bean.view;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.framework.interfac.crud.InterfaceCrud;
import br.com.project.bean.geral.BeanManagedViewAbstract;
import br.com.project.util.all.BeanViewAbstract;

@Component
@Scope(value = "session")
@ManagedBean(name = "mensagemBeanView")
public class MensagemBeanView extends BeanManagedViewAbstract{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String novo() throws Exception {
		System.out.println("teste");
		return null;
	}

	@Override
	protected Class<?> getClassDaView() {
		return null;
	}

	@Override
	protected InterfaceCrud<?> getController() {
		return null;
	}
}
