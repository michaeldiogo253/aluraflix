package alura.aluraflix.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import alura.aluraflix.controller.dto.CategoriaDto;
import alura.aluraflix.controller.dto.RespostaDoMetodoDeletarDto;
import alura.aluraflix.controller.form.AtualizacaoCategoriaForm;
import alura.aluraflix.controller.form.CategoriaForm;
import alura.aluraflix.model.Categoria;
import alura.aluraflix.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public ResponseEntity<Page<CategoriaDto>> listarCategorias(Pageable paginacao) {

		Page<Categoria> busca = categoriaRepository.findAll(paginacao);

		return ResponseEntity.ok(CategoriaDto.converterCategoriaEmCategoriaDto(busca));

	}

	public ResponseEntity<?> buscarCategoriaId(Long id) {

		Optional<Categoria> optional = categoriaRepository.findById(id);

		if (optional.isPresent()) {
			return ResponseEntity.ok(new CategoriaDto(optional.get()));
		}
		Map<String, String> errors = new HashMap<>();
		errors.put("erro", "Categoria não encontrada");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);

	}

	public ResponseEntity<CategoriaDto> cadastrar(CategoriaForm form, UriComponentsBuilder uriBuilder) {

		try {
			Categoria categoria = form.converter();
			categoriaRepository.save(categoria);

			URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();

			return ResponseEntity.created(uri).body(new CategoriaDto(categoria));

		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	public ResponseEntity<CategoriaDto> atualizar(Long id, AtualizacaoCategoriaForm form) {

		Optional<Categoria> optional = categoriaRepository.findById(id);
		if (optional.isPresent()) {
			Categoria categoria = form.atualizar(id, categoriaRepository);
			return ResponseEntity.ok(new CategoriaDto(categoria));
		}

		return ResponseEntity.notFound().build();

	}

	public ResponseEntity<?> remover(Long id) {
		Optional<Categoria> optional = categoriaRepository.findById(id);

		if (optional.isPresent() && id != 1) {
			categoriaRepository.deleteById(id);
			return ResponseEntity.ok(new RespostaDoMetodoDeletarDto("Categoria deletado com sucesso!"));
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new RespostaDoMetodoDeletarDto("Video não encontrados!"));
	}

}
