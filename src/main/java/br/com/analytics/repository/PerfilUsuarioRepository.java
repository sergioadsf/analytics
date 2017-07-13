package br.com.analytics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.analytics.entity.Papel;
import br.com.analytics.entity.PerfilUsuario;

@Repository
public interface PerfilUsuarioRepository extends PagingAndSortingRepository<PerfilUsuario, Long> {

	@Query("select p from PerfilUsuario p where p.id = :idPerfil")
	public List<Papel> listarPapeisId(@Param("idPerfil") Long idPerfil);

}
