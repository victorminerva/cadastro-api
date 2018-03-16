package br.com.minervait.spring.service.usuarioservice;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.minervait.spring.dao.usuariodao.UsuarioDao;
import br.com.minervait.spring.exception.EmailExistsException;
import br.com.minervait.spring.exception.ErrorSavingDataException;
import br.com.minervait.spring.model.Usuario;

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
			logger.error("[registerNewUser] : " + e.getMessage());
			throw new ErrorSavingDataException("Erro ao cadastrar Usuário.");
		}
	}

	private Boolean emailExists(String email) {
		boolean emailExist = Boolean.FALSE;
		final Usuario usuario = usuarioDao.findByEmail(email);

		if (usuario != null) {
			emailExist = Boolean.TRUE;
		}
		return emailExist;
	}

}
