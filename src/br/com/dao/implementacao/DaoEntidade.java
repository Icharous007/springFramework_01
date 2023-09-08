package br.com.dao.implementacao;

import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import br.com.framework.implementacao.crud.ImplementacaoCrud;
import br.com.project.model.classes.Entidade;
import br.com.repository.interfaces.RepositoryEntidade;

@Repository
public class DaoEntidade extends ImplementacaoCrud<Entidade> implements RepositoryEntidade {

	private static final long serialVersionUID = -8805797887815693899L;
	
	@Override
	public Date getUltimoAcessoEntidadeLogada(String name) {
		SqlRowSet rowSet = super.getJdbcTemplate()
				.queryForRowSet("SELECT ent_ultimoacesso FROM entidade WHERE entidade_inativo is false and ent_login = ?", new Object[] {name});
		return rowSet.next()? rowSet.getDate(0): null;
	}

	@Override
	public void updateUltimoAcessoUser(String login) {
		super.getSimpleJdbcTemplate()
		.update("UPDATE entidade SET ent_ultimoacesso = current_timestamp WHERE ent_inativo is false and ent_login = ?", login);
	
	}

	@Override
	public boolean existeUsuario(String ent_login) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT count(1) >=1 FROM entidade WHERE ent_login = '").append(ent_login).append("' ");
		
		return super.getSimpleJdbcTemplate().queryForObject(builder.toString(), boolean.class, ent_login);
	}

}
