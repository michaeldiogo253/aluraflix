package alura.aluraflix.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import alura.aluraflix.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

	Page<Video> findByCategoria_Id(Long id,Pageable paginacao);

	@Query("select v from Video v where v.titulo like %:pesquisa%")
	Page<Video> findVideosPorTitulo(String pesquisa, Pageable paginacao);

}
