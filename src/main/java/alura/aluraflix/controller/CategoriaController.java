package alura.aluraflix.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import alura.aluraflix.controller.dto.CategoriaDto;
import alura.aluraflix.controller.dto.VideoDto;
import alura.aluraflix.controller.form.AtualizacaoCategoriaForm;
import alura.aluraflix.controller.form.CategoriaForm;
import alura.aluraflix.service.CategoriaService;
import alura.aluraflix.service.VideoService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	VideoService videoService;

	private static final int quantitadeItensPorPagina = 5;

	@GetMapping()
	@Transactional
	@Cacheable(value = "paginaDeCategorias")
	public ResponseEntity<Page<CategoriaDto>> listarCategorias(@RequestParam int pagina) {

		Pageable paginacao = PageRequest.of(pagina, quantitadeItensPorPagina);

		return categoriaService.listarCategorias(paginacao);

	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<?> buscarCategoria(@PathVariable Long id) {

		return categoriaService.buscarCategoriaId(id);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm form,
			UriComponentsBuilder uriBuilder) {

		return categoriaService.cadastrar(form, uriBuilder);

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CategoriaDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoCategoriaForm form) {

		return categoriaService.atualizar(id, form);

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {

		return categoriaService.remover(id);
	}

	@GetMapping("/{id}/videos")
	ResponseEntity<Page<VideoDto>> buscaVideoPorcategoria(@PathVariable Long id, @RequestParam int pagina) {

		Pageable paginacao = PageRequest.of(pagina, quantitadeItensPorPagina);

		return videoService.listarVideosPorCategoria(id, paginacao);

	}

}
