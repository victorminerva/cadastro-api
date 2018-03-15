package br.com.minervait.spring.dao.loginjwtdao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.minervait.spring.model.Usuario;


@Repository
public class LoginJWTDaoImpl implements LoginJWTDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Usuario retrieveUserWithUsernameAndPassword(String username, String password) {
		return sessionFactory.getCurrentSession().get(Usuario.class, username);
	}

}
