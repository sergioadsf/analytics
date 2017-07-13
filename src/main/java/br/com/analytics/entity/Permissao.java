package br.com.analytics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "permissao")
public class Permissao extends Entidade<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "visualiza")
	private boolean visualiza;

	@Column(name = "insere")
	private boolean insere;

	@Column(name = "edita")
	private boolean edita;

	@Column(name = "exclui")
	private boolean exclui;

	@Version
	@Column(name = "versao")
	private Long versao;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(final Long id) {
		this.id = id;
	}

	public boolean isVisualiza() {
		return visualiza;
	}

	public void setVisualiza(final boolean visualiza) {
		this.visualiza = visualiza;
	}

	public boolean isInsere() {
		return insere;
	}

	public void setInsere(final boolean insere) {
		this.insere = insere;
	}

	public boolean isEdita() {
		return edita;
	}

	public void setEdita(final boolean edita) {
		this.edita = edita;
	}

	public boolean isExclui() {
		return exclui;
	}

	public void setExclui(final boolean exclui) {
		this.exclui = exclui;
	}

	public Long getVersao() {
		return versao;
	}

	public void setVersao(Long versao) {
		this.versao = versao;
	}

}
