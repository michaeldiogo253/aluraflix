package alura.aluraflix.controller.form;

import java.util.NoSuchElementException;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import alura.aluraflix.exception.ResourceNotFoundException;
import alura.aluraflix.model.Categoria;
import alura.aluraflix.model.Video;
import alura.aluraflix.repository.CategoriaRepository;
import alura.aluraflix.repository.VideoRepository;

public class AtualizacaoVideoForm {

	@NotNull
	@NotEmpty
	private String titulo;
	@NotNull
	@NotEmpty
	private String descricao;
	@NotNull
	@NotEmpty
	private String url;

	private Long categoriaId;

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

//	public Video atualizar(Long id, VideoRepository videoRepository) {
//		Video video = videoRepository.findById(id).get();
//
//		// Video video = videoRepository.getOne(id); pode ser feito dos dois jeitos
//		video.setTitulo(this.titulo);
//		video.setDescricao(this.descricao);
//		video.setUrl(this.url);
//
//		return video;
//	}

	public void atualiza(Video video, CategoriaRepository categoriaRepository) throws ResourceNotFoundException {

		video.setTitulo(titulo);
		video.setDescricao(descricao);
		video.setUrl(url);
		video.setCategoria(verificaCategoria(categoriaRepository));

	}

	// metodo para verificar se a categoria esta correta ou laçar exceção
	private Categoria verificaCategoria(CategoriaRepository categoriaRepository) throws ResourceNotFoundException {
		if (this.categoriaId == null) {
			return categoriaRepository.findById(1l).get();
		} else {
			try {
				return categoriaRepository.findById(categoriaId).get();
			} catch (NoSuchElementException e) {
				throw new ResourceNotFoundException("Valor de categoriaId  invalido");
			}
		}
	}
	
	
}
