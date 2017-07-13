package br.com.analytics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.analytics.entity.Menu;

@Repository
public interface MenuRespository extends PagingAndSortingRepository<Menu, Long> {

	@Query(value = "select distinct menu.* from usuario usu "
			+ " inner join perfil_usuario pu on pu.id = usu.id_perfil_usuario"
			+ " inner join papel pap on pu.id = pap.id_perfil_usuario"
			+ " inner join permissao per on per.id = pap.id_permissao"
			+ " inner join menu menu on menu.id = pap.id_menu  where pu.id = :idPerfilUsuario"
			+ " and per.visualiza = true and ativo = true order by menu.id", nativeQuery = true)
	public List<Menu> listarMenu(@Param("idPerfilUsuario") Long idPerfilUsuario);

	@Query(value = "select m from papel pap inner join pap.menu menu "
			+ "where pap.perfilUsuario.id = :idPerfilUsuario and menu.nomePagina is not null", nativeQuery = true)
	public List<Menu> listarPaginaSelecionado(@Param("idPerfilUsuario") Long idPerfilUsuario);

	@Query(value = "select m from Menu m where m.id not in ( SELECT p.menu.id from Papel "
			+ " p where p.perfilUsuario.id=:idPerfilUsuario"+" ) and m.nomePagina is not null ", nativeQuery=false)
	public List<Menu> listarPaginaNaoSelecionado(@Param("idPerfilUsuario") Long idPerfilUsuario);
}
