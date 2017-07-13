package br.com.analytics.repository;
//package br.com.analytics.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import br.com.arquitetura.repository.Dao;
//import br.com.analytics.entity.Papel;
//import br.com.analytics.entity.Permissao;
//
//@Repository
//public class PermissaoDAO {
//
//	@Autowired
//	private Dao dao;
//
//	public Permissao consultarPermissao(Long idPerfilUsuario, Long idPagina) {
//		Class<Permissao> class1 = Permissao.class;
//		StringBuilder sb = new StringBuilder();
//
//		sb.append("select permissao from ");
//		sb.append(Papel.class.getName());
//		sb.append(" papel inner join papel.permissao as permissao where papel.perfilUsuario.id = ");
//		sb.append(idPerfilUsuario);
//		sb.append(" and papel.menu.id = " + idPagina);
//
//		return dao.consultar(sb.toString(), class1);
//	}
//	
//	public Permissao consultarPermissao(boolean visualizar, boolean inserir, boolean editar, boolean excluir) {
//		Class<Permissao> class1 = Permissao.class;
//		StringBuilder sb = new StringBuilder();
//
//		sb.append("from ");
//		sb.append(class1.getName());
//		sb.append(" permissao where permissao.visualiza = ").append(visualizar);
//		sb.append(" and permissao.insere = ").append(inserir);
//		sb.append(" and permissao.edita = ").append(editar);
//		sb.append(" and permissao.exclui = ").append(excluir);
//		
//		return dao.consultar(sb.toString(), class1);
//	}
//
//
//}
