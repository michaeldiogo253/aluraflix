package alura.aluraflix.controller.form;

import org.hibernate.validator.constraints.NotBlank;

import alura.aluraflix.model.Categoria;
import alura.aluraflix.repository.CategoriaRepository;

public class CategoriaForm {

	@SuppressWarnings("deprecation")
	@NotBlank
	private String titulo;

	@NotBlank
	private String cor;

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

	public Categoria converter() {
		return new Categoria(titulo, cor);
	}

	public Categoria atualizar(Long id, CategoriaRepository categoriaRepository) {

		return null;
	}

}
