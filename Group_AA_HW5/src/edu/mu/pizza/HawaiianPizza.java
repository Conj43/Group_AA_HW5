package edu.mu.pizza;


import java.util.List;

import edu.mu.Toppings;
import edu.mu.cooking.ICookingStrategy;

public class HawaiianPizza extends AbstractPizza{

	//default constructor
	public HawaiianPizza() {
	}

	
	//super constructor
	public HawaiianPizza(List<Toppings> toppingList, double priceWithoutToppings, double totalPrice, int pizzaOrderID,
			ICookingStrategy cookingStrategy, double cookingPrice) {
		super(toppingList, priceWithoutToppings, totalPrice, pizzaOrderID, cookingStrategy, cookingPrice);
	}
	
	//copy constructor
	public HawaiianPizza(HawaiianPizza hPizza) {
		this.toppingList = hPizza.toppingList;
		this.priceWithoutToppings = hPizza.priceWithoutToppings;
		this.totalPrice = hPizza.totalPrice;
		this.pizzaOrderID = hPizza.pizzaOrderID;
		this.cookingStrategy = hPizza.cookingStrategy;
		this.cookingPrice = hPizza.cookingPrice;
	}
	
	
	//generated toString method
	@Override
	public String toString() {
		return "HawaiianPizza [toppingList=" + toppingList + ", priceWithoutToppings=" + priceWithoutToppings
				+ ", totalPrice=" + totalPrice + ", pizzaOrderID=" + pizzaOrderID + ", cookingStrategy="
				+ cookingStrategy + ", cookingPrice=" + cookingPrice + "]";
	}


	@Override
	protected double addTopingsToPrice(double priceWithoutToppings) {

		return 0;
	}


	@Override
	public double updatePizzaPrice() {

		return 0;
	}
	
	

}
//