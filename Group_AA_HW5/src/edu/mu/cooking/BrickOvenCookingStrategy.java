package edu.mu.cooking;

import edu.mu.pizza.AbstractPizza;

public class BrickOvenCookingStrategy implements ICookingStrategy{

	public BrickOvenCookingStrategy() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public boolean cook(AbstractPizza pizza) {
		if(pizza != null)
		{
		pizza.setCookingPrice(10.0); //sets the price of the cooking to $10
		pizza.setCookingStrategy(this); //sets the cooking strategy to the current cooking strategy
		pizza.updatePizzaPrice(); //updates the price of the whole pizza
	
		return true; //returns true on success
		}
		else return false; //if no valid pizza was provided it will return false
	

}
	
}
