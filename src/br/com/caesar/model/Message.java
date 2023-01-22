package br.com.caesar.model;

import static br.com.caesar.utils.Utils.isNotBlank;

import br.com.caesar.utils.Utils;

/**
 * Classe modelo para gestão das mensagens de erro e validação
 */
public class Message {

	private final String code;
	private final String content;
	private final MessageLevel level;

	public Message(String content, MessageLevel level) {
		this(content, "", level);
	}

	public Message(String content, String code, MessageLevel level) {
		this.code = isNotBlank(code) ? code +" - " : code;
		this.content = content;
		this.level = level;
	}

	public static Message info(String content) {
		return new Message(content, MessageLevel.INFO);
	}

	public static Message error(String content) {
		return new Message(content, MessageLevel.ERROR);
	}

	public static Message alert(String content) {
		return new Message(content, MessageLevel.WARN);
	}

	/**
	 * Tipo da mensagem
	 * @return {@link MessageLevel}
	 */
	public MessageLevel getLevel() {
		return level;
	}

	/**
	 * Retorna o código quando é uma mensagem de erro da API
	 * @return {@link String}
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Conteúdo da mensagem
	 * @return {@link String}
	 */
	public String getContent() {

		return content;
	}

	/**
	 * Conteúdo da mensagem, prefixada com o ícone do tipo
	 * @return {@link String}
	 */
	public String getFullContent() {
		if (level != null && Utils.isNotBlank(content))
			return level.symbol() + code + content;

		return content;
	}

}