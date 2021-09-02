package alura.aluraflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import alura.aluraflix.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
