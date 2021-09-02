package alura.aluraflix.service;

import java.net.URI;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import alura.aluraflix.controller.dto.RespostaDoMetodoDeletarDto;
import alura.aluraflix.controller.dto.VideoDto;
import alura.aluraflix.controller.form.AtualizacaoVideoForm;
import alura.aluraflix.controller.form.VideoForm;
import alura.aluraflix.exception.ResourceNotFoundException;
import alura.aluraflix.model.Video;
import alura.aluraflix.repository.CategoriaRepository;
import alura.aluraflix.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	VideoRepository videoRepository;

	@Autowired
	CategoriaRepository categoriaRepository;

	public Page<VideoDto> listarTodosOsVideos(String pesquisa, Pageable paginacao) {

		Page<Video> busca;

		if (pesquisa == null) {
			busca = videoRepository.findAll(paginacao);
		} else {
			busca = videoRepository.findVideosPorTitulo(pesquisa, paginacao);
		}

		return VideoDto.converterPageDto(busca);
	}

	public ResponseEntity<?> buscarVideoPorId(Long id) {

		Optional<Video> video = videoRepository.findById(id);

		if (video.isPresent()) {
			return ResponseEntity.ok(new VideoDto(video.get()));
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new RespostaDoMetodoDeletarDto("Video não encontrado!"));
	}

	public ResponseEntity<VideoDto> cadastrarVideo(VideoForm form, UriComponentsBuilder uriBuilder) {

		Video video = form.converterComCategoria(videoRepository, categoriaRepository);
		videoRepository.save(video);

		URI uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();

		return ResponseEntity.created(uri).body(new VideoDto(video));
	}

	public ResponseEntity<VideoDto> atualizarVideo(Long id, AtualizacaoVideoForm form) {

		try {
			Video video = videoRepository.findById(id).get();
			form.atualiza(video, categoriaRepository);

			return ResponseEntity.ok(VideoDto.ConverterVideoEmVideoDto(video));

		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException("id do vídeo é inválido");
		}
// poderia ser implementado assim tambem
//		Optional<Video> optional = videoRepository.findById(id);
//		if (optional.isPresent()) {
//			Video video = form.atualizar(id, videoRepository);
//			return ResponseEntity.ok(new VideoDto(video));
//		}
//
//		return ResponseEntity.notFound().build();

	}

	public ResponseEntity<?> remover(Long id) {

		Optional<Video> optional = videoRepository.findById(id);
		if (optional.isPresent()) {
			videoRepository.deleteById(id);
			return ResponseEntity.ok(new RespostaDoMetodoDeletarDto("Video deletado com sucesso!"));
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new RespostaDoMetodoDeletarDto("Video não encontrado!"));
	}

	public ResponseEntity<Page<VideoDto>> listarVideosPorCategoria(Long id, Pageable paginacao)
			throws ResourceNotFoundException {

		Page<Video> busca = videoRepository.findByCategoria_Id(id, paginacao);
		if (busca.isEmpty()) {
			throw new ResourceNotFoundException("Videos não encontrados para o Id categoria informado...");
		}
		return ResponseEntity.ok(VideoDto.converterPageDto(busca));

	}

	public Page<VideoDto> listarUltimosVideos(Pageable paginacao) {
		Page<Video> busca = videoRepository.findAll(paginacao);
		return VideoDto.converterPageDto(busca);
	}

}
