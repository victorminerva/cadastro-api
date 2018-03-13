package br.com.minervait.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "MEIO_CONTATO")
public class MeioContato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MEIO_CONTATO")
	private Long idMeioContato;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "ID_CONTATO")
	private Contato contato;

	public Long getIdMeioContato() {
		return idMeioContato;
	}

	public void setIdMeioContato(Long idMeioContato) {
		this.idMeioContato = idMeioContato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
