package alura.aluraflix.controller.dto;

import org.springframework.data.domain.Page;

import alura.aluraflix.model.Categoria;

public class CategoriaDto {

	private Long id;
	private String titulo;
	private String cor;

	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.titulo = categoria.getTitulo();
		this.cor = categoria.getCor();
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

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public static Page<CategoriaDto> converterCategoriaEmCategoriaDto(Page<Categoria> categoria) {

		return categoria.map(CategoriaDto::new);
	}

}
