package main;

import utils.Colors;

import java.util.Scanner;

public class QuestionsUser {

  public final Scanner scanner = new Scanner(System.in);


  public void nameCompany(){
    System.out.println("                                                                                               " +
        "\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\n");
    System.out.println(Colors.TEXT_BLUE_BOLD_BRIGHT +
        "                                                                                                      NBA Comerce");
    System.out.println("\n                                                                                               " +
        "\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0\uD83C\uDFC0");

  }


  public int interfaceInicial() {
    System.out.println(Colors.TEXT_WHITE_BOLD_BRIGHT + "Log-in");
    System.out.println(Colors.TEXT_CYAN_BOLD_BRIGHT + "1 - Administrador");
    System.out.println(Colors.TEXT_YELLOW_BOLD_BRIGHT + "2 - Usuário");
    System.out.println(Colors.TEXT_RED_BOLD_BRIGHT + "3 - Sair");
    return scanner.nextInt();
  }

  public int menuPrincipalAdm() {
    System.out.println(Colors.TEXT_WHITE_BOLD_BRIGHT + "Escolha uma opção abaixo:");
    System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "1 - Adicionar Novo Produto!" + " \uD83C\uDD95");
    System.out.println(Colors.TEXT_PURPLE_BOLD_BRIGHT + "2 - Alterar Producto!");
    System.out.println(Colors.TEXT_RED_BOLD_BRIGHT + "3 - Remover Produto");
    System.out.println("4 - Sair");
    return scanner.nextInt();
  }

  public int menuPrincipalUser() {
    System.out.println(Colors.TEXT_WHITE_BOLD_BRIGHT + "Escolha uma opção abaixo:");
    System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "1 - Comprar" + " \uD83E\uDD11");
    System.out.println(Colors.TEXT_PURPLE_BOLD_BRIGHT + "2 - Olhar Carrinho" + " \uD83D\uDED2");
    System.out.println(Colors.TEXT_RED_BOLD_BRIGHT + "3 - Sair");
    return scanner.nextInt();
  }

  public int newProductSaleAdm() {
    System.out.println(Colors.TEXT_WHITE_BOLD_BRIGHT + "Escolha o Tipo de Produto:");
    System.out.println(Colors.TEXT_CYAN_BOLD_BRIGHT + "1 - Calça");
    System.out.println("2 - Shorts");
    System.out.println("3 - Tênis");
    System.out.println("4 - Camiseta");
    return scanner.nextInt();
  }

  public String[] informationsNewProductAdm() {
    System.out.println(Colors.TEXT_WHITE_BOLD_BRIGHT + "Qual será o nome do Jogador?");
    String name = scanner.next();
    System.out.println("Qual será o time estampado do Produto?");
    String team = scanner.next();
    System.out.println("Qual será o preço do Produto?");
    String price = scanner.next();
    return new String[]{name, team, price};
  }

  public String[] alterProductSaleAdm() {
    System.out.println(Colors.TEXT_WHITE_BOLD_BRIGHT + "Qual produto deseja alterar, escolha seu número:");
    String alter = scanner.next();
    System.out.println("Digite o novo Jogador:");
    String name = scanner.next();
    System.out.println("Digite o novo time Estampado:");
    String team = scanner.next();
    System.out.println("Digite o novo preço do produto:");
    String price = scanner.next();
    System.out.println("Deseja alterar os tamanhos padrões?(S/N)");
    String trueOrNot = scanner.next();
    String numberAddOrNot = "0";
    String addOrRemove = "";
    if (trueOrNot.equalsIgnoreCase("s")) {
      System.out.println("Deseja adicionar ou remover algum tamanho?(ADD/REM)");
      addOrRemove = scanner.next();
      System.out.println("Digite a Medida:");
      numberAddOrNot = scanner.next();
    }
    return new String[]{alter, name, team, price, numberAddOrNot, addOrRemove};
  }

  public int removeProductSaleAdm() {
    System.out.println(Colors.TEXT_WHITE_BOLD_BRIGHT + "Qual Produto deseja Remover, escolha o número:");
    return scanner.nextInt();
  }

  public int alterOrNotUser(){
    System.out.println(Colors.TEXT_PURPLE_BOLD_BRIGHT + "1 - Alterar");
    System.out.println(Colors.TEXT_RED_BOLD_BRIGHT + "2 - Remover");
    System.out.println("3 - Sair");
    return scanner.nextInt();
  }

  public int[] buyProductUser() {
    System.out.println(Colors.TEXT_WHITE_BOLD_BRIGHT + "Qual item deseja comprar, escolha o número");
    int indexProduct = scanner.nextInt();
    System.out.println("Quantidade: ");
    int quantity = scanner.nextInt();
    return new int[]{indexProduct, quantity};
  }

  public int[] alterProductUser() {
    System.out.println(Colors.TEXT_WHITE_BOLD_BRIGHT + "Escolha o núemro do que deseja alterar:");
    int updated = scanner.nextInt();
    System.out.println("Digite a nova Quantidade:");
    int newQauntity = scanner.nextInt();
    return new int[]{updated, newQauntity};
  }

  public int removeProductUser(){
    System.out.println(Colors.TEXT_WHITE_BOLD_BRIGHT + "Digite o número do Produto que deseja remover:");
    return scanner.nextInt();
  }

}
