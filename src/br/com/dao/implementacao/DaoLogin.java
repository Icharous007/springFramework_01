package br.com.dao.implementacao;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.repository.interfaces.RepositoryLogin;

public class DaoLogin extends ImplementacaoCrud<Object> implements RepositoryLogin{

	private static final long serialVersionUID = 1L;

	@Override
	public boolean isAutenticated(String login, String senha) throws Exception {
		String sql = "SELECT count(1) as autenticacao FROM entidade WHERE ent_login = ? AND ent_senha = ?";
		SqlRowSet sqlRowSet = super.getJdbcTemplate().queryForRowSet(sql, new Object[] {login,senha});
		return sqlRowSet.next()? sqlRowSet.getInt("autenticacao")>0: false;
	}

}
