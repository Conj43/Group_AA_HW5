package edu.mu;

public enum Toppings {
	
	TOMATO(1.50),
    CHEESE(2.00),
    PINEAPPLE(2.50),
    BLACK_OLIVE(1.25),
    ITALIAN_SAUSAGE(3.50),
    PEPPERONI(3.00),
    BELL_PEPPER(1.00),
    MUSHROOM(1.50),
    CANADIAN_BACON(4.00);
		
	private final double toppingPrice;
	
	Toppings(double toppingPrice) {
	        this.toppingPrice = toppingPrice;
	    }

	public double getToppingPrice() {
		return toppingPrice;
	}
	
	 
		
}
//Implement a method public boolean addNewToppingToPizza(int
//orderID, Toppings topping). This method finds the pizza order with the given ID
//and adds the given topping to its topping list if it doesn’t already exist in the list. If the given
//topping is added, it also updates the pizza price and returns true. If the topping already exists in
//the topping list of the pizza, it returns false.

//Implement a method public boolean removeToppingFromPizza(int
//orderID, Toppings topping). This method finds the pizza order with the given ID
//and removes the given topping from its topping list if it exists in the list. If the given topping is
//removed, it also updates the pizza price and returns true. If the topping doesn’t exist in the
//topping list of the pizza and cannot be removed, it returns false.

//Implement a method public boolean isThereAnyUncookedPizza(). This
//method checks the pizzas in the pizzaOrderList and checks their cooking strategies. It returns
//true if there are any pizzas without any assigned pizza cooking strategy. It returns false if there
//are no pizzas without an assigned cooking strategy.

//Implement a method public double checkout() throws Exception. This
//method checks if there are any uncooked pizzas. If all pizzas are cooked, it calculates the total
//price of all pizzas and returns the total cart price. However, if there is at least one uncooked pizza
//it throws an exception (Use the general Exception class). The checkout method calls the
//isThereAnyUncookedPizza method to check for uncooked pizzas and throws an exception.

//Implement a method public boolean
//selectCookingStrategyByPizzaOrderID(int orderID,
//CookingStyleType cookingStrategyType). This method gets the pizza with the
//given order ID, instantiates the cookingStrategy according to the cookingStrategyType
//parameter. Calls the cook function for the pizza of the pizza order with the given order ID.
