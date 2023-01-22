package br.com.caesar.controller;

import br.com.caesar.model.Message;
import br.com.caesar.utils.Console;

public class MenuMain extends Menu {

	private MenuEncrypt menuEncrypt;
	private MenuDecrypt menuDecrypt;

	public MenuMain() {
		super(null);
		this.menuEncrypt = new MenuEncrypt(this);
		this.menuDecrypt = new MenuDecrypt(this);
	}

	/**
	 * Carrega a tela inicial do programa
	 * @param message {@link Message} Mensage de erro ou informação de chamadas anteriores
	 */
	@Override
	public void init(Message message) {
		Console.printHeader();
		Console.printWelcomeScreen(message);

		boolean invalidOption = false;
		String selecao = "";

		do {
			if (invalidOption) {
				Console.clear();
				Message alert =  Message.alert("Informe uma opção válida");
				Console.printHeader();
				Console.printWelcomeScreen(alert);
			}

			System.out.print("  Selecione uma opção: ");

			selecao = ENTRADA.nextLine();
			invalidOption = isInvalidOption(selecao);
		} while (isInvalidOption(selecao));

		Console.clear();

		MenuOption option = MenuOption.of(selecao);

		switch (option) {
			case ENCRYPT:
				this.menuEncrypt.init();
				break;
			case DECRYPT:
				this.menuDecrypt.init();
				break;
			case BACK:
			case EXIT:
				exit();
				break;
			default:
				Console.clear();
				init();

				break;
			}
	}

	/**
	 * Checa se a instrução informada pelo usuário corresponde a algumas das possíveis no menu principal
	 * @param option {@link String} Instrução informada pelo usuário
	 * @return {@literal boolean} <code>true</code> se é uma opção válida, <code>false</code> caso contrário
	 */
	private boolean isInvalidOption(String option) {
		return !MenuOption.exists(option);
	}

}