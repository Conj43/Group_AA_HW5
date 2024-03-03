package edu.mu.pizza;

import java.util.List;

import edu.mu.Toppings;
import edu.mu.cooking.ICookingStrategy;

public class VegetarianPizza extends AbstractPizza{

		//default constructor
			public VegetarianPizza() {
			}

			
			//super constructor
			public VegetarianPizza(List<Toppings> toppingList, double priceWithoutToppings, double totalPrice, int pizzaOrderID,
					ICookingStrategy cookingStrategy, double cookingPrice) {
				super(toppingList, priceWithoutToppings, totalPrice, pizzaOrderID, cookingStrategy, cookingPrice);
			}
			
			//copy constructor
			public VegetarianPizza(HawaiianPizza vPizza) {
				this.toppingList = vPizza.toppingList;
				this.priceWithoutToppings = vPizza.priceWithoutToppings;
				this.totalPrice = vPizza.totalPrice;
				this.pizzaOrderID = vPizza.pizzaOrderID;
				this.cookingStrategy = vPizza.cookingStrategy;
				this.cookingPrice = vPizza.cookingPrice;
			}
			
			
			//generated toString method
			@Override
			public String toString() {
				return "VegetarianPizza [toppingList=" + toppingList + ", priceWithoutToppings=" + priceWithoutToppings
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
