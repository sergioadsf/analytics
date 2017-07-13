package br.com.analytics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuario")
public class Usuario extends Entidade<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "senha", nullable = false)
	private String senha;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "email", nullable = false)
	private String email;

	@ManyToOne
	@JoinColumn(name = "id_perfil_usuario")
	private PerfilUsuario perfil;

	@Transient
	private String token;

	public Usuario() {
	}

	public Usuario(Long id) {
		super();
		this.id = id;
	}

	public Usuario(Long id, String senha, String token) {
		super();
		this.id = id;
		this.senha = senha;
		this.token = token;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getSenha() {

		return senha;
	}

	public void setSenha(String senha) {

		this.senha = senha;
	}

	public String getToken() {

		return token;
	}

	public void setToken(String token) {

		this.token = token;
	}

	public PerfilUsuario getPerfil() {

		return perfil;
	}

	public void setPerfil(PerfilUsuario perfil) {

		this.perfil = perfil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}