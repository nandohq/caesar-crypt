package br.com.caesar.controller;

import br.com.caesar.utils.Utils;
import java.util.List;
import java.util.stream.Stream;

public enum MenuOption {

  ENCRYPT("1"), DECRYPT("2"), BACK("0"), EXIT("00");

  private final String number;

  MenuOption(String number) {
    this.number = number;
  }

  public String number() {
    return this.number;
  }

  public static MenuOption of(String number) {
    if (!Utils.isNumeric(number))
      return null;

    return Stream.of(MenuOption.values())
                  .filter(op -> op.number.equals(number))
                  .findFirst().orElse(null);
  }

  public static boolean exists(String number) {
    if (!Utils.isNumeric(number))
      return false;

    return numbers().contains(number);
  }

  public static List<String> numbers() {
    return Stream.of(MenuOption.values()).map(MenuOption::number).toList();
  }

}
