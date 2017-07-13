package br.com.analytics.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "perfil_usuario")
public class PerfilUsuario extends Entidade<Long> {

	private static final long serialVersionUID = -6276329396951843755L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "acesso_servidor", nullable = false)
	private boolean acessoServidor;

	@Column(name = "nome_perfil", nullable = false)
	private String nomePerfil;

	@Version
	@Column(name = "versao")
	private Long versao;

	@OneToMany(mappedBy = "perfil")
	private List<Usuario> usuario;

	@OneToMany(mappedBy = "perfilUsuario"/* , cascade = CascadeType.ALL */)
	private List<Papel> papeis;

	public PerfilUsuario() {
	}

	public PerfilUsuario(String nome) {
		nomePerfil = nome;
	}

	public PerfilUsuario(final Long id) {
		this.id = id;
	}

	public PerfilUsuario(final Long id, String nome) {
		this.id = id;
		nomePerfil = nome;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(final Long id) {
		this.id = id;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(final List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public String getNomePerfil() {
		return nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

	public Long getVersao() {
		return versao;
	}

	public void setVersao(Long versao) {
		this.versao = versao;
	}

	public boolean isAcessoServidor() {
		return acessoServidor;
	}

	public void setAcessoServidor(boolean acessoServidor) {
		this.acessoServidor = acessoServidor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((versao == null) ? 0 : versao.hashCode());
		return result;
	}

}
