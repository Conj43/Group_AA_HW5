package edu.mu;

import edu.mu.pizza.AbstractPizza;
import edu.mu.pizza.HawaiianPizza;
import edu.mu.pizza.MargheritaPizza;
import edu.mu.pizza.SupremePizza;
import edu.mu.pizza.VegetarianPizza;

public class PizzaCookingFactory {
	private static int orderIDCounter = 0; //makes a static order id that will keep track of all pizza ids

	public PizzaCookingFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public AbstractPizza createPizza(PizzaType pizzaType) {
		AbstractPizza pizza; //creates a pizza
		switch(pizzaType)
		{
		case MARGHERITA:
			pizza= new MargheritaPizza(); //initializes the pizza as a margherita
			break;
		case VEGETARIAN:
			pizza = new VegetarianPizza(); //initializes the pizza as a Vegetarian
			break;
		case SUPREME:
			pizza = new SupremePizza(); //initializes the pizza as a Supreme
			break;
		case HAWAIIAN:
			pizza = new HawaiianPizza(); //initializes the pizza as a Hawaiian
			break;
		default:
			return null; //if no pizza type was given it defaults to a null return
		}
		
		pizza.setPizzaOrderID(++orderIDCounter); // sets the order id and increments it
		
		return pizza;
		
		
	}
}
