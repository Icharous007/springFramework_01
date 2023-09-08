package br.com.project.geral.controller;

import java.util.HashMap;

import javax.faces.bean.ApplicationScoped;
import javax.servlet.http.HttpSession;

@ApplicationScoped
public class SessionControllerImpl implements SessionController {

	private static final long serialVersionUID = 1L;
	private HashMap<String,HttpSession> hashMap = new HashMap<String, HttpSession>();

	@Override
	public void addSession(String codigoDoUsuarioLogado, HttpSession httpSession) {
		hashMap.put(codigoDoUsuarioLogado, httpSession);
		
	}

	@Override
	public void invalidadeSession(String codigoDoUsuarioLogado) {
		if (hashMap.containsKey(codigoDoUsuarioLogado)) {
			hashMap.get(codigoDoUsuarioLogado).invalidate();
			hashMap.remove(codigoDoUsuarioLogado);
		}else {
			System.out.println("sem usuário");
		}
	}

}
