
package views;

import controllers.CustomerManager;
import controllers.Validation;

public class Shopping extends Menu{
    private CustomerManager cus = new CustomerManager();
    private Validation val = new Validation();

    public Shopping(String title, String[] choices) {
        super(title, choices);
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                int id, quantity;
                System.out.print("ID: ");
                id = val.inputNum();
                
                System.out.print("Quantity: ");
                quantity = val.inputNum();
                
                cus.addFruitToCart(id, quantity);
                break;
                
            case 2:
                cus.viewCart();
                break;
            case 3:
                
                break;
        }
    }
    
}
