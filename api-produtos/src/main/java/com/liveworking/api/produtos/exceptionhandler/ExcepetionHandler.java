package com.liveworking.api.produtos.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Controller
@ControllerAdvice
public class ExcepetionHandler extends ResponseEntityExceptionHandler {

	public static class Errors {
		private String msgUsuario;

		private String msgDesenvolvedor;

		public Errors(String msgUsuario, String msgDesenvolvedor) {
			super();
			this.msgUsuario = msgUsuario;
			this.msgDesenvolvedor = msgDesenvolvedor;
		}

		public String getMsgUsuario() {
			return msgUsuario;
		}

		public void setMsgUsuario(String msgUsuario) {
			this.msgUsuario = msgUsuario;
		}

		public String getMsgDesenvolvedor() {
			return msgDesenvolvedor;
		}

		public void setMsgDesenvolvedor(String msgDesenvolvedor) {
			this.msgDesenvolvedor = msgDesenvolvedor;
		}

	}

	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Errors> erros = Arrays
				.asList(new Errors(messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale()),
						ex.getCause() != null ? ex.getCause().toString() : ex.toString()));

		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		return handleExceptionInternal(ex,

				ListaErrors(ex.getBindingResult()), headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> HandlerEmptyResultDataAccessException(EmptyResultDataAccessException ex,
			WebRequest request) {

		return handlerException(ex,
				messageSource.getMessage("recurso.nao-encontrado", null, LocaleContextHolder.getLocale()),
				ex.toString(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler({ DataIntegrityViolationException.class })
	public ResponseEntity<Object> HandlerConstraintViolationException(DataIntegrityViolationException ex,
			WebRequest request) {

		return handlerException(ex,
				messageSource.getMessage("recurso.operacao-nao-permitida", null, LocaleContextHolder.getLocale()),
				ExceptionUtils.getRootCauseMessage(ex), HttpStatus.BAD_REQUEST, request);

	}

	private List<Errors> ListaErrors(BindingResult bindiResult) {
		List<Errors> erros = new ArrayList<>();

		for (FieldError erro : bindiResult.getFieldErrors()) {
			erros.add(new Errors(messageSource.getMessage(erro, LocaleContextHolder.getLocale()), erro.toString()));
		}

		return erros;
	}

	private ResponseEntity<Object> handlerException(RuntimeException ex, String msg_usuario, String msg_dsv,
			HttpStatus status, WebRequest request) {

		List<Errors> erros = Arrays.asList(new Errors(msg_usuario, msg_dsv));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), status, request);
	}
}
