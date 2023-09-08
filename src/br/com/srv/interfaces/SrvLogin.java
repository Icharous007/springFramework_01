package br.com.srv.interfaces;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public interface SrvLogin extends Serializable{
	boolean isAutenticado(String login, String senha) throws Exception;
}
