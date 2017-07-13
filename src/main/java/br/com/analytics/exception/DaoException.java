package br.com.analytics.exception;


@SuppressWarnings("serial")
public class DaoException extends Exception {

	/**
	 * Construtor da classe DaoException.java
	 * @param msg - {@link String}
	 */
	public DaoException(String msg) {
		super(msg);
	}
	
	/**
	 * Construtor da classe DaoException.java
	 * @param msg - {@link String}
	 * @param ex - {@link Exception}
	 */
	public DaoException(String msg, Exception ex) {
		super(msg, ex);
	}
}