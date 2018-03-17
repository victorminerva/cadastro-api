package br.com.minervait.spring.service.usuarioservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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
import br.com.minervait.spring.dao.usuariodao.UsuarioDao;
import br.com.minervait.spring.exception.ErrorSavingDataException;
import br.com.minervait.spring.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { JPAConfig.class })
public class UsuarioServiceTest {

	/**
	 * Mensagem default para indicar quando o teste falhar e não levantar a exceção desejada.
	 *
	 * @see Assert#fail(String)
	 *
	 * @author Victor Minerva
	 */
	private static final String MSG_FAIL_EXCEPTION = "Teste falhou. Exceção não levantada.";

	private Usuario usuario;

	@Mock
	private UsuarioDao usuarioDao;

	@InjectMocks
	private final UsuarioService usuarioService = new UsuarioServiceImpl();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Before
	public void inicializaUsuario() {
		usuario = new Usuario();
		usuario.setEmail("teste@gmail.com");
		usuario.setUsuarioNome("testeusuario");
		usuario.setSenha("testesenha");
	}

	@Test
	public void testSuccess_registerNewUser() {

		Mockito.when(usuarioDao.findByEmail(usuario.getEmail())).thenReturn(null);/* user not exists */
		Mockito.when(usuarioDao.save(usuario)).thenReturn(1L);

		try {
			final Long id = usuarioService.registerNewUser(usuario);

			assertNotNull(id);

			Mockito.verify(usuarioDao).save(usuario);
			Mockito.verify(usuarioDao).findByEmail(usuario.getEmail());
		} catch (final Exception e) {
			fail(MSG_FAIL_EXCEPTION);
		}
	}

	@Test
	public void testFail_registerNewUser_UserExistsForThisEmail() {

		Mockito.when(usuarioDao.findByEmail(usuario.getEmail())).thenReturn(usuario);/* user not exists */

		try {
			usuarioService.registerNewUser(usuario);

			fail(MSG_FAIL_EXCEPTION);
		} catch (final Exception e) {
			assertEquals("Já existe uma conta para esse endereço de e-mail.", e.getMessage());
		}
	}

	@Test
	public void testFail_registerNewUser_ErrorWhenSaveData() {

		Mockito.when(usuarioDao.findByEmail(usuario.getEmail())).thenThrow(new ErrorSavingDataException("Erro."));

		try {
			usuarioService.registerNewUser(usuario);

			fail(MSG_FAIL_EXCEPTION);
		} catch (final Exception e) {
			assertEquals("Erro.", e.getMessage());
		}
	}

}
