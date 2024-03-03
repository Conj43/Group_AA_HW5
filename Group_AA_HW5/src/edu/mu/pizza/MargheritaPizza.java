package edu.mu.pizza;

import java.util.List;

import edu.mu.Toppings;
import edu.mu.cooking.ICookingStrategy;

public class MargheritaPizza extends AbstractPizza{

	//default constructor
		public MargheritaPizza() {
		}

		
		//super constructor
		public MargheritaPizza(List<Toppings> toppingList, double priceWithoutToppings, double totalPrice, int pizzaOrderID,
				ICookingStrategy cookingStrategy, double cookingPrice) {
			super(toppingList, priceWithoutToppings, totalPrice, pizzaOrderID, cookingStrategy, cookingPrice);
		}
		
		//copy constructor
		public MargheritaPizza(HawaiianPizza mPizza) {
			this.toppingList = mPizza.toppingList;
			this.priceWithoutToppings = mPizza.priceWithoutToppings;
			this.totalPrice = mPizza.totalPrice;
			this.pizzaOrderID = mPizza.pizzaOrderID;
			this.cookingStrategy = mPizza.cookingStrategy;
			this.cookingPrice = mPizza.cookingPrice;
		}
		
		
		
		//generated toStrong method
		@Override
		public String toString() {
			return "MargheritaPizza [toppingList=" + toppingList + ", priceWithoutToppings=" + priceWithoutToppings
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
