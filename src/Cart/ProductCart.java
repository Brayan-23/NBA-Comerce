package Cart;

public class ProductCart {
  private final String name;
  private int quantity;
  private final float priceUnit;
  private float totalPrice;

  public ProductCart(String name, int quantity, float priceUnit) {
    this.name = name;
    this.quantity = quantity;
    this.priceUnit = priceUnit;
    this.totalPrice = priceUnit * quantity;
  }

  public int getQuantity() {
    return quantity;
  }

  public String getName() {
    return name;
  }

  public void information() {
    System.out.println("Produto: " + name);
    System.out.println("Quanridade: " + quantity);
    System.out.printf("Price Unitário:%.2f R$", priceUnit);
    System.out.printf("Preço Total:%.2f R$", totalPrice);

  }

  public void newQtd(int quantity) {
    this.quantity = quantity;
    this.totalPrice = priceUnit * this.quantity;
  }
}
