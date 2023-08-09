package Cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

  private final List<ProductCart> listaProducts = new ArrayList<>();

  public void getListaProducts() {
    for (ProductCart product : listaProducts) product.information();
  }

  public void buy(String name, int quantity, float priceUnit) {
    for (ProductCart prodcut : listaProducts) {
      if (!prodcut.getName().equals(name)) {
        listaProducts.add(new ProductCart(name, quantity, priceUnit));
        System.out.println("Produto no Carrinho!");
      } else System.out.println("Esse item ja está no seu carrinho!");
    }
  }

  public void removeProduct(int numberProduct) {
    listaProducts.remove(numberProduct - 1);
  }

  public void alterQuantity(int numberProduct, int quantity) {
    ProductCart product = listaProducts.get(numberProduct - 1);
    if (quantity <= 0) {
      removeProduct(numberProduct - 1);
      System.out.println("Produto Removido do Carrinho");
    } else {
      product.newQtd(quantity);
      System.out.println("Alterado com Sucesso.");
    }
  }

}
