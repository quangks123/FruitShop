
package test;

import controllers.ShopManager;
import views.MainMenu;

public class Main {
    
    public static void main(String[] args) {
        ShopManager shop = new ShopManager();
        
        String[] choices = {"Create Fruit", "View shop", "View orders", "Shopping (for buyer)", "Exit"};
        shop.initiateShop();
        new MainMenu("FRUIT SHOP SYSTEM", choices).run();
        
       
    }
}
