package br.com.minervait.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import br.com.minervait.spring.enums.SexoEnum;

/**
 * <p>
 * The Pessoa domain.
 *
 * @author Victor Minerva
 * @since Mar 13, 2018.
 */
@Entity
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CPF")
	private Long cpf;

	@Column(name = "NOME_COMPLETO", nullable = false)
	private String nomeCompleto;

	@Column(name = "NOME_MAE", nullable = false)
	private String nomeMae;

	@Column(name = "DATA_NASCIMENTO", nullable = false)
	private Date dataNascimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "SEXO", nullable = false)
	private SexoEnum sexo;

	@Column(name = "RG")
	private Long rg;

	@Column(name = "ESTADO_CIVIL", nullable = false)
	private String estadoCivil;

	@Column(name = "UF_RG")
	private String ufRg;

	@Column(name = "CIDADE_RG")
	private String cidadeRg;

	@Column(name = "ID_ENDERECO", nullable = false)
	private Endereco endereco;

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long rg) {
		this.rg = rg;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getUfRg() {
		return ufRg;
	}

	public void setUfRg(String ufRg) {
		this.ufRg = ufRg;
	}

	public String getCidadeRg() {
		return cidadeRg;
	}

	public void setCidadeRg(String cidadeRg) {
		this.cidadeRg = cidadeRg;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
