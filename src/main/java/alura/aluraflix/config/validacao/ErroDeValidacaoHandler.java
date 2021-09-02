package alura.aluraflix.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import alura.aluraflix.controller.dto.ErroDeFormularioDto;
import alura.aluraflix.exception.ResourceNotFoundException;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception) {
		List<ErroDeFormularioDto> dto = new ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), mensagem);
			dto.add(erro);
		});
		return dto;
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(TransactionException.class)
	public String excecaoBancoDados(TransactionException exception) {
		String erro = exception.getMessage();

		return erro;
	}

	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UnexpectedRollbackException.class)
	public String excecaoBancoDadosRollback(UnexpectedRollbackException exception) {
		String erro = exception.getMessage();

		return erro;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ResourceNotFoundException.class)
	public String excecaoRecursoNãoEncontrado(ResourceNotFoundException exception) {
		String erro = exception.getMessage();

		return erro;
	}
	
}
