package br.com.minervait.spring.service.pessoaservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.minervait.spring.dao.PessoaDao;
import br.com.minervait.spring.model.Pessoa;

@Service
@Transactional(readOnly = false)
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaDao pessoaDao;
	
	public long save(Pessoa pessoa) {
		return pessoaDao.save(pessoa);
	}

	public Pessoa get(long id) {
		return pessoaDao.get(id);
	}

	public List<Pessoa> list() {
		return pessoaDao.list();
	}

	public void update(long id, Pessoa pessoa) {
		pessoaDao.update(id, pessoa);
	}

	public void delete(long id) {
		pessoaDao.delete(id);
	}

}
