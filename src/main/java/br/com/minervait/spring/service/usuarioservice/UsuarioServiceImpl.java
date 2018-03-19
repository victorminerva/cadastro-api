package br.com.minervait.spring.service.usuarioservice;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.minervait.spring.dao.usuariodao.UsuarioDao;
import br.com.minervait.spring.exception.EmailExistsException;
import br.com.minervait.spring.exception.ErrorSavingDataException;
import br.com.minervait.spring.model.Usuario;
import br.com.minervait.spring.util.CadastroUtils;

@Service
@Transactional(readOnly = false)
public class UsuarioServiceImpl implements UsuarioService {

	final static Logger logger = Logger.getLogger(UsuarioServiceImpl.class);

	private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private UsuarioDao usuarioDao;

	/** {@inheritDoc} */
	@Override
	public Long registerNewUser(Usuario usuario) throws EmailExistsException, ErrorSavingDataException {
		if (emailExists(usuario.getEmail())) {
			throw new EmailExistsException("Já existe uma conta para esse endereço de e-mail.");
		}
		// Encrypt the password
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));

		try {
			return usuarioDao.save(usuario);
		} catch (final Exception e) {
			logger.error("[registerNewUser] : " + e.getMessage(), e);
			throw new ErrorSavingDataException("Erro ao cadastrar Usuário.");
		}
	}

	private Boolean emailExists(String email) {
		if(email == null || "".equals(email)) {
			throw new IllegalArgumentException("Email está nulo ou vazio.");
		}
		if (!CadastroUtils.isEmailValid(email)) {
			throw new IllegalArgumentException("Email inválido.");
		}

		boolean emailExist = Boolean.FALSE;
		final Usuario usuario;
		try {
			usuario = usuarioDao.findByEmail(email);

			if (usuario != null) {
				emailExist = Boolean.TRUE;
			}
		} catch (final NoResultException e) {
			logger.error("[emailExists] - Nenhum registro encontrado. ", e);
			emailExist = Boolean.FALSE;
		} catch (final Exception e) {
			logger.fatal("[emailExists] - Ocorreu uma exceção ao buscar dados email informado. ", e);
			emailExist = Boolean.FALSE;
		}

		return emailExist;
	}

}
