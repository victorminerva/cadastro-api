package br.com.minervait.spring.service.usuarioservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.persistence.NoResultException;

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
import br.com.minervait.spring.model.Usuario;

/**
 * <p>
 * Unit test class for test the service class {@link UsuarioService}
 * </p>
 * <b>Unit tests naming strategy that one should follow for naming ours unit
 * tests:</b>
 *
 * <pre>
 * <code>should<b>ExpectedBehavior</b><code>When<b>StateUnderTest</b></code>
 *
 * e.g.:
 *	- shouldThrowsExceptionWhenAgeLessThan18
 *	- shouldFailToWithdrawMoneyForInvalidAccount
 * </pre>
 *
 * @author Victor Minerva
 * @since Mar 19, 2018.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { JPAConfig.class })
public class UsuarioServiceTest {

	/**
	 * Mensagem default para indicar quando o teste falhar e não levantar a exceção
	 * desejada.
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
	public void initUsuario() {
		usuario = new Usuario();
		usuario.setEmail("teste@gmail.com");
		usuario.setUsuarioNome("testeusuario");
		usuario.setSenha("testesenha");
	}

	@Test
	public void shouldSuccessWhenRegisterNewUser() {

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
	public void shouldThrowsErrorSavingDataExceptionWhenOccurredErrorWhenSaveDataInregisterNewUser() {

		Mockito.when(usuarioDao.findByEmail(usuario.getEmail())).thenReturn(null);
		Mockito.when(usuarioDao.save(usuario)).thenThrow(new RuntimeException());

		try {
			usuarioService.registerNewUser(usuario);

		} catch (final Exception e) {
			assertEquals("Erro ao cadastrar Usuário.", e.getMessage());
		}
	}

	@Test
	public void shouldThrowsEmailExistsExceptionWhenUserExistsForThisEmailInRegisterNewUser() {

		Mockito.when(usuarioDao.findByEmail(usuario.getEmail())).thenReturn(usuario);/* user not exists */

		try {
			usuarioService.registerNewUser(usuario);

		} catch (final Exception e) {
			assertEquals("Já existe uma conta para esse endereço de e-mail.", e.getMessage());
		}
	}

	@Test
	public void shouldThrowsIllegalArgumentExceptionWhenEmailIsNullInRegisterNewUser() {
		usuario.setEmail(null);

		try {
			usuarioService.registerNewUser(usuario);

		} catch (final Exception e) {
			assertEquals("Email está nulo ou vazio.", e.getMessage());
		}
	}

	@Test
	public void shouldThrowsIllegalArgumentExceptionWhenEmailIsEmptyInRegisterNewUser() {
		usuario.setEmail("");

		try {
			usuarioService.registerNewUser(usuario);

		} catch (final Exception e) {
			assertEquals("Email está nulo ou vazio.", e.getMessage());
		}
	}

	@Test
	public void shouldThrowsIllegalArgumentExceptionWhenEmailIsInvalidInRegisterNewUser() {
		usuario.setEmail("abbca@_invalid.com");

		try {
			usuarioService.registerNewUser(usuario);

		} catch (final Exception e) {
			assertEquals("Email inválido.", e.getMessage());
		}
	}

	@Test
	public void shouldCatchNoResultExceptionAndSaveNormallyWhenNotExistsUserForEmailInformedInRegisterNewUser() {
		Mockito.when(usuarioDao.findByEmail(usuario.getEmail())).thenThrow(new NoResultException());
		Mockito.when(usuarioDao.save(usuario)).thenReturn(1L);

		try {
			final Long id = usuarioService.registerNewUser(usuario);

			assertNotNull(id);
		} catch (final Exception e) {
			fail(MSG_FAIL_EXCEPTION);
		}
	}

	@Test
	public void shouldCatchAnyExceptionAndSaveNormallyWhenNotExistsUserForEmailInformedInRegisterNewUser() {
		Mockito.when(usuarioDao.findByEmail(usuario.getEmail())).thenThrow(new RuntimeException());
		Mockito.when(usuarioDao.save(usuario)).thenReturn(1L);

		try {
			final Long id = usuarioService.registerNewUser(usuario);

			assertNotNull(id);
		} catch (final Exception e) {
			fail(MSG_FAIL_EXCEPTION);
		}
	}

}
