package br.com.minervait.spring.service.pessoaservice;

import java.util.List;

import br.com.minervait.spring.model.Pessoa;

public interface PessoaService {
	long save(Pessoa pessoa);

	Pessoa get(long id);

	List<Pessoa> list();

	void update(long id, Pessoa pessoa);

	void delete(long id);
}
