package alura.aluraflix.controller.form;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import alura.aluraflix.model.Categoria;
import alura.aluraflix.repository.CategoriaRepository;

public class AtualizacaoCategoriaForm {

	@NotNull
	@NotEmpty
	private String titulo;
	@NotNull
	@NotEmpty
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

	public Categoria atualizar(Long id, CategoriaRepository categoriaRepository) {
		Categoria categoria = categoriaRepository.findById(id).get();

		categoria.setTitulo(this.titulo);
		categoria.setCor(cor);

		return categoria;
	}

}
