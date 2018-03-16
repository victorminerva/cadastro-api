package br.com.minervait.spring.dao.usuariodao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.minervait.spring.model.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;

	/** {@inheritDoc} */
	@Override
	public Long save(Usuario usuario) {
		sessionFactory.getCurrentSession().save(usuario);
		return usuario.getId();
	}

	/** {@inheritDoc} */
	@Override
	public Usuario findByEmail(final String email) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		
		Root<Usuario> root = criteriaQuery.from(Usuario.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("email"), email));

		Query<Usuario> query = sessionFactory.getCurrentSession().createQuery(criteriaQuery);
		Usuario usuario = query.getSingleResult();

		return usuario;
	}

}
