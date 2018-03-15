package br.com.minervait.spring.service.loginjwtservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.minervait.spring.dao.loginjwtdao.LoginJWTDao;
import br.com.minervait.spring.model.Usuario;

@Service
@Transactional(readOnly = true)
public class LoginJWTServiceImpl implements LoginJWTService {

	@Autowired
	private LoginJWTDao loginJWTDao;

	@Override
	public Usuario retrieveUserWithUsernameAndPassword(String username, String password) {
		return loginJWTDao.retrieveUserWithUsernameAndPassword(username, password);
	}

}
