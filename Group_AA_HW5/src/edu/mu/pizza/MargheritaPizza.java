
package edu.mu.pizza;

import java.util.ArrayList;
import java.util.List;

import edu.mu.Toppings;
import edu.mu.cooking.ICookingStrategy;

public class MargheritaPizza extends AbstractPizza {

    //default constructor initializes with default toppings
    public MargheritaPizza() {
        super();
        this.priceWithoutToppings = 2.50; //set default price for MargheritaPizza
        this.toppingList = new ArrayList<>(); //initialize the toppings list
        //adds default toppings specific to MargheritaPizza
        toppingList.add(Toppings.TOMATO);
        toppingList.add(Toppings.CHEESE);
        //calculates the  initial total price including toppings
        updatePizzaPrice();
    }

    //parameterized constructor for custom orders
    public MargheritaPizza(List<Toppings> toppingList, double priceWithoutToppings, double totalPrice, 
                           ICookingStrategy cookingStrategy, double cookingPrice) {
        super(toppingList, priceWithoutToppings, totalPrice, cookingStrategy, cookingPrice);
    }

    //copy constructor creates a deep copy of MargheritaPizza
    public MargheritaPizza(MargheritaPizza mPizza) {
        super(new ArrayList<>(mPizza.toppingList), mPizza.priceWithoutToppings, mPizza.totalPrice, 
              mPizza.cookingStrategy, mPizza.cookingPrice);
    }
    
    @Override
    protected double addToppingsToPrice(double priceWithoutToppings) { //adds total price of toppings to total price of pizza
        double toppingsPrice = 0;
        for (Toppings topping : toppingList) {
            toppingsPrice += topping.getToppingPrice();
        }
        return priceWithoutToppings + toppingsPrice;
    }

    @Override
    public double updatePizzaPrice() {  //updates total price including toppings and cooking style
        this.totalPrice = addToppingsToPrice(this.priceWithoutToppings);
        this.totalPrice += this.cookingPrice;
        return this.totalPrice;
    }

    @Override
    public String toString() {
        return "MargheritaPizza {" +
                "toppingList=" + toppingList +
                ", priceWithoutToppings=" + priceWithoutToppings +
                ", totalPrice=" + totalPrice +
                ", pizzaOrderID=" + pizzaOrderID +
                ", cookingStrategy=" + cookingStrategy +
                ", cookingPrice=" + cookingPrice +
                '}';
    }

}



