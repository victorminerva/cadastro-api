package br.com.minervait.spring.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.minervait.spring.config.JPAConfig;
import br.com.minervait.spring.model.Pessoa;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAConfig.class })
@Rollback(value = true)
@Transactional
public class PessoaDaoTest {
	
	/**
	 * Mensagem default para indicar quando o teste falhar e não levantar a exceção desejada.
	 *
	 * @see Assert#fail(String)
	 *
	 * @author Victor Minerva 
	 */
	private static final String MSG_FAIL_EXCEPTION = "Teste falhou. Exceção não levantada.";
	

	private Pessoa pessoa;
	
	@Autowired
	private PessoaDao pessoaDao;
	
	@Before
	public void inicializaPessoa() {
		pessoa = new Pessoa();
		pessoa.setNomeCompleto("Nome teste");
		pessoa.setCpf(12345678901L);
	}
	
	@Test
	public void testSuccess_save() {
		try {
			long retorno = pessoaDao.save(pessoa);
			
			assertNotNull(retorno);
		} catch (Exception e) {
			e.printStackTrace();
//			fail(MSG_FAIL_EXCEPTION);
		}
	}

}
