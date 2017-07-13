package br.com.analytics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "papel")
public class Papel extends Entidade<Long> {

	private static final long serialVersionUID = 5802878901435306727L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Version
	@Column(name = "versao")
	private Long versao;

	@ManyToOne
	@JoinColumn(name = "id_perfil_usuario")
	private PerfilUsuario perfilUsuario;

	@OneToOne
	@JoinColumn(name = "id_menu", nullable = false)
	private Menu menu;

	@JoinColumn(name = "id_permissao")
	private Permissao permissao;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(final Long id) {
		this.id = id;
	}

	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(final PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	public Permissao getPermissao() {
		if (null == permissao) {
			permissao = new Permissao();
		}
		return permissao;
	}

	public void setPermissao(final Permissao permissao) {
		this.permissao = permissao;
	}

	public Long getVersao() {
		return versao;
	}

	public void setVersao(Long versao) {
		this.versao = versao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	// @Override
	// public String toString() {
	// return "Papel [id=" + id + ", perfilUsuario=" + perfilUsuario
	// + ", pagina=" + pagina + ", permissoes=" + permissao + "]";
	// }
	//
	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = super.hashCode();
	// result = prime * result + ((id == null) ? 0 : id.hashCode());
	// result = prime * result
	// + ((perfilUsuario == null) ? 0 : perfilUsuario.hashCode());
	// result = prime * result + ((versao == null) ? 0 : versao.hashCode());
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (!super.equals(obj))
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// Papel other = (Papel) obj;
	// if (id == null) {
	// if (other.id != null)
	// return false;
	// } else if (!id.equals(other.id))
	// return false;
	// if (perfilUsuario == null) {
	// if (other.perfilUsuario != null)
	// return false;
	// } else if (!perfilUsuario.equals(other.perfilUsuario))
	// return false;
	// if (versao == null) {
	// if (other.versao != null)
	// return false;
	// } else if (!versao.equals(other.versao))
	// return false;
	// return true;
	// }

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public int compareTo(final Papel o) {
		if ((null == o) || ((null == o.getMenu()) || (null == o.getMenu().getNome()))) {
			return -1;
		}
		if ((null == menu) || (null == menu.getNome())) {
			return -1;
		}
		return menu.getNome().compareTo(o.getMenu().getNome());
	}

}
