
package controllers;

import models.Customer;
import models.Fruit;
import models.ShopFruit;

public class CustomerManager {
    ShopFruit shop = new ShopFruit();

    public void add(String name) {
        shop.getCusList().add(new Customer(name));
    }
    
    public void addFruitToCart(int id, int quantity) {
        if (new ShopManager().checkExist(id)) {
            if (checkCart(id) != null) {
                if (!checkQuantity(checkCart(id), quantity)) {
                    System.out.println("Quantity is not available!!");
                } else {
                    for (int i = 0; i < shop.getCusList().getLast().getCart().size(); i++) {
                        if (shop.getCusList().getLast().getCart().get(i).getId() == id) {
                            int temp = shop.getCusList().getLast().getCart().get(i).getQuantity();
                            shop.getCusList().getLast().getCart().get(i).setQuantity(temp + quantity);
                            break;
                        }
                    }
                }
            } else {
                for (Fruit f : shop.getFruitList()) {
                    if (f.getId() == id) {
                        if (f.getQuantity() < quantity) {
                            System.out.println("Quantity is not available!!");
                            break;
                        } else {
                            shop.getCusList().getLast().getCart().add(f);
                            shop.getCusList().getLast().getCart().getLast().setQuantity(quantity);
                            break;
                        }
                            
                    }
                }
            }
        } else {
            System.out.println("Not found!!");
        }
    }
    
    public Fruit checkCart(int id) {
        Customer c = shop.getCusList().getLast();
        for (Fruit f : c.getCart()) {
            if (id == f.getId()) {
                return f;
            }
        }
        return null;
    }
    
    public boolean checkQuantity(Fruit f, int quantity) {
        for (Fruit fr : shop.getFruitList()) {
            if (fr.getId() == f.getId()) {
                if (fr.getQuantity() < f.getQuantity() + quantity) {
                    return false;
                } else {
                    break;
                }
            }
        }
        
        return true;
    }
    
    public void viewCart() {
        
        shop.getCusList().getLast().display();
    }
    
    public void viewOrders() {
        for (Customer c : shop.getCusList()) {
            c.display();
        }
        System.out.println("-------------");
    }
    
    public void payCart() {
        for (Fruit f : shop.getCusList().getLast().getCart()) {
            for (int i = 0; i < shop.getFruitList().size(); i++) {
                if (f.getId() == shop.getFruitList().get(i).getId()) {
                    int temp = shop.getFruitList().get(i).getQuantity();
                    if (temp - f.getQuantity() == 0) {
                        shop.getFruitList().remove(i);
                    } else {
                        shop.getFruitList().get(i).setQuantity(temp - f.getQuantity());
                    }
                    break;
                }
            }
        }
    }
}
