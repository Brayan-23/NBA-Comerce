package Products;

import AbstractsClasses.Clothing;

import java.util.*;

public class Shorts extends Clothing {

  private static final Set<Integer> sizes = new TreeSet<>(
      Arrays.asList(36, 38, 40, 42, 44, 46, 48, 50)
  );

  public Shorts(String namePlayer, String team, float price) {
    this.name = namePlayer;
    this.price = price;
    this.team = team;
    this.type = "Shorts";
  }

  @Override
  public void information() {
    System.out.println("Nome do Jogador: " + name + " \uD83C\uDFC0");
    System.out.println("Tipo: " + type + " \uD83E\uDE73");
    System.out.println("Equipe: " + team);
    System.out.printf("Price: R$%.2f ", price);
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
  public void setTeam(String team) {
    this.team = team;
  }

  @Override
  public void setPrice(float price) {
    this.price = price;
  }

}
