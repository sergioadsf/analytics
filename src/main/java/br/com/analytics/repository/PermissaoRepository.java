package br.com.analytics.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.analytics.entity.Permissao;

@Repository
public interface PermissaoRepository extends PagingAndSortingRepository<Permissao, Long>{
	
	@Query(value = "select papel.permissao from Papel papel where papel.perfilUsuario.id = :idPerfilUsuario and papel.menu.id = :idPagina"
			, nativeQuery = false)
	public Permissao consultarPermissao(@Param("idPerfilUsuario") Long idPerfilUsuario, @Param("idPagina") Long idPagina);

	@Query(value = "select permissao from Permissao permissao where permissao.visualiza = :visualizar and permissao.insere = :inserir and permissao.edita = :editar and permissao.exclui = :excluir"
			, nativeQuery = false)
	public Permissao consultarPermissao(@Param("visualizar") boolean visualizar, @Param("inserir") boolean inserir, @Param("editar") boolean editar, @Param("excluir") boolean excluir);
}
