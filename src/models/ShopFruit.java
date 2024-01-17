
package models;

import java.util.ArrayList;

public class ShopFruit {
    private static ArrayList<Customer> c = new ArrayList<>();
    private static ArrayList<Fruit> f = new ArrayList<>();

    public ArrayList<Customer> getCusList() {
        return c;
    }

    public void setCusList(ArrayList<Customer> c) {
        ShopFruit.c = c;
    }

    public ArrayList<Fruit> getFruitList() {
        return f;
    }

    public void setFruitList(ArrayList<Fruit> f) {
        ShopFruit.f = f;
    }
    
    public float getTotalCost() {
        float cost = 0;
        for (Fruit fr : f) {
            cost += fr.getPrice() * fr.getQuantity();
        }
        return cost;
    }
    
}
