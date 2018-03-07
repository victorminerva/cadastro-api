package br.com.minervait.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.minervait.spring.model.Pessoa;

@Repository
public class PessoaDaoImpl implements PessoaDao {

	@Autowired
	private SessionFactory sessionFactory;

	public long save(Pessoa pessoa) {
		sessionFactory.getCurrentSession().save(pessoa);
		return pessoa.getId();
	}

	public Pessoa get(long id) {
		return sessionFactory.getCurrentSession().get(Pessoa.class, id);
	}

	public List<Pessoa> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
		Root<Pessoa> root = cq.from(Pessoa.class);
		cq.select(root);
		Query<Pessoa> query = session.createQuery(cq);
		return query.getResultList();
	}

	public void update(long id, Pessoa pessoa) {
		Session session = sessionFactory.getCurrentSession();
		Pessoa pessoaTo = session.byId(Pessoa.class).load(id);
		pessoaTo.setName(pessoa.getName());
		pessoaTo.setCpf(pessoa.getCpf());
		session.flush();

	}

	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Pessoa pessoa = session.byId(Pessoa.class).load(id);
		session.delete(pessoa);
	}

}
