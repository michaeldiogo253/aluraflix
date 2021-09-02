package alura.aluraflix.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import alura.aluraflix.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
}
