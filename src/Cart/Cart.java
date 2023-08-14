package Cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

  private final List<ProductCart> listaProducts = new ArrayList<>();
  private float valorTotal;


  public void getListaProducts() {
    int contador = 1;
    for (ProductCart product : listaProducts){
      System.out.print(contador + ": ");
      product.information();
      System.out.println("---------------------------------");
      contador++;
    }
    System.out.printf("Valor Total do Pedido: R$%.2f\n", valorTotal);
  }

  public void buy(String name, int quantity, float priceUnit) {
    if (listaProducts.size() == 0) {
      listaProducts.add(new ProductCart(name, quantity, priceUnit));
      valorTotal += (priceUnit * quantity);
      System.out.println("Produto adicionado ao Carrinho!");
    } else {
      for (ProductCart prodcut : listaProducts) {
        if (!prodcut.getName().equals(name)) {
          listaProducts.add(new ProductCart(name, quantity, priceUnit));
          valorTotal += (priceUnit * quantity);
          System.out.println("Produto adicionado ao Carrinho!");
          break;
        } else System.out.println("Esse item ja está no seu carrinho!");
      }
    }
  }

  public void removeProduct(int numberProduct) {
     valorTotal -= listaProducts.get(numberProduct).getTotalPrice();
     listaProducts.remove(numberProduct);
  }

  public void alterQuantity(int numberProduct, int quantity) {
    ProductCart product = listaProducts.get(numberProduct - 1);
    if (quantity <= 0) {
      removeProduct(numberProduct - 1);
      System.out.println("Produto Removido do Carrinho");
    } else {
      valorTotal -= product.getTotalPrice();
      product.newQtd(quantity);
      valorTotal += product.getTotalPrice();
      System.out.println("Alterado com Sucesso.");
    }
  }

}
