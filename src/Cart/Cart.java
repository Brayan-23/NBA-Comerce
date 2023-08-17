package Cart;

import utils.Colors;

import java.util.ArrayList;
import java.util.List;

public class Cart {

  private final List<ProductCart> listaProducts = new ArrayList<>();
  private float valorTotal;


  public void getListaProducts() {
    int contador = 1;
    for (ProductCart product : listaProducts){
      System.out.print(Colors.TEXT_CYAN_BOLD_BRIGHT + contador + ": ");
      product.information();
      System.out.println("---------------------------------");
      contador++;
    }
    System.out.printf(Colors.TEXT_WHITE_BOLD_BRIGHT + "Valor Total do Pedido: R$%.2f\n", valorTotal);
  }

  public void buy(String namePlayer, int quantity, float priceUnit) {
    if (listaProducts.isEmpty()) {
      listaProducts.add(new ProductCart(namePlayer, quantity, priceUnit));
      valorTotal += (priceUnit * quantity);
      System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "Produto adicionado ao Carrinho!");
    } else {
      for (ProductCart prodcut : listaProducts) {
        if (!prodcut.getName().equals(namePlayer)) {
          listaProducts.add(new ProductCart(namePlayer, quantity, priceUnit));
          valorTotal += (priceUnit * quantity);
          System.out.println("Produto adicionado ao Carrinho!");
          break;
        } else System.out.println(Colors.TEXT_RED_BOLD_BRIGHT + "Esse item ja está no seu carrinho!");
      }
    }
  }

  public void removeProduct(int numberProduct) {
     valorTotal -= listaProducts.get(numberProduct).getTotalPrice();
     listaProducts.remove(numberProduct);
    System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "Produto Removido do Carrinho");
  }

  public void alterQuantity(int numberProduct, int quantity) {
    ProductCart product = listaProducts.get(numberProduct - 1);
    if (quantity <= 0) {
      removeProduct(numberProduct - 1);
      System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "Produto Removido do Carrinho");
    } else {
      valorTotal -= product.getTotalPrice();
      product.newQtd(quantity);
      valorTotal += product.getTotalPrice();
      System.out.println(Colors.TEXT_GREEN_BOLD_BRIGHT + "Alterado com Sucesso.");
    }
  }

}
