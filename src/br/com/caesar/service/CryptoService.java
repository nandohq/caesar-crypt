package br.com.caesar.service;

import static br.com.caesar.utils.Utils.reverseSignal;

import br.com.caesar.utils.Utils;

public class CryptoService {

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private static final int TOTAL_LETTERS = ALPHABET.length();

	/**
	 * Decifra uma frase qualquer usando a metodologia de Júlio César
	 * @param encryptedPhrase {@link String} Texto que se deseja decifrar
	 * @param positions {@literal int} Quantidade de casas usada pela criptografia
	 * @return {@link String} Frase decifrada
	 */
	public String decrypt(String encryptedPhrase, int positions) {
		return handleText(encryptedPhrase, positions, false);
	}

	/**
	 * Cifra uma frase qualquer usando a metodologia de Júlio César
	 * @param phrase {@link String} Texto que se deseja cifrar
	 * @param positions {@literal int} Quantidade de casas usada pela criptografia
	 * @return {@link String} Frase decifrada
	 */
	public String encrypt(String phrase, int positions) {
		return handleText(phrase, positions, true);
	}

	/**
	 * Analisa e processa um texto qualquer para cifragem/decifragem usando o método de Júlio César
	 * @param phrase {@link String} Frase que se deseja processar
	 * @param positions {@literal int} Quantidade de casas a ser usada no processo de cifragem/decifragem
	 * @param encrypt {@literal} <code>true</code> se a frase será cifrada, <code>false</code> caso será decifrada
	 * @return {@link String} Frase processada
	 */
	private String handleText(String phrase, int positions, boolean encrypt) {
		StringBuilder handledPhrase = new StringBuilder();
		phrase = phrase.toLowerCase();

		for (int index = 0; index < phrase.length(); index++) {
			Character character = phrase.charAt(index);
			handledPhrase.append(getReplacement(String.valueOf(character), positions, encrypt));
		}

		return handledPhrase.toString();
	}

	/**
	 * Retorna uma letra em substituição à letra informada a partir de um número de posições
	 * @param letter {@link String} Letra que será substituída
	 * @param positions {@literal int} Número de posições a partir da qual uma nova letra será obtida
	 * @param forward {@literal boolean} <strong><code>true</code></strong> para contar as casas para frente, <strong><code>false</code></strong> para contar as casas para trás
	 * @return {@link String} Letra substituta retornada
	 */
	private String getReplacement(String letter, int positions, boolean forward) {

		/* Se a letra informada não for uma letra (espaço, ponto, número, barra...) retorna ela mesma */
		if (!Utils.isAlphabetic(letter))
			return letter;

		/* Obtém a posição da letra no alfabeto - a ordem começa em zero */
		int letterPosition = ALPHABET.indexOf(letter);

		/* Calcula a posição para obter a letra substituta com base nas casas informadas:
		 * - para criptografia, letra posterior à informada
		 * - para descriptografia, letra anterior à informada */
		int newLetterPosition = forward ? letterPosition + positions : letterPosition - positions;

		if (newLetterPosition >= 0) {
			newLetterPosition = newLetterPosition < 26 ? newLetterPosition : TOTAL_LETTERS - newLetterPosition;
		} else {
			newLetterPosition = TOTAL_LETTERS - reverseSignal(newLetterPosition);
		}

		return String.valueOf(ALPHABET.charAt(newLetterPosition < 0 ? reverseSignal(newLetterPosition) : newLetterPosition));
	}
}