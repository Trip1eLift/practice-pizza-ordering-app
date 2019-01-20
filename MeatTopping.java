/**MeatTopping.java
 *
 * Description: Contain the MeatTopping data and logic
 *              to power Pizza.java
 *
 * Date: 10/27/2018
 * @author: Joseph Chang
 */

public class MeatTopping
{
    public boolean Ham;
    public boolean Pepperoni;
    public boolean Sausage;
    public boolean Salami;
    public boolean Chicken;
    public boolean Steak;
    private boolean None;

    void selectNone()
    {
        Ham = false;
        Pepperoni = false;
        Sausage = false;
        Salami = false;
        Chicken = false;
        Steak = false;

        None = true;
    }

    void unSelectNone()
    {
        None = false;
    }

    boolean getNone()
    {
        return None;
    }

    double totalPrice()
    {
        double sum = 0;

        if(Ham)
            sum++;
        if(Pepperoni)
            sum++;
        if(Sausage)
            sum++;
        if(Salami)
            sum++;
        if(Chicken)
            sum++;
        if(Steak)
            sum++;

        return sum;
    }
}
