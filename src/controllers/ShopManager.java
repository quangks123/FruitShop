
package controllers;

import models.Fruit;
import models.ShopFruit;

public class ShopManager {
    ShopFruit shop = new ShopFruit();
    
    public void addFruit(String name, String origin, int quantity, float price) {
        if (price == 0) {
            for (int i = 0; i < shop.getFruitList().size(); i++) {
                if (shop.getFruitList().get(i).getName().equals(name) && shop.getFruitList().get(i).getOrigin().equals(origin)) {
                    int temp = shop.getFruitList().get(i).getQuantity();
                    shop.getFruitList().get(i).setQuantity(temp + quantity);
                    break;
                }
            }
        } else {
            shop.getFruitList().add(new Fruit(creatId(), quantity, name, origin, price));
        }
    }
    
    public void initiateShop() {
        shop.getFruitList().add(new Fruit(1, 10, "Apple", "Thailand", 1));
        shop.getFruitList().add(new Fruit(2, 10, "Mango", "US", 2));
        shop.getFruitList().add(new Fruit(3, 10, "Coconut", "Vietnam", 2));
        shop.getFruitList().add(new Fruit(4, 10, "Grape", "France", 6));
        shop.getFruitList().add(new Fruit(5, 10, "Orange", "Italy", 3));
    }
    
    public void viewShop() {
        System.out.println("=== SHOP VIEW ===");
        for (Fruit f : shop.getFruitList()) {
            System.out.println(f);
        }
    }
    
    public boolean checkExist(String name, String origin) {
        for (Fruit f : shop.getFruitList()) {
            if (f.getOrigin().equals(origin) && f.getName().equals(name)) {
                return true;
            }
        }
        
        return false;
    }
    
    public int creatId() {
        return shop.getFruitList().size() + 1;
    }
    
    public boolean checkExist(int id) {
        for (Fruit f : shop.getFruitList()) {
            if (f.getId() == id) {
                return true;
            }
        }
        return false;
    }
    
    
}
