package main;

import AbstractsClasses.Clothing;
import Cart.Cart;
import Cart.ProductCart;
import Products.Pants;
import Products.Shorts;
import Products.TShirt;
import Products.Tennis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {

 Cart cart = new Cart();
private final Scanner scanner = new Scanner(System.in);
private final List<Clothing> sales = new ArrayList<>(
    List.of(new Pants("Jeans", "black", 100),
        new Shorts("Tommy", "white", 90),
        new Tennis("Nike", "white", 200),
        new TShirt("Polo", "black", 50))
);

public int productsForSale(){
  for (int i = 0; i < sales.size(); i++) {
    System.out.print(i + " - ");
    sales.get(i).information();
  }
  System.out.println("Qual item deseja comprar, escolha o número");
  return scanner.nextInt();
}
public int productsCart(){
  for (int i = 0; i < cart.getListaProducts().size(); i++) {
    System.out.print(i + " - ");
    cart.getListaProducts().get(i).information();
  }
  System.out.println("1 - Alterar");
  System.out.println("2 - Sair");
  return scanner.nextInt();
}

  public void interfaceInicial(){
    System.out.println("Log-in");
    System.out.println("1 - Administrador");
    System.out.println("2 - Usuário");
   int value = scanner.nextInt();
  }

  private void interfaceUser(int menu){
    if (menu == 1){
      int indexProduct = productsForSale();;
      Clothing product = sales.get(indexProduct - 1);
      System.out.println("Quantidade: ");
      int quantity = scanner.nextInt();
      cart.buy(product.getName(), quantity, product.getPrice());
    } else if (menu == 2) {
      ;boolean condition = true;
      while (condition){
        int responseCart = productsCart();
        if (responseCart == 1){
          System.out.println("Escolha o núemro do que deseja alterar:");
          int value = scanner.nextInt();
          System.out.println("Digite a nova Quantidade:");
          int newQauntity = scanner.nextInt();
          cart.alterQuantity(value, newQauntity);
        } else condition = false;
      }
    }
  }

  public void menuPrincipalUser(){
    System.out.println("Escolha uma opção abaixo:");
    System.out.println("1 - Comprar");
    System.out.println("2 - Olhar Carrinho");
    System.out.println("3 - Sair");
  }



}
