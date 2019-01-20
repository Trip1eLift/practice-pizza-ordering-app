/**Pizza.java
 *
 * Description: Contain the pizzas data and logic
 *              to power PizzaApp.java
 *
 * Date: 10/27/2018
 * @author: Joseph Chang
 */

public class Pizza
{
    private int Size;
    private VeggiTopping veggi;
    private MeatTopping meat;

    public Pizza()
    {
        Size = 2;
        veggi = new VeggiTopping();
        meat = new MeatTopping();
    }

    void setSize(int size)
    {
        if (size > 3 || size < 1) {
            System.err.println("Invalid pizza size!");
            return;
        }

        Size = size;
    }

    int getSize()
    {
        return Size;
    }

    VeggiTopping getVeggi()
    {
        return veggi;
    }

    MeatTopping getMeat()
    {
        return meat;
    }

    double totalPrice()
    {
        double sum;
        sum = 9.0 + (double)Size;

        sum += veggi.totalPrice();
        sum += meat.totalPrice();

        return sum;
    }
}
