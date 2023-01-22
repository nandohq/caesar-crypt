package br.com.caesar.model;

public enum MessageLevel {

	/**
	 * Informações gerais ao usuário
	 */
	INFO("Info", "( ! ) "),

	/**
	 * Alertas ao usuário
	 */
	WARN("Warn", "/!\\ "),

	/**
	 * Notificação de erro ao usuário
	 */
	ERROR("Error", "( X ) ");

	private final String description;
	private final String symbol;

	private MessageLevel (String description, String symbol) {
		this.description = description;
		this.symbol = symbol;
	}

	public String description() {
		return description;
	}

	public String symbol() {
		return symbol;
	}
}