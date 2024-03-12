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
	////////////////////////////////////////////////////////////////////////////////////////////// 

	public boolean addNewToppingToPizza(int orderID, Toppings topping) {
	    for (AbstractPizza pizza : pizzaOrderList) {
	        if (pizza.getPizzaOrderID() == orderID) {
	            // Check if the pizza already has the topping
	            if (!pizza.getToppingList().contains(topping)) {
	                // Add the topping to the pizza
	                pizza.addTopping(topping);
	                // Update the pizza price
	                pizza.updatePizzaPrice();
	                return true;
	            } else {
	                // The topping already exists
	                return false;
	            }
	        }
	    }
	    // If the order ID doesn't match any pizza in the list
	    return false;
	}
	
	 
	public boolean removeToppingFromPizza(int orderID, Toppings topping) {
	    for (AbstractPizza pizza : pizzaOrderList) {
	        if (pizza.getPizzaOrderID() == orderID) {
	            // Check if the pizza has a topping to be removed
	            if (pizza.getToppingList().contains(topping)) {
	                // Remove the topping from pizza
	                pizza.removeTopping(topping);
	                // subtract it from the pizza's price
	                pizza.updatePizzaPrice(-topping.getTotalPrice());
	                return true;
	            } else {
	                // The topping doesnt exist in the pizza
	                return false;
	            }
	        }
	    }
	    // If the order ID doesn't match any pizza in the list
	    return false;
	}
	 
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
	        return totalPrice;
	    }
	}
	 
	public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) {
	    for (AbstractPizza pizza : pizzaOrderList) {
	        if (pizza.getPizzaOrderID() == orderID) {
	            // Instantiate the cooking strategy based on the cookingStrategyType
	            ICookingStrategy cookingStrategy = getCookingStrategy(cookingStrategyType);
	            if (cookingStrategy != null) {
	                // Assign the cooking strategy
	                pizza.setCookingStrategy(cookingStrategy);
	                // Call the cook function on the pizza
	                pizza.cook();
	                return true;
	            }
	            break; // Exit the loop if pizza is found
	        }
	    }
	    return false; // Return false when a pizza with the given orderID was not found
	}
	 
	 
	

	
	

	
	
}
