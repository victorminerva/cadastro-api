package br.com.minervait.spring.service.usuarioservice;

import br.com.minervait.spring.exception.EmailExistsException;
import br.com.minervait.spring.exception.ErrorSavingDataException;
import br.com.minervait.spring.model.Usuario;

public interface UsuarioService {

	/**
	 * <p>
	 * Register the user informed when not exists user with email registered.
	 *
	 * @param usuario
	 * @return the {@link Usuario#getId()}
	 * @throws EmailExistsException
	 *             throw a exception when email exist in database
	 * @throws ErrorSavingDataException
	 *             throw a exception when occurred some error to save data
	 */
	public Long registerNewUser(Usuario usuario) throws EmailExistsException, ErrorSavingDataException;

}
