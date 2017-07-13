package br.com.analytics.repository;
//package br.com.analytics.repository;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import br.com.arquitetura.repository.Dao;
//import br.com.analytics.entity.Usuario;
//
//@Repository
//public class UsuarioDAO {
//
//	@Autowired
//	private Dao dao;
//
//	public Usuario findPorLoginSenha(String email, String senha) {
//
//		Class<Usuario> class1 = Usuario.class;
//
//		StringBuilder stringBuilder = new StringBuilder();
//		stringBuilder.append(
//				"select new br.com.vitae.bus.entity.Usuario(id, senha, primeiroAcesso, perfil.id, colaborador.id, colaborador.pessoa.id, ");
//		stringBuilder.append(
//				" colaborador.pessoa.nome, colaborador.pessoa.cpfCnpj, colaborador.empresa.id, colaborador.empresa.nome) ");
//		stringBuilder.append("from ");
//		stringBuilder.append(class1.getName());
//		stringBuilder.append(" where colaborador.pessoa.email = '");
//		stringBuilder.append(email);
//		stringBuilder.append("' and senha = '");
//		stringBuilder.append(senha);
//		stringBuilder.append("'");
//		return dao.consultar(stringBuilder.toString(), class1);
//	}
//
//	public Usuario findPorColaborador(Long idColaborador) {
//
//		Class<Usuario> class1 = Usuario.class;
//		String hql = String.format("from %s where colaborador.id = %s ", class1.getName(), idColaborador);
//		return dao.consultar(hql, class1);
//	}
//
//	public Usuario findPorEmail(String email) {
//
//		StringBuilder stringBuilder = new StringBuilder();
//		stringBuilder.append(" select new br.com.vitae.bus.entity.Usuario(u.id, colab.id, pes.id, pes.nome) from ");
//		stringBuilder.append(Usuario.class.getName());
//		stringBuilder.append(" as u ");
//		stringBuilder.append(" join u.colaborador as colab ");
//		stringBuilder.append(" join colab.pessoa as pes ");
//		stringBuilder.append(" where pes.email = '");
//		stringBuilder.append(email);
//		stringBuilder.append("'");
//		return dao.consultar(stringBuilder.toString(), Usuario.class);
//	}
//
//	public List<Usuario> listarEnviarEmailUsuarioCriado() {
//
//		Class<Usuario> class1 = Usuario.class;
//
//		StringBuilder sql = new StringBuilder();
//		sql.append("select new br.com.vitae.bus.entity.Usuario(id, colaborador.id, colaborador.pessoa.id, ");
//		sql.append(" colaborador.pessoa.nome, colaborador.pessoa.email) ");
//		sql.append("from ");
//		sql.append(class1.getName());
//		sql.append(" where emailEnviado =  ");
//		sql.append(Boolean.FALSE);
//
//		return dao.listar(sql.toString(), class1);
//	}
//
//	public List<Usuario> listarCombo() {
//
//		StringBuilder stringBuilder = new StringBuilder();
//		stringBuilder.append(" select new br.com.vitae.bus.entity.Usuario(u.id, colab.id, pes.id, pes.nome) from ");
//		stringBuilder.append(Usuario.class.getName());
//		stringBuilder.append(" as u ");
//		stringBuilder.append(" join u.colaborador as colab ");
//		stringBuilder.append(" join colab.pessoa as pes ");
//		stringBuilder.append(" where colab.ativo = ");
//		stringBuilder.append(Boolean.TRUE);
//		return dao.listar(stringBuilder.toString(), Usuario.class);
//	}
//}
