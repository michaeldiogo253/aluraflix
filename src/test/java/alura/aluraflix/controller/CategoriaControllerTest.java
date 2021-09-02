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
//class CategoriaControllerTest {
//
//	@Autowired
//	MockMvc mock;
//
//	@Test
//	void deveriaRetornar200aoBuscarTodasAsCategorias() throws Exception {
//
//		URI uri = new URI("/categorias");
//		mock.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().is(200));
//
//	}
//
//	// este teste falha depois de exdecutado uam vez pois o titulo é unique no BD
////	@Test
////	public void deveriaRetornar201aoCadastrarCategoria() throws Exception {
////		URI uri = new URI("/categorias");
////		String json = "{\r\n" + "    \"titulo\": \"standup\",\r\n" + "    \"cor\":  \"amarelo\"\r\n" + "}";
////
////		mock.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
////				.andExpect(MockMvcResultMatchers.status().is(201));
////	}
//
//	@Test
//	public void deveriaRetornar400aoCadastrarCategoriaComCamposEmBrancos() throws Exception {
//		URI uri = new URI("/categorias");
//		String json = "{\r\n" + "    \"titulo\": \"\",\r\n" + "    \"cor\":  \"\"\r\n" + "}";
//
//		mock.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().is(400));
//
//	}
//
//	@Test
//	public void deveriarRetornar200AoBuscarCategoriaPeloID() throws Exception {
//
//		URI uri = new URI("/categorias/1");
//		mock.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().is(200));
//	}
//
//	@Test
//	public void deveriarRetornar404AoBuscarCategoriaPeloIDInvalido() throws Exception {
//
//		URI uri = new URI("/categorias/9999");
//		mock.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().is(404));
//	}
//
//	@Test
//	public void deveriaRetornar200aoAtualizarCategoria() throws Exception {
//		URI uri = new URI("/categorias/4");
//		String json = "{\r\n" + "    \"titulo\":\"Novelas atualizado\",\r\n" + "    \"cor\":\"Rosa\"\r\n" + "\r\n"
//				+ "}";
//
//		mock.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().is(200));
//	}
//
//	@Test
//	public void deveriaRetornar400aoAtualizarCategoriaComIdInvalido() throws Exception {
//		URI uri = new URI("/categorias/100000");
//		String json = "{\r\n" + "    \"titulo\":\"Novelas\",\r\n" + "    \"cor\":\"Rosa\"\r\n" + "\r\n" + "}";
//
//		mock.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().is(404));
//	}
//
//	@Test
//	public void deveriaRetornar404aoAtualizarCategoriaComCamposEmBranco() throws Exception {
//		URI uri = new URI("/categorias/4");
//		String json = "  \"titulo\":\"\",\r\n" + "  \"cor\":\"\"\r\n";
//
//		mock.perform(MockMvcRequestBuilders.put(uri).content(json).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().is(400));
//	}
//
//	@Test
//	public void deveriaRetornar404AoDelatarCategoriaComIDInvalido() throws Exception {
//		URI uri = new URI("/categorias/1000009990");
//
//		mock.perform(MockMvcRequestBuilders.delete(uri)).andExpect(MockMvcResultMatchers.status().is(404));
//
//	}
//
//	@Test
//	void deveriaRetornar200aoBuscarTodasOsVideosPelaCategorias1() throws Exception {
//
//		URI uri = new URI("/categorias/1/videos");
//		mock.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().is(200));
//
//	}
//
//	@Test
//	void deveriaRetornar400aoBuscarTodasOsVideosPelaCategoriasInvalida() throws Exception {
//
//		URI uri = new URI("/categorias/19099271/videos");
//		mock.perform(MockMvcRequestBuilders.get(uri)).andExpect(MockMvcResultMatchers.status().is(400));
//
//	}
//
//}
