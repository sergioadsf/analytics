package br.com.analytics.repository;
//package br.com.analytics.repository;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import br.com.arquitetura.repository.Dao;
//import br.com.analytics.entity.Papel;
//import br.com.analytics.entity.PerfilUsuario;
//
//@Repository
//public class PerfilUsuarioDAO {
//
//	@Autowired
//	private Dao dao;
//
//	public List<PerfilUsuario> listarPerfis() {
//		StringBuilder sb = new StringBuilder();
//		Class<PerfilUsuario> class1 = PerfilUsuario.class;
//		sb.append("select new br.com.vitae.bus.entity.PerfilUsuario(id, nomePerfil) from ");
//		sb.append(class1.getName());
//
//		return dao.listar(sb.toString(), class1);
//	}
//
//	public List<Papel> listarPapeisId(Long idPerfil) {
//		StringBuilder sb = new StringBuilder();
//		Class<Papel> class1 = Papel.class;
//		sb.append("from ").append(class1.getName());
//		sb.append(" where perfilUsuario.id = ").append(idPerfil);
//		return dao.listar(sb.toString(), class1);
//	}
//
//}
