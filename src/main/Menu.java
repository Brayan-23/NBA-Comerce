package main;

import AbstractsClasses.Clothing;
import Cart.Cart;
import Products.ProductSales;



public class Menu {

  Cart cart = new Cart();
  QuestionsUser questions = new QuestionsUser();
  public void menu(){
    boolean condition = true;
    int value = questions.interfaceInicial();
    while (condition) {
      if (value == 1) {
        int menuAdm = questions.menuPrincipalAdm();
        condition = interfaceAdm(menuAdm);
      } else if (value == 2) {
        int menuUser = questions.menuPrincipalUser();
        condition = interfaceUser(menuUser);
      } else {
        condition = false;
        questions.scanner.close();
      }
    }
  }

  private boolean interfaceUser(int menu) {
    if (menu == 1) {
      ProductSales.read();
      int[] chosenProdcut = questions.buyProductUser();
      Clothing product = ProductSales.getSale(chosenProdcut[0]);
      cart.buy(product.getName(), chosenProdcut[1], product.getPrice());
    } else if (menu == 2) {
      cart.getListaProducts();
      if (questions.alterOrNotUser() == 1) {
        int[] alterProduct = questions.alterProductUser();
        cart.alterQuantity(alterProduct[0], alterProduct[1]);
      }
    } else return false;
    return true;
  }

  private boolean interfaceAdm(int menu) {
    if (menu == 1) {
      int typeProduct = questions.newProductSaleAdm();
      String[] infoProduct = questions.informationsNewProductAdm();
      ProductSales.create(typeProduct, infoProduct[0], infoProduct[1], Float.parseFloat(infoProduct[2]));
      System.out.println("Criado com Sucesso!");
    } else if (menu == 2) {
      ProductSales.read();
      String[] infoAlterProduct = questions.alterProductSaleAdm();
      ProductSales.updated(Integer.parseInt(infoAlterProduct[0]), infoAlterProduct[1], infoAlterProduct[2],
          Float.parseFloat(infoAlterProduct[3]), new int[]{Integer.parseInt(infoAlterProduct[4], Integer.parseInt(infoAlterProduct[5]))},
          Boolean.parseBoolean(infoAlterProduct[6]));
      System.out.println("Produto alterado com Sucesso");
    } else if (menu == 3) {
      ProductSales.delete(questions.removeProductSaleAdm());
      System.out.println("Produto removido com Sucesso");
    } else return false;
    return true;
  }
}
