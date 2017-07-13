package br.com.analytics.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.analytics.entity.Usuario;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

	@Query(value = "select u.id, u.senha, u.perfil.id from Usuario u where u.email = ':email' and u.senha =':senha'", nativeQuery = false)
	public Usuario findPorLoginSenha(@Param("email") String email, @Param("senha") String senha);

	//	@Query(value = "select u from Usuario u where colaborador.id = :idColaborador", nativeQuery = false)
//	public Usuario findPorColaborador(@Param("idColaborador") Long idColaborador);

	@Query(value = "select u.id from Usuario as u where u.email = ':email'", nativeQuery = false)
	public Usuario findPorEmail(@Param("email") String email);

}
