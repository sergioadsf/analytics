package br.com.analytics.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.analytics.entity.Papel;

@Repository
public interface PapelRepository extends PagingAndSortingRepository<Papel, Long> {

	@Query(value = "select pap from Papel pap where pap.perfilUsuario.id = :idPerfilUsuario and pap.menu.id = :idPagina", nativeQuery = false)
	public Papel listarPorPerfilPagina(@Param("idPerfilUsuario") Long idPerfilUsuario, @Param("idPagina") Long idPagina);

}
