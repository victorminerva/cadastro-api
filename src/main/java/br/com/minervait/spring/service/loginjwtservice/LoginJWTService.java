package br.com.minervait.spring.service.loginjwtservice;

import br.com.minervait.spring.model.Usuario;

public interface LoginJWTService {

	Usuario retrieveUserWithUsernameAndPassword(String username, String password);
}
