package edu.mu.pizza;

import java.util.ArrayList;
import java.util.List;

import edu.mu.Toppings;
import edu.mu.cooking.ICookingStrategy;

public class VegetarianPizza extends AbstractPizza {

    public VegetarianPizza() {
        super();
        this.priceWithoutToppings = 1.50; //set default price for VegetarianPizza
        this.toppingList = new ArrayList<>(); //initialize the toppings list
        //add default toppings specific to VegetarianPizza
        toppingList.add(Toppings.TOMATO);
        toppingList.add(Toppings.CHEESE);
        toppingList.add(Toppings.BELL_PEPPER);
        toppingList.add(Toppings.BLACK_OLIVE);
        toppingList.add(Toppings.MUSHROOM);
        updatePizzaPrice(); //initial total price calculation
    }

    public VegetarianPizza(List<Toppings> toppingList, double priceWithoutToppings, double totalPrice,
                           ICookingStrategy cookingStrategy, double cookingPrice) {
        super(toppingList, priceWithoutToppings, totalPrice,  cookingStrategy, cookingPrice);
    }

    public VegetarianPizza(VegetarianPizza vPizza) {
        super(new ArrayList<>(vPizza.toppingList), vPizza.priceWithoutToppings, vPizza.totalPrice, 
               vPizza.cookingStrategy, vPizza.cookingPrice);
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
        return "VegetarianPizza {" +
                "toppingList=" + toppingList +
                ", priceWithoutToppings=" + priceWithoutToppings +
                ", totalPrice=" + totalPrice +
                ", pizzaOrderID=" + pizzaOrderID +
                ", cookingStrategy=" + cookingStrategy;
    }
}