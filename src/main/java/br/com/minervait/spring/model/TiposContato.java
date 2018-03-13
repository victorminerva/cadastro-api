package br.com.minervait.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <p>
 * The TiposContato domain.
 *
 * @author Victor Minerva
 * @since Mar 13, 2018.
 */
@Entity(name = "TIPOS_CONTATO")
public class TiposContato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TIPO_CONTATO")
	private Long idTipoContato;
	
	@Column(name = "DESC_TIPO_CONTATO", nullable = false)
	private String descTipoContato;

	public Long getIdTipoContato() {
		return idTipoContato;
	}

	public void setIdTipoContato(Long idTipoContato) {
		this.idTipoContato = idTipoContato;
	}

	public String getDescTipoContato() {
		return descTipoContato;
	}

	public void setDescTipoContato(String descTipoContato) {
		this.descTipoContato = descTipoContato;
	}
}
