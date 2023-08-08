package utils;


import AbstractsClasses.Clothing;
import Products.Pants;
import Products.Shorts;
import Products.TShirt;
import Products.Tennis;

import java.util.ArrayList;
import java.util.List;

public class CRUD {

  private static final List<Clothing> products = new ArrayList<>();

  public static void create(int type, String name, String color, float price) {
    switch (type) {
      case 1 -> products.add(new Pants(name, color, price));
      case 2 -> products.add(new Shorts(name, color, price));
      case 3 -> products.add(new Tennis(name, color, price));
      case 4 -> products.add(new TShirt(name, color, price));
      default -> System.out.println("Erro");
    }
    System.out.println("Criado");
  }

  public static void read() {
    for (Clothing product : products) product.information();
  }

  public static void updated(int numberProduct, int size, float price, String name, String color, boolean addOrNot){
    Clothing product = products.get(numberProduct - 1);
    product.setName(name);
    product.setColor(color);
    product.setPrice(price);
    addOrRemoveSize(product, size, addOrNot);
  }

  public static void addOrRemoveSize(Clothing product, int size, boolean addOrNot){
    if (product.exists(size)) System.out.println("Tamanho já existente!");
    else if (addOrNot) product.addSize(size);
    else product.removeSize(size);
  }

public static void delete(int numberProduct){products.remove(numberProduct -1 );}
}
