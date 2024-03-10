package edu.mu.pizza;

import java.util.ArrayList;
import edu.mu.Toppings;
import edu.mu.cooking.ICookingStrategy;

public class HawaiianPizza extends AbstractPizza {

    //default constructor initializes with default toppings
    public HawaiianPizza() {
        super();
        this.priceWithoutToppings = 3.00; //set default price for HawaiianPizza
        this.toppingList = new ArrayList<>(); //initialize the toppings list
        //adds default toppings specific to HawaiianPizza
        toppingList.add(Toppings.CANADIAN_BACON);
        toppingList.add(Toppings.CHEESE);
        toppingList.add(Toppings.PINEAPPLE);
        //this calculates the initial total price including toppings
        updatePizzaPrice();
    }

    //parameterized constructor for custom orders
    public HawaiianPizza(List<Toppings> toppingList, double priceWithoutToppings, double totalPrice, int pizzaOrderID,
                         ICookingStrategy cookingStrategy, double cookingPrice) {
        super(toppingList, priceWithoutToppings, totalPrice, pizzaOrderID, cookingStrategy, cookingPrice);
    }

    //copy constructor creates a deep copy of HawaiianPizza
    public HawaiianPizza(HawaiianPizza hPizza) {
        super(new ArrayList<>(hPizza.toppingList), hPizza.priceWithoutToppings, hPizza.totalPrice, 
              hPizza.pizzaOrderID, hPizza.cookingStrategy, hPizza.cookingPrice);
    }
    
    @Override
    protected double addTopingsToPrice(double priceWithoutToppings) {
        double toppingsPrice = 0;
        for (Toppings topping : toppingList) {
            toppingsPrice += topping.getPrice(); 
        }
        return priceWithoutToppings + toppingsPrice;
    }

    @Override
    public double updatePizzaPrice() {
        this.totalPrice = addTopingsToPrice(this.priceWithoutToppings);
        return this.totalPrice;
    }

    @Override
    public String toString() {
        return "HawaiianPizza {" +
                "toppingList=" + toppingList +
                ", priceWithoutToppings=" + priceWithoutToppings +
                ", totalPrice=" + totalPrice +
                ", pizzaOrderID=" + pizzaOrderID +
                ", cookingStrategy=" + cookingStrategy +
                ", cookingPrice=" + cookingPrice +
                '}';
    }
}
