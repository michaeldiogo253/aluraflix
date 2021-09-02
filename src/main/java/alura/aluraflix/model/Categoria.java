package alura.aluraflix.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "categorias", uniqueConstraints = { @UniqueConstraint(columnNames = "titulo") })
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;
	@Column(nullable = false, length = 100)
	private String titulo;
	@Column(nullable = false, length = 10) // talvez 7 seja melhor
	private String cor;

	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
	private List<Video> video;

	public Categoria() {

	}

	public Categoria(@NotEmpty String titulo, @NotEmpty String cor) {

		this.titulo = titulo;
		this.cor = cor;
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

	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}

}
