package edu.mu.pizza;

import java.util.List;

import edu.mu.Toppings;
import edu.mu.cooking.ICookingStrategy;

public class SupremePizza extends AbstractPizza{

	//default constructor
		public SupremePizza() {
		}

		
		//super constructor
		public SupremePizza(List<Toppings> toppingList, double priceWithoutToppings, double totalPrice, int pizzaOrderID,
				ICookingStrategy cookingStrategy, double cookingPrice) {
			super(toppingList, priceWithoutToppings, totalPrice, pizzaOrderID, cookingStrategy, cookingPrice);
		}
		
		//copy constructor
		public SupremePizza(HawaiianPizza sPizza) {
			this.toppingList = sPizza.toppingList;
			this.priceWithoutToppings = sPizza.priceWithoutToppings;
			this.totalPrice = sPizza.totalPrice;
			this.pizzaOrderID = sPizza.pizzaOrderID;
			this.cookingStrategy = sPizza.cookingStrategy;
			this.cookingPrice = sPizza.cookingPrice;
		}
		
		
		//generated toString method
		@Override
		public String toString() {
			return "SupremePizza [toppingList=" + toppingList + ", priceWithoutToppings=" + priceWithoutToppings
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
