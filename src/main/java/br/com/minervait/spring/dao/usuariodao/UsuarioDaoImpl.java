package br.com.minervait.spring.dao.usuariodao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.minervait.spring.model.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;

	private CriteriaBuilder builder;

	/** {@inheritDoc} */
	@Override
	public Long save(Usuario usuario) {
		sessionFactory.getCurrentSession().save(usuario);
		return usuario.getId();
	}

	/** {@inheritDoc} */
	@Override
	public Usuario findByEmail(final String email) {
		builder = sessionFactory.getCriteriaBuilder();
		final CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
		final Root<Usuario> root = query.from(Usuario.class);
		query.select(root).where(builder.equal(root.get("email"), email));

		final Query<Usuario> result = sessionFactory.getCurrentSession().createQuery(query);
		final Usuario usuario = result.getSingleResult();

		return usuario;
	}

}
