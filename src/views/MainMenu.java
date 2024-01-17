
package views;

import controllers.CustomerManager;
import controllers.ShopManager;
import controllers.Validation;

public class MainMenu extends Menu{
    Validation val = new Validation();
    ShopManager shop = new ShopManager();
    CustomerManager cus = new CustomerManager();

    public MainMenu(String title, String[] choices) {
        super(title, choices);
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                while (true) {   
                    String name, stop, origin;
                    int quantity;
                    float price = 0;
                   
                    System.out.println("=== CREATE ===");
                    
                    //Name
                    System.out.print("Name: ");
                    name = val.inputString();
                    
                    //Origin
                    System.out.print("Origin: ");
                    origin = val.inputString();
                    
                    //Quantity
                    System.out.print("Quantity: ");
                    quantity = val.inputNum();
                    
                    //Price
                    if (!shop.checkExist(name, origin)) {
                        System.out.print("Price: ");
                        price = (float)val.inputFLoat();
                    }

                    //Create
                    shop.addFruit(name, origin, quantity, price);
                    System.out.println("----------");
                    System.out.println("CREATE SUCCESS!!");
                    System.out.println("----------");
                    
                    //continue?
                    while (true) {                        
                        System.out.print("Do you want to continue (Y/N)?    ");
                        stop = val.inputString();
                        if (!stop.equalsIgnoreCase("Y") && !stop.equalsIgnoreCase("N")) { 
                        } else {
                            break;
                        }
                    }
                    
                    if (stop.equalsIgnoreCase("n")) {
                        break;
                    }
                }
                break;
            
            case 2:
                shop.viewShop();
                break;
                
            case 3:
                cus.viewOrders();
                break;
            
            case 4:
                String name;
                System.out.print("Name : ");
                name = val.inputString();
                cus.add(name);
                shop.viewShop();
                String[] choices = {"Choose fruit", "View cart", "Pay for cart", "Back"};
                new Shopping("=== SHOPPING ===", choices).run();
                break;
        }
    }
    
}
