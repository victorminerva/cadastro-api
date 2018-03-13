package br.com.minervait.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * <p>
 * The Usuario domain.
 *
 * @author Victor Minerva
 * @since Mar 13, 2018.
 */
@Entity
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "USUARIO_NOME", nullable = false)
	private String usuarioNome;
	
	@Column(name = "SENHA", nullable = false)
	private String senha;

	public String getUsuarioNome() {
		return usuarioNome;
	}

	public void setUsuarioNome(String usuarioNome) {
		this.usuarioNome = usuarioNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
