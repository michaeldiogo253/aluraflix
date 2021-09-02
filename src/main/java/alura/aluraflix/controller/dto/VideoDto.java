package alura.aluraflix.controller.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import alura.aluraflix.model.Video;

public class VideoDto {

	private Long id;
	private String titulo;
	private String descricao;
	private String url;
	private Long categoriaId;

	public VideoDto(Video video) {

		this.id = video.getId();
		this.titulo = video.getTitulo();
		this.descricao = video.getDescricao();
		this.url = video.getUrl();
		this.categoriaId = video.getCategoria().getId();
	}

	public VideoDto(Long id, String titulo, String descricao, String url, Long categoriaId) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.url = url;
		this.categoriaId = categoriaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

//
//	public static List<VideoDto> converterVideosEmVideoDto(List<Video> video) {
//
//		return video.stream().map(VideoDto::new).collect(Collectors.toList());
//	}

	public static List<VideoDto> paraListaDto(List<Video> lista) {
		List<VideoDto> listaConvertida = new ArrayList<VideoDto>();

		lista.forEach((Video v) -> {
			listaConvertida.add(
					new VideoDto(v.getId(), v.getTitulo(), v.getDescricao(), v.getUrl(), v.getCategoria().getId()));
		});

		return listaConvertida;
	}

	public static VideoDto ConverterVideoEmVideoDto(Video v) {
		return new VideoDto(v.getId(), v.getTitulo(), v.getDescricao(), v.getUrl(), v.getCategoria().getId());
	}

	public static Page<VideoDto> converterPageDto(Page<Video> paginasVideo) {

		return paginasVideo.map(VideoDto::new);
	}

}
