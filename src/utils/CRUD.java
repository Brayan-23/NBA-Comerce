package utils;


import AbstractsClasses.Clothing;
import Products.Pants;
import Products.Shorts;
import Products.TShirt;
import Products.Tennis;
import main.Menu;

public class CRUD {

  public static void create(int type, String name, String color, float price) {
    switch (type) {
      case 1 -> Menu.sales.add(new Pants(name, color, price));
      case 2 -> Menu.sales.add(new Shorts(name, color, price));
      case 3 -> Menu.sales.add(new Tennis(name, color, price));
      case 4 -> Menu.sales.add(new TShirt(name, color, price));
      default -> System.out.println("Erro");
    }
    System.out.println("Criado");
  }

  public static void read() {
    for (Clothing product : Menu.sales) product.information();
  }

  public static void updated(int numberProduct, String name, String color, float price, int[] size, boolean addOrNot){
    Clothing product = Menu.sales.get(numberProduct - 1);
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

public static void delete(int numberProduct){Menu.sales.remove(numberProduct -1 );}
}
