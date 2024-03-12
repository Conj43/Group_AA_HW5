package edu.mu.pizza;

import edu.mu.PizzaType;

public class PizzaCookingFactory {
	

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
		
		pizza.setPizzaOrderID(++(AbstractPizza.orderIDCounter)); // sets the order id and increments it using static variable
		
		return pizza;
		
		
	}
}
