package br.com.repository.interfaces;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLogin extends Serializable{

	boolean isAutenticated(String login, String senha) throws Exception;
}
