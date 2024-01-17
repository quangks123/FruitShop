
package models;

public class Fruit {
    private int id, quantity;
    private String name, origin;
    private float price;

    public Fruit() {
    }

    public Fruit(int id, int quantity, String name, String origin, float price) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return String.format("%-3d | %-14s | %-10s | %-8d | %-5f", id, name, origin, quantity, price);
    }
    
    
}
