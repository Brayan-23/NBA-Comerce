package main;

import java.util.Scanner;

public class QuestionsUser {

  public final Scanner scanner = new Scanner(System.in);


  public int interfaceInicial() {
    System.out.println("Log-in");
    System.out.println("1 - Administrador");
    System.out.println("2 - Usuário");
    System.out.println("3 - Sair");
    return scanner.nextInt();
  }

  public int menuPrincipalAdm() {
    System.out.println("Escolha uma opção abaixo:");
    System.out.println("1 - Adicionar Novo Produto!");
    System.out.println("2 - Alterar Producto!");
    System.out.println("3 - Remover Produto");
    System.out.println("4 - Sair");
    return scanner.nextInt();
  }

  public int menuPrincipalUser() {
    System.out.println("Escolha uma opção abaixo:");
    System.out.println("1 - Comprar");
    System.out.println("2 - Olhar Carrinho");
    System.out.println("3 - Sair");
    return scanner.nextInt();
  }

  public int newProductSaleAdm() {
    System.out.println("Escolha o Tipo de Produto:");
    System.out.println("1 - Pants");
    System.out.println("2 - Shorts");
    System.out.println("3 - Tennis:");
    System.out.println("4 - TShirt");
    return scanner.nextInt();
  }

  public String[] informationsNewProductAdm() {
    System.out.println("Qual será o nome do Produto?");
    String name = scanner.next();
    System.out.println("Qual será a cor do Produto?");
    String color = scanner.next();
    System.out.println("Qual será o preço do Produto?");
    String price = scanner.next();
    return new String[]{name, color, price};
  }

  public String[] alterProductSaleAdm() {
    System.out.println("Qual produto deseja alterar, escolha seu número:");
    String alter = scanner.next();
    System.out.println("Digite o novo nome:");
    String name = scanner.next();
    System.out.println("Digite a nova cor:");
    String color = scanner.next();
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
    return new String[]{alter, name, color, price, numberAddOrNot, addOrRemove};
  }

  public int removeProductSaleAdm() {
    System.out.println("Qual Produto deseja Remover, escolha o núemro:");
    return scanner.nextInt();
  }

  public int alterOrNotUser(){
    System.out.println("1 - Alterar");
    System.out.println("2 - Remover");
    System.out.println("3 - Sair");
    return scanner.nextInt();
  }

  public int[] buyProductUser() {
    System.out.println("Qual item deseja comprar, escolha o número");
    int indexProduct = scanner.nextInt();
    System.out.println("Quantidade: ");
    int quantity = scanner.nextInt();
    return new int[]{indexProduct, quantity};
  }

  public int[] alterProductUser() {
    System.out.println("Escolha o núemro do que deseja alterar:");
    int updated = scanner.nextInt();
    System.out.println("Digite a nova Quantidade:");
    int newQauntity = scanner.nextInt();
    return new int[]{updated, newQauntity};
  }

  public int removeProductUser(){
    System.out.println("Digite o número do Produto que deseja remover:");
    return scanner.nextInt();
  }

}
