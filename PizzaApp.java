/**PizzaApp.java
 *
 * Description: A GUI app that let the user order
 *              multiple customized pizza.
 *
 * Date: 10/27/2018
 * @author: Joseph Chang
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PizzaApp extends Application
{
    private ArrayList<Pizza> pizzas;
    private Pizza current;
    private String strDouble;

    //buttons
    private sizeButtons sizeButton;
    private veggiCheckBox veggies;
    private meatCheckBox meats;
    private Button addToCart;
    private Button done;

    //texts
    private Label title;
    private Label sizeTitle;
    private Label veggiTitle;
    private Label meatTitle;
    private Label currentPrice;
    private Label totalPrice;

    //Layout container
    private HBox hBoxTitle;
    private HBox hBoxSize;
    private VBox vBoxsize;
    private VBox vBoxVeggi1;
    private VBox vBoxVeggi2;
    private VBox vBoxVeggi3;
    private HBox hBoxVeggiMid;
    private VBox vBoxVeggi;
    private VBox vBoxMeat1;
    private VBox vBoxMeat2;
    private VBox vBoxMeat3;
    private HBox hBoxMeatMid;
    private VBox vBoxMeat;
    private VBox checkOut;
    private HBox price;
    private VBox All;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        initialize();

        sizeButton.small.setOnAction(new sizeButtonHandler());
        sizeButton.medium.setOnAction(new sizeButtonHandler());
        sizeButton.large.setOnAction(new sizeButtonHandler());

        veggies.Pineapples.setOnAction(new veggiCheckBoxPineapple());
        veggies.ExtraPineapples.setOnAction(new veggiCheckBoxExtraPineapple());
        veggies.Peppers.setOnAction(new veggiCheckBoxHandler());
        veggies.Onions.setOnAction(new veggiCheckBoxHandler());
        veggies.Mushrooms.setOnAction(new veggiCheckBoxHandler());
        veggies.BananaPeppers.setOnAction(new veggiCheckBoxHandler());
        veggies.None.setOnAction(new veggiCheckBoxNone());

        meats.Ham.setOnAction(new meatCheckBoxHandler());
        meats.Pepperoni.setOnAction(new meatCheckBoxHandler());
        meats.Sausage.setOnAction(new meatCheckBoxHandler());
        meats.Salami.setOnAction(new meatCheckBoxHandler());
        meats.Chicken.setOnAction(new meatCheckBoxHandler());
        meats.Steak.setOnAction(new meatCheckBoxHandler());
        meats.None.setOnAction(new meatCheckBoxNone());

        addToCart.setOnAction(new addToCartButtonHandler());
        done.setOnAction(new doneButtonHandler());

        Scene scene = new Scene(All);

        primaryStage.setScene(scene);
        primaryStage.setTitle("PizzaApp");
        primaryStage.show();
    }

    //Being called while at the beginning of start
    private void initialize()
    {
        pizzas = new ArrayList<Pizza>();
        current = new Pizza();
        sizeButton = new sizeButtons();
        veggies = new veggiCheckBox();
        meats = new meatCheckBox();

        title = new Label("Build your Pizza:");
        sizeTitle = new Label("Size:");
        veggiTitle = new Label("Veggies topping:");
        meatTitle = new Label("Meats topping:");

        addToCart = new Button("Add to cart");
        done      = new Button("   Done!   ");

        strDouble = String.format("%.2f",11.50);
        currentPrice = new Label("Current pizza price: $"+ strDouble);
        strDouble = String.format("%.2f",0.00);
        totalPrice = new Label("Total price: $" + strDouble);

        hBoxSize = new HBox(40, sizeButton.small, sizeButton.medium, sizeButton.large);
        hBoxSize.setAlignment(Pos.CENTER);
        vBoxsize = new VBox(10, sizeTitle, hBoxSize);
        vBoxsize.setAlignment(Pos.CENTER);
        vBoxsize.setPadding(new Insets(20));

        vBoxVeggi1 = new VBox(10, veggies.Pineapples, veggies.Onions, veggies.None);
        vBoxVeggi2 = new VBox(10, veggies.ExtraPineapples, veggies.Mushrooms);
        vBoxVeggi3 = new VBox(10, veggies.Peppers, veggies.BananaPeppers);
        hBoxVeggiMid = new HBox(10, vBoxVeggi1, vBoxVeggi2, vBoxVeggi3);
        hBoxVeggiMid.setAlignment(Pos.TOP_CENTER);
        vBoxVeggi = new VBox(10, veggiTitle, hBoxVeggiMid);
        vBoxVeggi.setAlignment(Pos.CENTER);
        vBoxVeggi.setPadding(new Insets(20));

        vBoxMeat1 = new VBox(10, meats.Ham, meats.Salami, meats.None);
        vBoxMeat2 = new VBox(10, meats.Pepperoni, meats.Chicken);
        vBoxMeat3 = new VBox(10, meats.Sausage, meats.Steak);
        checkOut = new VBox(10, addToCart, done);

        hBoxMeatMid = new HBox(10, vBoxMeat1, vBoxMeat2, vBoxMeat3, checkOut);
        hBoxMeatMid.setAlignment(Pos.TOP_CENTER);

        vBoxMeat = new VBox(10, meatTitle, hBoxMeatMid);
        vBoxMeat.setAlignment(Pos.CENTER);
        vBoxMeat.setPadding(new Insets(20));

        price = new HBox(70, currentPrice, totalPrice);
        price.setAlignment(Pos.BOTTOM_CENTER);
        price.setPadding(new Insets(20));

        hBoxTitle = new HBox(title);
        hBoxTitle.setAlignment(Pos.CENTER);
        hBoxTitle.setPadding(new Insets(20));

        All = new VBox(0, hBoxTitle, vBoxsize, vBoxVeggi, vBoxMeat, price);

    }

    //reset will initialize the GUI to the default option
    //Being call while the add to cart button is pressed
    private void reset()
    {
        veggies.Pineapples.setSelected(true);
        veggies.ExtraPineapples.setSelected(false);
        veggies.Peppers.setSelected(false);
        veggies.Onions.setSelected(false);
        veggies.Mushrooms.setSelected(false);
        veggies.BananaPeppers.setSelected(false);
        veggies.None.setSelected(false);

        veggies.Pineapples.setTextFill(Color.BLACK);
        veggies.ExtraPineapples.setTextFill(Color.BLACK);
        veggies.Peppers.setTextFill(Color.BLACK);
        veggies.Onions.setTextFill(Color.BLACK);
        veggies.Mushrooms.setTextFill(Color.BLACK);
        veggies.BananaPeppers.setTextFill(Color.BLACK);

        meats.Ham.setSelected(false);
        meats.Pepperoni.setSelected(false);
        meats.Sausage.setSelected(false);
        meats.Salami.setSelected(false);
        meats.Chicken.setSelected(false);
        meats.Steak.setSelected(false);
        meats.None.setSelected(false);

        meats.Ham.setTextFill(Color.BLACK);
        meats.Pepperoni.setTextFill(Color.BLACK);
        meats.Sausage.setTextFill(Color.BLACK);
        meats.Salami.setTextFill(Color.BLACK);
        meats.Chicken.setTextFill(Color.BLACK);
        meats.Steak.setTextFill(Color.BLACK);

        sizeButton.medium.setSelected(true);

        strDouble = String.format("%.2f",11.50);
        currentPrice.setText("Current pizza price: $" + strDouble);
    }

    //Being called while the size section buttons are pressed
    private class sizeButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            double priceOfThis = sizeButton.clicked(current);
            strDouble = String.format("%.2f", priceOfThis);
            currentPrice.setText("Current pizza price: $" + strDouble);
        }
    }

    //Being called while the veggi section boxes are checked except Pineapple, ExtraPineapple, or None
    private class veggiCheckBoxHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            double priceOfThis = veggies.clicked(current);
            strDouble = String.format("%.2f", priceOfThis);
            currentPrice.setText("Current pizza price: $" + strDouble);
        }
    }

    //Being called while Pineapple box is checked
    private class veggiCheckBoxPineapple implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if(!veggies.Pineapples.isSelected())
            {
                current.getVeggi().unSelectPinapple();
            }
            else
            {
                if(veggies.ExtraPineapples.isSelected())
                    veggies.ExtraPineapples.setSelected(false);

                current.getVeggi().selectPinapple();
                veggies.Pineapples.setSelected(true);
            }


            double priceOfThis = veggies.clicked(current);
            strDouble = String.format("%.2f", priceOfThis);
            currentPrice.setText("Current pizza price: $" + strDouble);
        }
    }

    //Being called while ExtraPineapple box is checked
    private class veggiCheckBoxExtraPineapple implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            if(!veggies.ExtraPineapples.isSelected())
            {
                current.getVeggi().unSelectExtraPinapple();
                veggies.ExtraPineapples.setSelected(false);
            }
            else
            {
                if(veggies.Pineapples.isSelected())
                    veggies.Pineapples.setSelected(false);

                current.getVeggi().selectExtraPinapple();
                veggies.ExtraPineapples.setSelected(true);
            }


            double priceOfThis = veggies.clicked(current);
            strDouble = String.format("%.2f", priceOfThis);
            currentPrice.setText("Current pizza price: $" + strDouble);
        }
    }

    //Being called while None box in veggi section is checked
    private class veggiCheckBoxNone implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            double priceOfThis = veggies.clicked(current);
            if(veggies.None.isSelected())
            {
                veggies.Pineapples.setTextFill(Color.GRAY);
                veggies.ExtraPineapples.setTextFill(Color.GRAY);
                veggies.Peppers.setTextFill(Color.GRAY);
                veggies.Onions.setTextFill(Color.GRAY);
                veggies.Mushrooms.setTextFill(Color.GRAY);
                veggies.BananaPeppers.setTextFill(Color.GRAY);
            }
            else
            {
                veggies.Pineapples.setTextFill(Color.BLACK);
                veggies.ExtraPineapples.setTextFill(Color.BLACK);
                veggies.Peppers.setTextFill(Color.BLACK);
                veggies.Onions.setTextFill(Color.BLACK);
                veggies.Mushrooms.setTextFill(Color.BLACK);
                veggies.BananaPeppers.setTextFill(Color.BLACK);
            }
            strDouble = String.format("%.2f", priceOfThis);
            currentPrice.setText("Current pizza price: $" + strDouble);
        }
    }

    //Being called while the meat section boxes are checked except None
    private class meatCheckBoxHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            double priceOfThis = meats.clicked(current);
            strDouble = String.format("%.2f", priceOfThis);
            currentPrice.setText("Current pizza price: $" + strDouble);
        }
    }

    //Being called while None box in meat section is checked
    private class meatCheckBoxNone implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            double priceOfThis = meats.clicked(current);
            if(meats.None.isSelected())
            {
                meats.Ham.setTextFill(Color.GRAY);
                meats.Pepperoni.setTextFill(Color.GRAY);
                meats.Sausage.setTextFill(Color.GRAY);
                meats.Salami.setTextFill(Color.GRAY);
                meats.Chicken.setTextFill(Color.GRAY);
                meats.Steak.setTextFill(Color.GRAY);
            }
            else
            {
                meats.Ham.setTextFill(Color.BLACK);
                meats.Pepperoni.setTextFill(Color.BLACK);
                meats.Sausage.setTextFill(Color.BLACK);
                meats.Salami.setTextFill(Color.BLACK);
                meats.Chicken.setTextFill(Color.BLACK);
                meats.Steak.setTextFill(Color.BLACK);
            }
            strDouble = String.format("%.2f", priceOfThis);
            currentPrice.setText("Current pizza price: $" + strDouble);
        }
    }

    //Being called while addToCart button is pressed
    private class addToCartButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            pizzas.add(current);
            current = new Pizza();
            reset();

            double sum = 0;
            int i = 0;
            while(i < pizzas.size())
            {
                sum += pizzas.get(i).totalPrice();
                i++;
            }
            strDouble = String.format("%.2f", sum);
            totalPrice.setText("Total price: $" + strDouble);
        }
    }

    //Being called while done button is pressed
    private class doneButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event) {
            printReceipt print = new printReceipt(pizzas);
        }
    }

    public static void main(String args[])
    {
        launch(args);
    }

    //sizeButtons class
    private class sizeButtons
    {
        public RadioButton small;
        public RadioButton medium;
        public RadioButton large;
        public ToggleGroup sizeGroup;

        public sizeButtons()
        {
            small = new RadioButton("Small");
            medium = new RadioButton("Medium");
            large = new RadioButton("Large");
            sizeGroup = new ToggleGroup();

            small.setToggleGroup(sizeGroup);
            medium.setToggleGroup(sizeGroup);
            large.setToggleGroup(sizeGroup);

            medium.setSelected(true);
        }

        public int getSize()
        {
            if(small.isSelected())
                return 1;
            else if(medium.isSelected())
                return 2;
            else
                return 3;
        }

        //return the current price
        public double clicked(Pizza pizza)
        {
            pizza.setSize(getSize());
            return pizza.totalPrice();
        }
    }

    //veggi check boxes class
    private class veggiCheckBox
    {
        public CheckBox Pineapples;
        public CheckBox ExtraPineapples;
        public CheckBox Peppers;
        public CheckBox Onions;
        public CheckBox Mushrooms;
        public CheckBox BananaPeppers;
        public CheckBox None;

        public veggiCheckBox()
        {
            Pineapples = new CheckBox("Pineapples"); //need to unselect the other one
            ExtraPineapples = new CheckBox("Extra Pineapples");
            Peppers = new CheckBox("Peppers");
            Onions = new CheckBox("Onions");
            Mushrooms = new CheckBox("Mushrooms");
            BananaPeppers = new CheckBox("Banana Peppers");
            None = new CheckBox("None");

            Pineapples.setSelected(true);
        }

        //return the current price;
        public double clicked(Pizza pizza)
        {
            pizza.getVeggi().Peppers = Peppers.isSelected();
            pizza.getVeggi().Onions = Onions.isSelected();
            pizza.getVeggi().Mushrooms = Mushrooms.isSelected();
            pizza.getVeggi().BananaPeppers = BananaPeppers.isSelected();

            if(None.isSelected())
            {
                pizza.getVeggi().selectNone();

                Pineapples.setSelected(false);
                ExtraPineapples.setSelected(false);
                Peppers.setSelected(false);
                Onions.setSelected(false);
                Mushrooms.setSelected(false);
                BananaPeppers.setSelected(false);
            }
            else
                pizza.getVeggi().unselectNone();

            return pizza.totalPrice();
        }

    }

    //meat check boxes class
    private class meatCheckBox
    {
        public CheckBox Ham;
        public CheckBox Pepperoni;
        public CheckBox Sausage;
        public CheckBox Salami;
        public CheckBox Chicken;
        public CheckBox Steak;
        public CheckBox None;

        public meatCheckBox()
        {
            Ham = new CheckBox("Ham");
            Pepperoni = new CheckBox("Pepperoni");
            Sausage = new CheckBox("Sausage");
            Salami = new CheckBox("Salami");
            Chicken = new CheckBox("Chicken");
            Steak = new CheckBox("Steak");
            None = new CheckBox("None");
        }

        //return the current price;
        public double clicked(Pizza pizza)
        {
            pizza.getMeat().Ham = Ham.isSelected();
            pizza.getMeat().Pepperoni = Pepperoni.isSelected();
            pizza.getMeat().Sausage = Sausage.isSelected();
            pizza.getMeat().Salami = Salami.isSelected();
            pizza.getMeat().Chicken = Chicken.isSelected();
            pizza.getMeat().Steak = Steak.isSelected();

            if(None.isSelected())
            {
                pizza.getMeat().selectNone();

                Ham.setSelected(false);
                Pepperoni.setSelected(false);
                Sausage.setSelected(false);
                Salami.setSelected(false);
                Chicken.setSelected(false);
                Steak.setSelected(false);
            }
            else
                pizza.getMeat().unSelectNone();

            return pizza.totalPrice();
        }
    }
}
