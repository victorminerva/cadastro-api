package br.com.minervait.spring.dao.usuariodao;

import br.com.minervait.spring.model.Usuario;

public interface UsuarioDao {

	/**
	 * <p>
	 * Save the user in database
	 *
	 * @param usuario
	 * @return the {@link Usuario#getUsuarioNome()}
	 */
	Long save(Usuario usuario);

	/**
	 * <p>
	 * Find email in database
	 * <p>
	 *
	 * @param email
	 * @return the {@link Usuario} object
	 */
	Usuario findByEmail(String email);
}
