package AbstractsClasses;

import java.util.Set;

public abstract class Clothing {
  protected String name;
  protected String color;
  protected float price;

  public abstract void information();

  public abstract String getName();

  public abstract float getPrice();

  public abstract void addSize(int size);
  public abstract void removeSize(int size);

  public abstract boolean exists(int size);

  public abstract void setName(String name);

  public abstract void setColor(String color);

  public abstract void setPrice(float price);

}
