package br.com.caesar.utils;

import br.com.caesar.model.Message;

public class Console {

	private static final String EMPTY_DELIMITER = "|                                                                  |\n";
	private static final String TITLE_DELIMITER = "\n#==================================================================#\n";
	private static final String BLOCK_DELIMITER = "\n#------------------------------------------------------------------#\n";

	private static final int SCREEN_SIZE = EMPTY_DELIMITER.length() - 2;

	private Console() {}

	/**
	 * Limpa o console
	 */
	public static void clear() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void printHeader() {
		StringBuilder header = new StringBuilder(TITLE_DELIMITER);

		header.append("|                ----- C A E S A R    C R Y P T -----              |\n");
		header.append("|            Utilitario para criptografia de Julio Cesar           |");
		header.append(TITLE_DELIMITER);

		System.out.print(header);
	}

	/**
	 * Printa a tela inicial do programa com uma mensagem de validação
	 * @param message {@link Message} Objeto contendo mensagem a ser inserida
	 */
	public static void printWelcomeScreen(Message message) {
		StringBuilder welcome = new StringBuilder(BLOCK_DELIMITER);

		welcome.append("|                  ----- B E M - V I N D O -----                   |\n");

		if (message != null) {
			welcome.append(EMPTY_DELIMITER);
			inserMessage(welcome, message, true);
		}

		welcome.append(EMPTY_DELIMITER);
		welcome.append("|   1  -> Criptografar                                             |\n");
		welcome.append("|   2  -> Descriptografar                                          |\n");
		welcome.append("|   0  -> Voltar                                                   |\n");
		welcome.append("|   00 -> Sair                                                     |\n");
		welcome.append(BLOCK_DELIMITER);

		System.out.print(welcome);
	}

	/**
	 * Printa a tela do menu de criptografia (Menu 1)
	 */
	public static void printCryptoScreen() {
		printCryptoScreen(null);
	}

	/**
	 * Printa a tela do menu de criptografia (Menu 1)
	 * @param message {@link Message} Objeto contendo mensagem a ser inserida
	 */
	public static void printCryptoScreen(Message message) {
		StringBuilder crypto = new StringBuilder(BLOCK_DELIMITER);

		crypto.append("|                ----- C R I P T O G R A F I A -----               |\n");
		crypto.append("|               0 (zero) para voltar ao menu principal             |");

		if (message != null) {
			crypto.append("\n");
			inserMessage(crypto, message);
		}

		crypto.append(BLOCK_DELIMITER);

		System.out.print(crypto);
	}

	/**
	 * Printa a tela do menu de descriptografia (Menu 2)
	 */
	public static void printDecryptoScreen() {
		printDecryptoScreen(null);
	}

	/**
	 * Printa a tela do menu de descriptografia (Menu 2)
	 * @param message {@link Message} Objeto contendo mensagem a ser inserida
	 */
	public static void printDecryptoScreen(Message message) {
		StringBuilder decrypto = new StringBuilder(BLOCK_DELIMITER);

		decrypto.append("|             ----- D E S C R I P T O G R A F I A -----            |\n");
		decrypto.append("|               0 (zero) para voltar ao menu principal             |");

		if (message != null) {
			decrypto.append("\n");
			inserMessage(decrypto, message);
		}

		decrypto.append(BLOCK_DELIMITER);

		System.out.print(decrypto);
	}

	/** UTILS **/

	/**
	 * Insere uma mensagem num objeto de texto do console (cabeçalhos)
	 * @param console {@link StringBuilder} Objeto de texto que representa o cabeçalho
	 * @param message {@link Message} Objeto contendo dados da mensagem
	 */
	private static void inserMessage(StringBuilder console, Message message) {
		inserMessage(console, message, false);
	}

	/**
	 * Insere uma mensagem num objeto de texto do console (cabeçalhos)
	 * @param console {@link StringBuilder} Objeto de texto que representa o cabeçalho
	 * @param message {@link Message} Objeto contendo dados da mensagem
	 * @param addEndBreak {@literal boolean} <code>true</code> para adicionar uma quebra de linha, <code>false</code> caso contrário
	 */
	private static void inserMessage(StringBuilder console, Message message, boolean addEndBreak) {

		StringBuilder finalMessage = new StringBuilder();

		int diference = (SCREEN_SIZE - message.getFullContent().length());
		int balance = diference /2;

		if (balance > 0) {
			String spaces = spaces(balance);
			finalMessage.append(spaces).append(message.getFullContent()).append(spaces);

			if (finalMessage.length() < (SCREEN_SIZE)) {
				finalMessage.append(spaces(SCREEN_SIZE - finalMessage.length()));
			}
		} else if (balance == 0) {
			finalMessage.append(message.getFullContent());
		}

		console.append(finalMessage).append(addEndBreak ? "\n" : "");
	}

	/**
	 * Retorna um texto contendo apenas espaços na quantidade informada. <br>
	 * Para uso na manipulação de mensagens ao usuário inseridas nos cabeçalhos
	 * @param size {@literal int} Quantidade de espaços no texto retornado
	 * @return {@link String}
	 */
	private static String spaces(int size) {
		return new String(new char[size]).replace("\0", " ");
	}
}