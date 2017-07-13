package br.com.analytics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "menu")
public class Menu extends Entidade<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_menu_pai")
	private Menu menuPai;

	private String nome;

	@Column(name = "nome_pagina")
	private String nomePagina;

	@Column(name = "ativo")
	private Boolean ativo;

	public Menu() {
	}

	public Menu(Long id, Menu menuPai, String nome, String nomePagina) {
		super();
		this.id = id;
		this.menuPai = menuPai;
		this.nome = nome;
		this.nomePagina = nomePagina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Menu getMenuPai() {
		return menuPai;
	}

	public void setMenuPai(Menu menuPai) {
		this.menuPai = menuPai;
	}

	public String getNomePagina() {
		return nomePagina;
	}

	public void setNomePagina(String nomePagina) {
		this.nomePagina = nomePagina;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
