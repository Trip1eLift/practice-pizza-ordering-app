/**VeggiTopping.java
 *
 * Description: Contain the veggiTopping data and logic
 *              to power Pizza.java
 *
 * Date: 10/27/2018
 * @author: Joseph Chang
 */

public class VeggiTopping
{
    private boolean Pineapples;
    private boolean ExtraPineapples;
    public boolean Peppers;
    public boolean Onions;
    public boolean Mushrooms;
    public boolean BananaPeppers;
    private boolean None;

    VeggiTopping()
    {
        Pineapples = true;
    }

    void selectPinapple()
    {
        ExtraPineapples = false;
        Pineapples = true;
    }

    void unSelectPinapple()
    {
        Pineapples = false;
    }

    boolean getPinapple()
    {
        return Pineapples;
    }

    void selectExtraPinapple()
    {
        Pineapples = false;
        ExtraPineapples = true;
    }

    void unSelectExtraPinapple()
    {
        ExtraPineapples = false;
    }

    boolean getExtraPinapple()
    {
        return ExtraPineapples;
    }

    void selectNone()
    {
        Pineapples = false;
        ExtraPineapples = false;
        Peppers = false;
        Onions = false;
        Mushrooms = false;
        BananaPeppers = false;

        None = true;
    }

    void unselectNone()
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

        if(Pineapples)
            sum += 0.5;
        if(ExtraPineapples)
            sum += 0.5;
        if(Peppers)
            sum += 0.5;
        if(Onions)
            sum += 0.5;
        if(Mushrooms)
            sum += 0.5;
        if(BananaPeppers)
            sum += 0.5;

        return sum;
    }
}
