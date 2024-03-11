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

    public VegetarianPizza(List<Toppings> toppingList, double priceWithoutToppings, double totalPrice, int pizzaOrderID,
                           ICookingStrategy cookingStrategy, double cookingPrice) {
        super(toppingList, priceWithoutToppings, totalPrice, pizzaOrderID, cookingStrategy, cookingPrice);
    }

    public VegetarianPizza(VegetarianPizza vPizza) {
        super(new ArrayList<>(vPizza.toppingList), vPizza.priceWithoutToppings, vPizza.totalPrice, 
              vPizza.pizzaOrderID, vPizza.cookingStrategy, vPizza.cookingPrice);
    }

    @Override
    protected double addTopingsToPrice(double priceWithoutToppings) {
        double toppingsPrice = toppingList.stream().mapToDouble(Toppings::getPrice).sum();
        return priceWithoutToppings + toppingsPrice;
    }

    @Override
    public double updatePizzaPrice() {
        this.totalPrice = addTopingsToPrice(this.priceWithoutToppings);
        return this.totalPrice;
    }

    @Override
    public String toString() {
        return "VegetarianPizza {" +
                "toppingList=" + toppingList +
                ", priceWithoutToppings=" + priceWithoutToppings +
                ", totalPrice=" + totalPrice +
                ", pizzaOrderID=" + pizzaOrderID +
                ", cookingStrategy=" + cookingStrategy
    }
}