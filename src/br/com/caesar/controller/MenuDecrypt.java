package br.com.caesar.controller;

import static java.util.Objects.nonNull;

import br.com.caesar.model.Message;
import br.com.caesar.service.CryptoService;
import br.com.caesar.utils.Console;
import br.com.caesar.utils.Utils;

public class MenuDecrypt extends Menu {

  private final CryptoService cryptoService;

  public MenuDecrypt(Menu parentMenu) {
    super(parentMenu);
    this.cryptoService = new CryptoService();
  }

  @Override
  public void init(Message message) {
    if (nonNull(message)) {
      Console.clear();
      Console.printHeader();
      System.out.print(message.getContent());
    } else {
      Console.printHeader();
    }

    Console.printDecryptoScreen();

    int interacoes = 0;
    String inputPhrase;
    String inputPositions;

    System.out.print("  Informe o texto a ser descriptografado: ");
    inputPhrase = ENTRADA.nextLine();

    checkComeBackOption(inputPhrase);

    do {
      Console.clear();
      Console.printHeader();

      if (interacoes > 0) {
        Message alert = Message.alert("Informe um número válido");
        Console.printDecryptoScreen(alert);
      } else {
        Console.printDecryptoScreen();
      }

      System.out.print("  Informe a quantidade de casas: ");
      inputPositions = ENTRADA.nextLine();

      checkComeBackOption(inputPositions);
      interacoes++;

    } while (!Utils.isNumeric(inputPositions));

    int positions = Integer.parseInt(inputPositions);
    String encryptedPhrase = cryptoService.decrypt(inputPhrase, positions);

    StringBuilder infos = new StringBuilder("  Texto informado: \n");

    infos.append("  \"" + inputPhrase+"\"\n\n");
    infos.append("  Texto decifrado: \n  \""+encryptedPhrase+"\"");

    init(Message.info(infos.toString()));
  }
}
