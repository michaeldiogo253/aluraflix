//package alura.aluraflix.model;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import alura.aluraflix.repository.CategoriaRepository;
//import alura.aluraflix.repository.VideoRepository;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class VideoTest {
//
//	// estes teste podem falhar facilmente, basta que os registros mudem no BD
//
//	@Autowired
//	private VideoRepository videoRepository;
//	@Autowired
//	private CategoriaRepository categoriaRepository;
//
//	@Test
//	public void deveriaCarregarUmVideoPeloId() {
//		Long id = 1L;
//		Video video = videoRepository.findById(id).get();
//		assertEquals(id, video.getId());
//		assertNotNull(video);
//	}
//
//	@Test
//	void verificaSeDescricaoDoVideoEIgualChapolin() {
//		String descricao = "Chapolin";
//		Video video = videoRepository.findById(5L).get();
//
//		assertEquals(descricao, video.getDescricao());
//
//	}
//
//}
