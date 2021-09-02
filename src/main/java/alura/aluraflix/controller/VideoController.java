package alura.aluraflix.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
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

import alura.aluraflix.controller.dto.VideoDto;
import alura.aluraflix.controller.form.AtualizacaoVideoForm;
import alura.aluraflix.controller.form.VideoForm;
import alura.aluraflix.service.VideoService;

@RestController
@RequestMapping("/videos")
public class VideoController {

	@Autowired
	VideoService videoService;

	private static final int quantitadeItensPorPagina = 5;

	@GetMapping("/free")
	@Transactional
	public Page<VideoDto> listarVideosParaUsuarioNãoAutenticado() {

		String ordenacao = "id";
		int pagina = 0;
		Pageable paginacao = PageRequest.of(pagina, quantitadeItensPorPagina, Direction.DESC, ordenacao);
		return videoService.listarUltimosVideos(paginacao);

	}

	
	@GetMapping
	@Transactional
	@Cacheable(value = "paginaDeVideos")
	public Page<VideoDto> listarVideos(@RequestParam(required = false) String search, @RequestParam int pagina) {

		Pageable paginacao = PageRequest.of(pagina, quantitadeItensPorPagina);
		return videoService.listarTodosOsVideos(search, paginacao);

	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<?> buscarVideoPorId(@PathVariable Long id) {

		return videoService.buscarVideoPorId(id);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<VideoDto> cadastrar(@RequestBody @Valid VideoForm form, UriComponentsBuilder uriBuilder) {

		return videoService.cadastrarVideo(form, uriBuilder);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VideoDto> atualizarVideo(@PathVariable Long id,
			@RequestBody @Valid AtualizacaoVideoForm form) {

		return videoService.atualizarVideo(id, form);

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {

		return videoService.remover(id);
	}

}
