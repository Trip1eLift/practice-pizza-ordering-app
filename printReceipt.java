/**printReceipt.java
 *
 * Description: Print the receipt while the pizza order is done
 *              Power PizzaApp.java
 *
 * Date: 10/27/2018
 * @author: Joseph Chang
 */

import java.util.ArrayList;

public class printReceipt
{
    public final double TAXRATE = 0.06;
    public printReceipt(ArrayList<Pizza> pizzas)
    {
        double totalPrice = 0;
        int i = 0;


        while(i < pizzas.size())
        {
            totalPrice += pizzas.get(i).totalPrice();
            i++;
        }

        double tax = TAXRATE * totalPrice;
        double finalTotal = tax + totalPrice;

        String type = "";
        for(int j = 1; j <= pizzas.size(); j++)
        {
            switch (pizzas.get(j-1).getSize())
            {
                case 1:
                    type = "Small";
                    break;
                case 2:
                    type = "Medium";
                    break;
                case 3:
                    type = "Large";
                    break;
            }

            System.out.println( j + " " + type + " Pizza");

            if(pizzas.get(j-1).getVeggi().getPinapple())
                System.out.println("     Add Pineapple");
            if(pizzas.get(j-1).getVeggi().getExtraPinapple())
                System.out.println("     Add Extra Pineapple");
            if(pizzas.get(j-1).getVeggi().Peppers)
                System.out.println("     Add Peppers");
            if(pizzas.get(j-1).getVeggi().Onions)
                System.out.println("     Add Onions");
            if(pizzas.get(j-1).getVeggi().Mushrooms)
                System.out.println("     Add Mushrooms");
            if(pizzas.get(j-1).getVeggi().BananaPeppers)
                System.out.println("     Add Banana Peppers");

            if(pizzas.get(j-1).getMeat().Ham)
                System.out.println("     Add Ham");
            if(pizzas.get(j-1).getMeat().Pepperoni)
                System.out.println("     Add Pepperoni");
            if(pizzas.get(j-1).getMeat().Sausage)
                System.out.println("     Add Sausage");
            if(pizzas.get(j-1).getMeat().Salami)
                System.out.println("     Add Salami");
            if(pizzas.get(j-1).getMeat().Chicken)
                System.out.println("     Add Chicken");
            if(pizzas.get(j-1).getMeat().Steak)
                System.out.println("     Add Steak");
        }

        String strDouble = String.format("%.2f", totalPrice);
        System.out.println("Food Total: $" + strDouble);
        strDouble = String.format("%.2f", tax);
        System.out.println("Tax:   $" + strDouble);
        strDouble = String.format("%.2f", finalTotal);
        System.out.println("\n\nFinal Total: $" + strDouble);
    }
}
