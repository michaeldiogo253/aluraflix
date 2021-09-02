package alura.aluraflix.controller.dto;

public class ResourceNotFoundDto {

	
	private String erro;

	public ResourceNotFoundDto( String erro) {
		
		this.erro = erro;
	}


	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}
