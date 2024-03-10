package edu.mu.pizza;

import java.util.ArrayList;
import edu.mu.Toppings;
import edu.mu.cooking.ICookingStrategy;

public class SupremePizza extends AbstractPizza {

    public SupremePizza() {
        super();
        this.priceWithoutToppings = 3.50; //set default price for SupremePizza
        this.toppingList = new ArrayList<>(); //initialize the toppings list
        //add default toppings specific to SupremePizza
        toppingList.add(Toppings.TOMATO);
        toppingList.add(Toppings.CHEESE);
        toppingList.add(Toppings.BELL_PEPPER);
        toppingList.add(Toppings.ITALIAN_SAUSAGE);
        toppingList.add(Toppings.PEPPERONI);
        toppingList.add(Toppings.BLACK_OLIVE);
        toppingList.add(Toppings.MUSHROOM);
        updatePizzaPrice(); //initial total price calculation
    }

    public SupremePizza(List<Toppings> toppingList, double priceWithoutToppings, double totalPrice, int pizzaOrderID,
                        ICookingStrategy cookingStrategy, double cookingPrice) {
        super(toppingList, priceWithoutToppings, totalPrice, pizzaOrderID, cookingStrategy, cookingPrice);
    }

    public SupremePizza(SupremePizza sPizza) {
        super(new ArrayList<>(sPizza.toppingList), sPizza.priceWithoutToppings, sPizza.totalPrice, 
              sPizza.pizzaOrderID, sPizza.cookingStrategy, sPizza.cookingPrice);
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
        return "SupremePizza {" +
                "toppingList=" + toppingList +
                ", priceWithoutToppings=" + priceWithoutToppings +
                ", totalPrice=" + totalPrice +
                ", pizzaOrderID=" + pizzaOrderID +
                ", cookingStrategy=" + cookingStrategy +
                ", cookingPrice=" + cookingPrice +
                '}';
    }
}
