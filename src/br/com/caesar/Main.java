package br.com.caesar;

import br.com.caesar.controller.MenuMain;
import br.com.caesar.model.Message;

public class Main {

	private static final MenuMain MENU_MAIN = new MenuMain();

	public static void main(String[] args) {
		try {
			MENU_MAIN.init();
		} catch (Exception e) {
			Message error = Message.error("Erro durante a execução. Reiniciando");
			MENU_MAIN.init(error);
		}
	}
}