package alura.aluraflix.controller.dto;

public class RespostaDoMetodoDeletarDto {

	private String mensagem;

	public RespostaDoMetodoDeletarDto(String mensagem) {

		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
