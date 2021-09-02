//package alura.aluraflix.controller;
//
//import java.net.URI;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@ActiveProfiles("test")
//class VideoControllerTest {
//
//	@Autowired
//	MockMvc mock;
//
//	@Test
//	public void deveriaDevolver200AoListarTodosOsVideos() throws Exception {
//
//		URI uri = new URI("/videos");
//
//		mock.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().is(200));
//	}
//
//	@Test
//	public void deveriaDevolver200AoBuscarVideosPeloNomeRemix() throws Exception {
//
//		URI uri = new URI("/videos/?search=remix");
//
//		mock.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().is(200));
//	}
//
//	@Test
//	public void deveriaRetornar201aoCadastrarVideo() throws Exception {
//		URI uri = new URI("/videos");
//		String json = " {\r\n"
//				+ "    \"titulo\":\"Pica-Pau em Português | O velho oeste | Desenhos para crianças\",\r\n"
//				+ "    \"descricao\": \"Pica-Pau\",\r\n"
//				+ "    \"url\": \"https:https://www.youtube.com/watch?v=Yo2IjW-0Pyw\",\r\n"
//				+ "    \"categoriaId\":\"1\"\r\n" + "} ";
//
//		mock.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().is(201));
//
//	}
//
//	@Test
//	public void deveriaRetornar201aoCadastrarVideoSemCategoria() throws Exception {
//		URI uri = new URI("/videos");
//		String json = " {\r\n" + "    \"titulo\":\"teste titulo\",\r\n" + "    \"descricao\": \"teste descrição\",\r\n"
//				+ "    \"url\": \"https:https://wwhttps://www.youtube.com/watch?teste\"}";
//
//		mock.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().is(201));
//	}
//
//	@Test
//	public void deveriaRetornar400aoCadastrarVideoComCamposEmBrancos() throws Exception {
//		URI uri = new URI("/videos");
//		String json = " {\r\n" + "    \"titulo\":\"\",\r\n" + "    \"descricao\": \"\","
//				+ "    \"url\": \"http:teste\"}";
//
//		mock.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().is(400));
//	}
//
//	@Test
//	public void deveriarRetornar200AoBuscarVideoPeloID() throws Exception {
//
//		URI uri = new URI("/videos/1");
//		mock.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().is(200));
//	}
//
//	@Test
//	public void deveriarRetornar404AoBuscarVideoPeloIDInvalido() throws Exception {
//
//		URI uri = new URI("/vidoes/9999");
//		mock.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().is(404));
//	}
//
//	@Test
//	public void deveriaRetornar200aoAtualizarVideo() throws Exception {
//		URI uri = new URI("/videos/8");
//		String json = "{\r\n"
//				+ "\"titulo\":\"Hardwell feat. Amba Shepherd - United We Are (OUT NOW!) #UnitedWeAre ATUALIZADO\",\r\n"
//				+ "\"descricao\": \"Eletro ATUALIZADO\",\r\n"
//				+ "\"url\": \"https://www.youtube.com/watch?v=w98B_zsQW2w&list=RDw98B_zsQW2w&start_radio=1&ab_channel=Hardwell\",\r\n"
//				+ "\"categoriaId\":\"4\"\r\n" + "}";
//
//		mock.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().is(200));
//	}
//
//	@Test
//	public void deveriaRetornar400aoAtualizarVideoComIdInvalido() throws Exception {
//		URI uri = new URI("/videos/100000");
//		String json = "{ \"titulo\":\"teste titulo atualizado\", \"descricao\": \"teste descrição atualizada\","
//				+ "    \"url\": \"https:https://wwhttps://www.youtube.com/watch?teste-ATUALIZADO\"}";
//
//		mock.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().is(400));
//	}
//
//	@Test
//	public void deveriaRetornar404aoAtualizarVideoComCamposEmBranco() throws Exception {
//		URI uri = new URI("/videos/8");
//		String json = "{ \"titulo\":\"\", \"descricao\": \"\"," + "    \"url\": \"\"}";
//
//		mock.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().is(400));
//	}
//
//	// este teste irá falhar depois de deletar um video, pois como o id passado é o
//	// mesmo, já foi deletado
////	@Test
////	public void deveriaRetornar200AoDelatarVideoComIDExistente() throws Exception {
////		URI uri = new URI("/videos/11");
////
////		mock.perform(MockMvcRequestBuilders.delete(uri)).andExpect(MockMvcResultMatchers.status().is(200));
////
////	}
//
//	@Test
//	public void deveriaRetornar404AoDelatarVideoComIDInvalido() throws Exception {
//		URI uri = new URI("/videos/1000009990");
//
//		mock.perform(MockMvcRequestBuilders.delete(uri)).andExpect(MockMvcResultMatchers.status().is(404));
//
//	}
//
//}
