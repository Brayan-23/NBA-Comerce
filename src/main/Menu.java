package main;

import AbstractsClasses.Clothing;
import Cart.Cart;
import Products.ProductSales;
import utils.Colors;


public class Menu {

  Cart cart = new Cart();
  QuestionsUser questions = new QuestionsUser();
  public void menu(){
    boolean condition = true;
    questions.nameCompany();
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
    switch (menu) {
      case 1 -> {
        ProductSales.read();
        int[] chosenProdcut = questions.buyProductUser();
        Clothing product = ProductSales.getSale(chosenProdcut[0]);
        cart.buy(product.getName(), chosenProdcut[1], product.getPrice());
      }
      case 2 -> {
        cart.getListaProducts();
        int alterOrNotUser = questions.alterOrNotUser();
        if (alterOrNotUser == 1) {
          int[] alterProduct = questions.alterProductUser();
          cart.alterQuantity(alterProduct[0], alterProduct[1]);
        } else if (alterOrNotUser == 2) cart.removeProduct(questions.removeProductUser() - 1);
      }
      default -> {return false;}
    }
    return true;
  }

  private boolean interfaceAdm(int menu) {
    switch (menu) {
      case 1 -> {
        int typeProduct = questions.newProductSaleAdm();
        String[] infoProduct = questions.informationsNewProductAdm();
        ProductSales.create(typeProduct, infoProduct[0], infoProduct[1], Float.parseFloat(infoProduct[2]));
        System.out.println("Criado com Sucesso!");
      }
      case 2 ->{
        ProductSales.read();
        String[] infoAlterProduct = questions.alterProductSaleAdm();
        ProductSales.updated(Integer.parseInt(infoAlterProduct[0]), infoAlterProduct[1], infoAlterProduct[2],
            Float.parseFloat(infoAlterProduct[3]), Integer.parseInt(infoAlterProduct[4]), infoAlterProduct[5]);
        System.out.println("Produto alterado com Sucesso");
      }
      case 3 -> {
        ProductSales.read();
        ProductSales.delete(questions.removeProductSaleAdm());
        System.out.println("Produto removido com Sucesso");
      }
      default -> {return false;}
    }
    return true;
  }
}
