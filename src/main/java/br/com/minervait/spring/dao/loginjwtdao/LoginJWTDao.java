package br.com.minervait.spring.dao.loginjwtdao;

import br.com.minervait.spring.model.Usuario;

public interface LoginJWTDao {

	Usuario retrieveUserWithUsernameAndPassword(String username, String password);
}
