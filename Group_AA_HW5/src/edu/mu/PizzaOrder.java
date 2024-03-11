package edu.mu;

import java.util.ArrayList;
import java.util.List;

import edu.mu.cooking.*;
import edu.mu.pizza.*;

public class PizzaOrder {
	
	private PizzaCookingFactory pizzaFactory;
	private ICookingStrategy cookingStrategy;
	private List<AbstractPizza> pizzaOrderList;
	

	public PizzaOrder() {
		pizzaFactory = new PizzaCookingFactory();
		pizzaOrderList = new ArrayList<>();
	}
	
	public void printListOfToppingsByPizzaOrderID(int orderID) {
		boolean found = false;
		if(!pizzaOrderList.isEmpty()) {
			for (AbstractPizza pizza : pizzaOrderList) {
				if(pizza.getPizzaOrderID() == orderID) {
					found = true;
					for (Toppings toppings : pizza.getToppingList()) {
						System.out.println(toppings);
					}
				}
			}
		}
		else System.out.println("Error! List is Empty.");
		if(!found) {
			System.out.println("There is no Order with the given Order ID.");
		}
	}
	
	public void printPizzaOrderCart(int orderID) {
		if(!pizzaOrderList.isEmpty()) {
			for(AbstractPizza pizza : pizzaOrderList) {
				String pizzaString = pizza.toString();
				System.out.println(pizzaString);
			}
		}
		else System.out.println("The pizzaOrderList is empty!");
	}
	
	public AbstractPizza getPizzaByOrderID(int orderID) {
		if(!pizzaOrderList.isEmpty()) {
			for(AbstractPizza pizza : pizzaOrderList) {
				if(pizza.getPizzaOrderID() == orderID) {
					return pizza;
				}
			}
		}
		return null;
	}
	
	public boolean addPizzaToCart(PizzaType pizzaType) {
		AbstractPizza newPizza = pizzaFactory.createPizza(pizzaType);
		return pizzaOrderList.add(newPizza);
	}

	
	

	
	
}
