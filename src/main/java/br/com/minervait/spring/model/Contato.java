package br.com.minervait.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTATO")
	private Long idContato;
	
	@Column(name = "ID_TIPO_CONTATO", nullable = false)
	private TiposContato tipoContato;

	public Long getIdContato() {
		return idContato;
	}

	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}

	public TiposContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TiposContato tipoContato) {
		this.tipoContato = tipoContato;
	}
}
