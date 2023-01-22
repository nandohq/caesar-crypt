package br.com.caesar.utils;

/**
 * Classe utilitária para auxílio nos demais processos do programa
 */
public class Utils {

	private Utils() {}

	/**
	 * Verifica se um texto informado é nulo, vazio ou contém apenas espaços
	 * @param word {@link String} Texto a ser verificado
	 * @return {@literal boolean} <code>true</code> se o texto for nulo, vazio ou contiver apenas espaços, <code>false</code> caso contrário
	 */
	public static boolean isBlank(String word) {
		return word == null || word.trim().isEmpty();
	}

	/**
	 * Verifica se um texto informado não é nulo, vazio ou não contém apenas espaços
	 * @param word {@link String} Texto a ser verificado
	 * @return {@literal boolean} <code>true</code> se o texto não for nulo, vazio ou não contiver apenas espaços, <code>false</code> caso contrário
	 */
	public static boolean isNotBlank(String word) {
		return !isBlank(word);
	}

	/**
	 * Verifica se um texto informado contém apenas letras
	 * @param word {@link String} Texto que se deseja verificar
	 * @return {@literal boolean} <code>true</code> se o texto só contiver letras, <code>false</code> caso contrário
	 */
	public static boolean isAlphabetic(String word) {
		if (isBlank(word))
			return false;

		return word.matches("[a-zA-Z]+");
	}

	/**
	 * Verifica se um texto informado contém apenas números
	 * @param number {@link String} Texto que se deseja verificar
	 * @return {@literal boolean} <code>true</code> se o texto só contiver números, <code>false</code> caso contrário
	 */
	public static boolean isNumeric(String number) {
		if (isBlank(number))
			return false;

		return number.chars().allMatch(Character::isDigit);
	}

	/**
	 * Inverte o sinal do número informado. Ex:<br>
	 * Se o número informado for -5, retorna 5. <br>
	 * Se o número informado for 7, retorna -7.
	 * @param number {@literal int} Número cujo sinal se deseja inverter
	 * @return {@literal int} Número com sinal invertido
	 */
	public static int reverseSignal(int number) {
		return number != 0 ? number - (number * 2) : number;
	}

}