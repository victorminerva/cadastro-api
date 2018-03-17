package br.com.minervait.spring.dao.usuariodao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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
import br.com.minervait.spring.model.Usuario;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAConfig.class })
@Rollback(value = true)
@Transactional
public class UsuarioDaoTest {

	private Usuario usuario;

	@Autowired
	private UsuarioDao usuarioDao;

	@Before
	public void inicializaUsuario() {
		usuario = new Usuario();
		usuario.setEmail("teste@gmail.com");
		usuario.setUsuarioNome("testeusuario");
		usuario.setSenha("testesenha");
	}

	@Test
	public void testSuccess_registerNewUser() {
		try {
			final Long id = usuarioDao.save(usuario);

			assertNotNull(id);
		} catch (final Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testSuccess_findByEmail() {
		try {
			usuarioDao.save(usuario);

			final Usuario retorno = usuarioDao.findByEmail(usuario.getEmail());

			assertNotNull(retorno);
			assertEquals("testeusuario", retorno.getUsuarioNome());
		} catch (final Exception e) {
			fail(e.getMessage());
		}
	}

}
