package AbstractsClasses;

import java.util.Set;

public abstract class Clothing {
  protected String name;
  protected String team;

  protected String type;
  protected float price;

  public abstract void information();

  public abstract String getName();

  public abstract float getPrice();

  public abstract void addSize(int size);
  public abstract void removeSize(int size);

  public abstract boolean exists(int size);

  public abstract void setName(String name);

  public abstract void setTeam(String team);

  public abstract void setPrice(float price);

}
