package Products;

import AbstractsClasses.Clothing;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;


public class TShirt extends Clothing {

  private static final Set<Integer> sizes = new TreeSet<>(
      Arrays.asList(36, 38, 40, 42, 44, 46, 48, 50)
  );

  public TShirt(String name, String color, float price) {
    this.name = name;
    this.price = price;
    this.color = color;
  }

  @Override
  public void information() {
    System.out.println("Produto: " + name);
    System.out.println("Cor: " + color);
    System.out.printf("Price:%.2f ", price);
    System.out.println("Tamanhos Disponíveis: "+ sizes);
  }

  @Override
  public String getName() {return name;}

  @Override
  public float getPrice() {return price;}

  @Override
  public void addSize(int size) {
    sizes.add(size);
  }

  @Override
  public void removeSize(int size) {
    sizes.remove(size);
  }

  @Override
  public boolean exists(int size) {return sizes.contains(size);}

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public void setPrice(float price) {
    this.price = price;
  }

}
