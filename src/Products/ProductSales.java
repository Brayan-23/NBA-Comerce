package Products;


import AbstractsClasses.Clothing;
import utils.Colors;

import java.util.ArrayList;
import java.util.List;

public class ProductSales {

  private static final List<Clothing> sales = new ArrayList<>(
      List.of(new Pants("LeBron-James", "Lakers", 100),
          new Shorts("Jason-Tatum", "Celtics", 90),
          new Tennis("Paul-George", "Clippers", 200),
          new TShirt("Stephen-Curry", "Warriors", 50))
  );


  public static void create(int type, String name, String color, float price) {
    switch (type) {
      case 1 -> sales.add(new Pants(name, color, price));
      case 2 -> sales.add(new Shorts(name, color, price));
      case 3 -> sales.add(new Tennis(name, color, price));
      case 4 -> sales.add(new TShirt(name, color, price));
      default -> System.out.println("Erro");
    }
  }

  public static void read() {
    int contador = 1;
    for (Clothing product : sales) {
      System.out.print(Colors.TEXT_CYAN_BOLD_BRIGHT + contador + ": ");
      product.information();
      System.out.println("---------------------------------");
      contador++;
    }
  }

  public static Clothing getSale(int sale){
    return sales.get(sale - 1);
  }

  public static void updated(int numberProduct, String name, String team, float price, int size, String addOrNot){
    Clothing product = sales.get(numberProduct - 1);
    product.setName(name);
    product.setTeam(team);
    product.setPrice(price);
    addOrRemoveSize(product, size, addOrNot);
  }

  private static void addOrRemoveSize(Clothing product, int size, String addOrRemove){
    if (product.exists(size) && addOrRemove.equalsIgnoreCase("rem")) product.removeSize(size);
    if (product.exists(size)) System.out.println("Tamanho já existente!");
    else if (addOrRemove.equalsIgnoreCase("add")) product.addSize(size);
  }

public static void delete(int numberProduct){sales.remove(numberProduct -1 );}
}
