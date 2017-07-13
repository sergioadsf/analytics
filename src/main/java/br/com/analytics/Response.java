package br.com.analytics;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Response<T extends Object> implements Serializable {

	private final Boolean sucesso;

	private final String mensagem;

	private final T objetoRetorno;

	public Response(Boolean sucesso) {
		this(sucesso, "", null);
	}
	
	public Response(Boolean sucesso, T objetoRetorno) {
		this(sucesso, "", objetoRetorno);
	}

	public Response(Boolean sucesso, String mensagem) {
		this(sucesso, mensagem, null);
	}

	public Response(Boolean sucesso, String mensagem, T objetoRetorno) {
		super();
		this.sucesso = sucesso;
		this.mensagem = mensagem;
		this.objetoRetorno = objetoRetorno;
	}

	public Boolean getSucesso() {
		return sucesso;
	}

	public String getMensagem() {
		return mensagem;
	}

	public Object getObjetoRetorno() {
		return objetoRetorno;
	}

}
