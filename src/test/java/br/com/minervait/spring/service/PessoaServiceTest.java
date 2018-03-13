package br.com.minervait.spring.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.minervait.spring.config.JPAConfig;
import br.com.minervait.spring.dao.PessoaDao;
import br.com.minervait.spring.model.Pessoa;
import br.com.minervait.spring.service.PessoaService;
import br.com.minervait.spring.service.PessoaServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { JPAConfig.class })
public class PessoaServiceTest {

	/**
	 * Mensagem default para indicar quando o teste falhar e não levantar a exceção desejada.
	 *
	 * @see Assert#fail(String)
	 *
	 * @author Victor Minerva 
	 */
	private static final String MSG_FAIL_EXCEPTION = "Teste falhou. Exceção não levantada.";

	private Pessoa pessoa;
	
	@Mock
	private PessoaDao pessoaDao;

	@InjectMocks
	private PessoaService pessoaService = new PessoaServiceImpl();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Before
	public void inicializaPessoa() {
		pessoa = new Pessoa();
		pessoa.setNomeCompleto("Nome teste");
		pessoa.setCpf(12345678901L);
	}
	
	@Test
	public void testSuccess_save() {
		
		try {
			Mockito.when(pessoaDao.save(pessoa)).thenReturn(12345678901L);

			long retorno = pessoaService.save(pessoa);

			Mockito.verify(pessoaDao).save(pessoa);

			assertNotNull(retorno);
			assertEquals(12345678901L, retorno);
		} catch (Exception e) {
			fail(MSG_FAIL_EXCEPTION);
		}
	}

}
