package br.com.caesar.controller;

import static java.util.Objects.nonNull;

import br.com.caesar.model.Message;
import br.com.caesar.utils.Console;
import java.util.Scanner;

public abstract class Menu {

  protected static final Scanner ENTRADA = new Scanner(System.in);

  protected Menu parentMenu;

  public Menu(Menu parentMenu) {
    this.parentMenu = parentMenu;
  }

  public void init() {
    init(null);
  }

  public abstract void init(Message message);

  public void exit() {
    ENTRADA.close();
    Console.printHeader();

    System.out.println("  Obrigado pela visita. Até mais ó/");
    System.exit(0);
  }

  protected void checkComeBackOption(String input) {
    checkComeBackOption(input, true);
  }

  protected void checkComeBackOption(String input, boolean clearScreen) {
    MenuOption option = MenuOption.of(input);

    if (MenuOption.EXIT == option)
      exit();

    if (MenuOption.BACK == option) {
      if (clearScreen) {
        Console.clear();
      }

      if (nonNull(this.parentMenu)) {
        this.parentMenu.init();
      }
    }
  }

}
