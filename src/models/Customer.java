
package models;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Fruit> cart;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
        cart = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Fruit> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Fruit> cart) {
        this.cart = cart;
    }
    
    public float getTotalCost() {
        float cost = 0;
        for (Fruit f : cart) {
            cost += f.getPrice() * f.getQuantity();        
        }
        return cost;
    }
    
    public void display() {
        System.out.println(name);
        for (Fruit f : cart) {
            System.out.println(f);
        }
        System.out.println("TOTAL: " + getTotalCost());
        System.out.println("-------------------------\n");
    }
}
