package br.com.minervait.spring.dao;

import java.util.List;

import br.com.minervait.spring.model.Pessoa;

public interface PessoaDao {
	long save(Pessoa pessoa);

	Pessoa get(long id);

	List<Pessoa> list();

	void update(long id, Pessoa pessoa);

	void delete(long id);
}
