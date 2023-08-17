package Cart;

public class ProductCart {
  private final String name;
  private int quantity;
  private final float priceUnit;
  private float totalPrice;

  public ProductCart(String namePlayer, int quantity, float priceUnit) {
    this.name = namePlayer;
    this.quantity = quantity;
    this.priceUnit = priceUnit;
    this.totalPrice = priceUnit * quantity;
  }

  public float getTotalPrice() {return  totalPrice;}

  public String getName() {
    return name;
  }

  public void information() {
    System.out.println("Produto: " + name);
    System.out.println("Quantidade: " + quantity);
    System.out.printf("Preço Unitário: R$%.2f\n", priceUnit);
    System.out.printf("Preço Total de Produtos: R$%.2f\n", totalPrice);
  }

  public void newQtd(int quantity) {
    this.quantity = quantity;
    this.totalPrice = priceUnit * this.quantity;
  }
}
