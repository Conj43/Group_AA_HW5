package edu.mu.pizza;

import edu.mu.cooking.ICookingStrategy;
import edu.mu.Toppings; 
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPizza {
    protected List<Toppings> toppingList;
    protected double priceWithoutToppings;
    protected double totalPrice;
    protected int pizzaOrderID;
    protected static int orderIDCounter = 0; //initialized to ensure unique ID assignment
    protected ICookingStrategy cookingStrategy;
    protected double cookingPrice;

    // Enhanced default constructor
    public AbstractPizza() {
        this.toppingList = new ArrayList<>(); //ensure toppingList is never null
        
    }

    //modified parameterized constructor for custom pizza creation
    public AbstractPizza(List<Toppings> toppingList, double priceWithoutToppings, double totalPrice,
                         ICookingStrategy cookingStrategy, double cookingPrice) {
        this(); //call default constructor to initialize list and assign unique order ID
        this.toppingList.addAll(toppingList); //add provided toppings to the list
        this.priceWithoutToppings = priceWithoutToppings;
        this.totalPrice = totalPrice; //assume this might need recalculation based on toppings
        this.cookingStrategy = cookingStrategy;
        this.cookingPrice = cookingPrice;
    }

    public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setPizzaOrderID(int pizzaOrderID) {
		this.pizzaOrderID = pizzaOrderID;
	}

	//abstract method for adding topping prices to base price, to be implemented by subclasses
    protected abstract double addToppingsToPrice(double priceWithoutToppings);

    //abstract method for updating the total pizza price, to be implemented by subclasses
    public abstract double updatePizzaPrice();

    //getter and setter methods
    public List<Toppings> getToppingList() {
        return toppingList;
    }

    public void setToppingList(List<Toppings> toppingList) {
        this.toppingList = new ArrayList<>(toppingList);
        updatePizzaPrice(); //recalculate total price with new toppings
    }

    public double getPriceWithoutToppings() {
        return priceWithoutToppings;
    }

    public void setPriceWithoutToppings(double priceWithoutToppings) {
        this.priceWithoutToppings = priceWithoutToppings;
        updatePizzaPrice(); //recalculate total price due to base price change
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getPizzaOrderID() {
        return pizzaOrderID;
    }

    public ICookingStrategy getCookingStrategy() {
        return cookingStrategy;
    }

    public void setCookingStrategy(ICookingStrategy cookingStrategy) {
        this.cookingStrategy = cookingStrategy;
    }

    public double getCookingPrice() {
        return cookingPrice;
    }

    public void setCookingPrice(double cookingPrice) {
        this.cookingPrice = cookingPrice;
    }

    @Override
    public String toString() {
        return "AbstractPizza {" +
                "toppingList=" + toppingList +
                ", priceWithoutToppings=" + priceWithoutToppings +
                ", totalPrice=" + totalPrice +
                ", pizzaOrderID=" + pizzaOrderID +
                ", cookingStrategy=" + cookingStrategy +
                ", cookingPrice=" + cookingPrice +
                '}';
    }
}	

	
	
	
