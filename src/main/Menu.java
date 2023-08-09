package main;

import AbstractsClasses.Clothing;
import Cart.Cart;
import Cart.ProductCart;
import Products.Pants;
import Products.Shorts;
import Products.TShirt;
import Products.Tennis;
import utils.CRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {

  Cart cart = new Cart();
  private final Scanner scanner = new Scanner(System.in);
  public static final List<Clothing> sales = new ArrayList<>(
      List.of(new Pants("Jeans", "black", 100),
          new Shorts("Tommy", "white", 90),
          new Tennis("Nike", "white", 200),
          new TShirt("Polo", "black", 50))
  );

  public void interfaceInicial() {
    System.out.println("Log-in");
    System.out.println("1 - Administrador");
    System.out.println("2 - Usuário");
    int value = scanner.nextInt();
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

  private int newProductSaleAdm() {
    System.out.println("Escolha o Tipo de Produto:");
    System.out.println("1 - Pants");
    System.out.println("2 - Shorts");
    System.out.println("3 - Tennis:");
    System.out.println("4 - TShirt");
    return scanner.nextInt();
  }

  private String[] informationsNewProductAdm() {
    System.out.println("Qual será o nome do Produto?");
    String name = scanner.next();
    System.out.println("Qual será a cor do Produto?");
    String color = scanner.next();
    System.out.println("Qual será o preço do Produto?");
    String price = scanner.next();
    return new String[]{name, color, price};
  }


  private String[] alterProductSaleAdm() {
    System.out.println("Qual produto deseja alterar, escolha seu número:");
    String alter = scanner.next();
    System.out.println("Digite o novo nome:");
    String name = scanner.next();
    System.out.println("Digite a nova cor:");
    String color = scanner.next();
    System.out.println("Digite o novo preço do produto:");
    String price = scanner.next();
    System.out.println("Deseja alterar os tamanhos padrões?");
    String trueOrNot = scanner.next();
    String add = "";
    String remove = "";
    String addOrRemove = "";
    if (trueOrNot.equals("Sim")) {
      System.out.println("Deseja adicionar ou remover algum tamanho?");
      addOrRemove = scanner.next();
      if (addOrRemove.equals("true")) {
        System.out.println("Digite o valor a ser inserido:");
        add = scanner.next();
        System.out.println("Adicionado com Sucesso");
      } else {
        System.out.println("Digite o valor a ser inserido:");
        remove = scanner.next();
        System.out.println("Removido com Sucesso");
      }
    }
    return new String[]{alter, name, color, price, add, remove, addOrRemove};
  }

  private int removeProductSaleAdm() {
    System.out.println("Qual Produto deseja Remover, escolha o núemro:");
    return scanner.nextInt();
  }

  private int alterOrNotUser(){
    System.out.println("1 - Alterar");
    System.out.println("2 - Sair");
    return scanner.nextInt();
  }

  private int[] buyProductUser() {
    System.out.println("Qual item deseja comprar, escolha o número");
    int indexProduct = scanner.nextInt();
    System.out.println("Quantidade: ");
    int quantity = scanner.nextInt();
    return new int[]{indexProduct, quantity};
  }

  private int[] alterProductUser() {
      System.out.println("Escolha o núemro do que deseja alterar:");
      int updated = scanner.nextInt();
      System.out.println("Digite a nova Quantidade:");
      int newQauntity = scanner.nextInt();
      return new int[]{updated, newQauntity};

  }

  private void interfaceUser(int menu) {
    if (menu == 1) {
      CRUD.read();
      int[] chosenProdcut = buyProductUser();
      Clothing product = sales.get(chosenProdcut[0] - 1);
      cart.buy(product.getName(), chosenProdcut[1], product.getPrice());
    } else if (menu == 2) {
      cart.getListaProducts();
      if (alterOrNotUser() == 1) {
        int[] alterProduct = alterProductUser();
        cart.alterQuantity(alterProduct[0], alterProduct[1]);
      }
    }
  }

  private void interfaceAdm(int menu) {
    if (menu == 1) {
      int typeProduct = newProductSaleAdm();
      String[] infoProduct = informationsNewProductAdm();
      CRUD.create(typeProduct, infoProduct[0], infoProduct[1], Float.parseFloat(infoProduct[2]));
      System.out.println("Criado com Sucesso!");
    } else if (menu == 2) {
      CRUD.read();
      String[] infoAlterProduct = alterProductSaleAdm();
      CRUD.updated(Integer.parseInt(infoAlterProduct[0]), infoAlterProduct[1], infoAlterProduct[2],
          Float.parseFloat(infoAlterProduct[3]), new int[]{Integer.parseInt(infoAlterProduct[4], Integer.parseInt(infoAlterProduct[5]))},
          Boolean.parseBoolean(infoAlterProduct[6]));
      System.out.println("Produto alterado com Sucesso");
    } else if (menu == 3) {
      CRUD.delete(removeProductSaleAdm());
      System.out.println("Produto removido com Sucesso");
    }
  }
}
