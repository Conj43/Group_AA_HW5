package edu.mu;

import java.util.ArrayList;
import java.util.List;

import edu.mu.cooking.*;
import edu.mu.pizza.*;

public class PizzaOrder {
	
	
	private PizzaCookingFactory pizzaFactory;
	private ICookingStrategy cookingStrategy;
	private List<AbstractPizza> pizzaOrderList;
	

	public PizzaOrder() { //default constructor
		pizzaFactory = new PizzaCookingFactory(); //creates instance of pizza cooking factory
		pizzaOrderList = new ArrayList<>(); //instanitates pizzaOrderList as an array list
	}
	
	
	//prints list of toppings of a pizza with order id that is passed in
	public void printListOfToppingsByPizzaOrderID(int orderID) {
		boolean found = false;
		if(!pizzaOrderList.isEmpty()) { //make sure list is not empty
			for (AbstractPizza pizza : pizzaOrderList) {
				if(pizza.getPizzaOrderID() == orderID) { //if we find the correct pizza
					found = true; //changed return value to true because we found pizza and will print topping list
					for (Toppings toppings : pizza.getToppingList()) {
						System.out.println(toppings); //print each topping one by one
					}
				}
			}
		}
		else System.out.println("Error! List is Empty."); //if list is empty, print message
		if(!found) {
			System.out.println("There is no Order with the given Order ID."); //if we dont find the prder id, print it out
		}
	}
	
	//prints all pizzas in pizza order list (i think there isnt supposed to be a parameter but i left it because it is like that on the assignment doc)
	public void printPizzaOrderCart(int orderID) {
		if(!pizzaOrderList.isEmpty()) { //make sure list is not empty
			for(AbstractPizza pizza : pizzaOrderList) {
				String pizzaString = pizza.toString(); //use to string method to print info of each pizza
				System.out.println(pizzaString);
			}
		}
		else System.out.println("The pizzaOrderList is empty!"); //if list is empty, print it out
	}
	
	//finds a pizza using its order ID and returns it
	public AbstractPizza getPizzaByOrderID(int orderID) {
		if(!pizzaOrderList.isEmpty()) {
			for(AbstractPizza pizza : pizzaOrderList) {
				if(pizza.getPizzaOrderID() == orderID) { //loop through until you find pizza with given id
					return pizza;
				}
			}
		}
		return null; //if list is empty or id is not found, return null
	}
	
	//creates a new pizza of given type and adds it to pizza order list
	public boolean addPizzaToCart(PizzaType pizzaType) {
		AbstractPizza newPizza = pizzaFactory.createPizza(pizzaType); //use pizza factory to make it much easier to create a new pizza
		return pizzaOrderList.add(newPizza); //returns true on success, false on failure
	}
	
	//method adds a new topping to a pizza and finds is using order ID, returns true on success, false on failure
	public boolean addNewToppingToPizza(int orderID, Toppings topping) {
	    AbstractPizza pizza = getPizzaByOrderID(orderID); //use a method we already implemented to find pizza
	        if(pizza != null) {
	            if (!pizza.getToppingList().contains(topping)) { //check if it already is on the pizza
	                // Add the topping to the pizza
	            	List<Toppings> currentList = pizza.getToppingList();
	            	currentList.add(topping);
	                pizza.setToppingList(currentList);
	                // Update the pizza price
	                pizza.updatePizzaPrice();
	                return true;
	            }
	            } else {
	                // the pizza was not found
	                return false;
	            }
	        return false; //if pizza already had that topping
	        
	}
	    
	   
	
	 //removes a topping from a pizza list, returns true on success, false on failure
	public boolean removeToppingFromPizza(int orderID, Toppings topping) {
		AbstractPizza pizza = getPizzaByOrderID(orderID); //use a method we already implemented to find pizza
        if(pizza != null) {
	            // Check if the pizza has a topping to be removed
	            if (pizza.getToppingList().contains(topping)) {
	                // Remove the topping from pizza
	            	List<Toppings> currentToppings = pizza.getToppingList();
	            	currentToppings.remove(topping);
	                pizza.setToppingList(currentToppings);
	                // subtract it from the pizza's price
	                pizza.updatePizzaPrice();
	                return true;
	            }
	            } else {
	                
	                return false; //the pizza with given order id was not found
	            }
        	return false; // The topping doesnt exist in the pizza
	        }
	    
	   
	 //checks is any pizza is uncooked, returns true if there are one or more pizzas without a cooking strategy, false if all pizzas have a cooking strategy
	public boolean isThereAnyUncookedPizza() {
	    for (AbstractPizza pizza : pizzaOrderList) {
	        if (pizza.getCookingStrategy() == null) {
	            // Found a pizza without a cooking strategy
	            return true;
	        }
	    }
	    // All pizzas have a cooking strategy assigned
	    return false;
	}
	 
	//throws an exception if there is uncooked pizza if the cart, returns total price of all pizzas in card if all pizzas have been cooked
	public double checkout() throws Exception {
	    // Check for uncooked pizzas
	    if (isThereAnyUncookedPizza()) {
	        // If there are uncooked pizzas, throw an exception
	        throw new Exception("Checkout failed: There are uncooked pizzas in the order.");
	    } else {
	        // All pizzas are cooked, noe calculate the total price
	        double totalPrice = 0.0;
	        for (AbstractPizza pizza : pizzaOrderList) {
	            totalPrice += pizza.getTotalPrice(); 
	        
	    }
	        return totalPrice;
	    }
	   
	}
	 //uses order id to set cooking strategy of a pizza
	public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) {
	   if(pizzaOrderList.isEmpty()) {
		   return false; //if there are no pizzas is in the list, return false
	   }
	   else {
		for (AbstractPizza pizza : pizzaOrderList) {
	        if (pizza.getPizzaOrderID() == orderID) { //loop through and find pizza with given order id
	           
	            if(cookingStrategyType.equals(CookingStyleType.BRICK_OVEN)) { //check to see which type it should be set to
	            	cookingStrategy = new BrickOvenCookingStrategy();
	            	cookingStrategy.cook(pizza); //cook method assigns cooking strategy for given pizza 
	            	return true; //return true on sccuess
	            }
	            else if(cookingStrategyType.equals(CookingStyleType.MICROWAVE)) {
	            	cookingStrategy = new MicrowaveCookingStrategy();
	            	cookingStrategy.cook(pizza);
	            	return true;
	            }
	            else if(cookingStrategyType.equals(CookingStyleType.CONVENTIONAL_OVEN)) {
	            	cookingStrategy = new ConventionalCookingStrategy();
	            	cookingStrategy.cook(pizza);
	            	return true;
	            }
	           
	            
	        }
	    }
	   }
	    return false; // Return false when if pizza with the given orderID was not found
	}
	 
	 
	

	
	

	
	
}
