package br.com.srv.implementacao;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.repository.interfaces.RepositoryLogin;
import br.com.srv.interfaces.SrvLogin;

public class SrvLoginImpl implements SrvLogin {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RepositoryLogin repositoryLogin;
	@Override
	public boolean isAutenticado(String login, String senha) throws Exception {
		return repositoryLogin.isAutenticated(login, senha);
	}

}