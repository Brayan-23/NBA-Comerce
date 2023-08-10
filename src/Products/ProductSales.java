package Products;


import AbstractsClasses.Clothing;

import java.util.ArrayList;
import java.util.List;

public class ProductSales {

  private static final List<Clothing> sales = new ArrayList<>(
      List.of(new Pants("Jeans", "black", 100),
          new Shorts("Tommy", "white", 90),
          new Tennis("Nike", "white", 200),
          new TShirt("Polo", "black", 50))
  );


  public static void create(int type, String name, String color, float price) {
    switch (type) {
      case 1 -> sales.add(new Pants(name, color, price));
      case 2 -> sales.add(new Shorts(name, color, price));
      case 3 -> sales.add(new Tennis(name, color, price));
      case 4 -> sales.add(new TShirt(name, color, price));
      default -> System.out.println("Erro");
    }
    System.out.println("Criado");
  }

  public static Clothing getSale(int sale){
    return sales.get(sale - 1);
  }

  public static void read() {
    for (Clothing product : sales) {
      product.information();
      System.out.println("---------------------------------");
    }
  }

  public static void updated(int numberProduct, String name, String color, float price, int[] size, boolean addOrNot){
    Clothing product = sales.get(numberProduct - 1);
    product.setName(name);
    product.setColor(color);
    product.setPrice(price);
    addOrRemoveSize(product, size, addOrNot);
  }

  private static void addOrRemoveSize(Clothing product, int[] size, boolean addOrNot){
    if (product.exists(size[0]) || product.exists(size[1])) System.out.println("Tamanho já existente!");
    else if (addOrNot) product.addSize(size[0]);
    else product.removeSize(size[1]);
  }

public static void delete(int numberProduct){sales.remove(numberProduct -1 );}
}
