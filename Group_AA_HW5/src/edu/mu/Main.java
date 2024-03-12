package edu.mu;




public class Main {

	

	public static void main(String[] args) throws Exception {
		
		boolean test = false;
		PizzaOrder order = new PizzaOrder();
		test = order.addPizzaToCart(PizzaType.HAWAIIAN);
		System.out.println(test);
		
		test = order.addPizzaToCart(PizzaType.VEGETARIAN);
		System.out.println(test);
		
		test = order.addPizzaToCart(PizzaType.MARGHERITA);
		System.out.println(test);
		
		test = order.addPizzaToCart(PizzaType.SUPREME);
		System.out.println(test);
		
		order.printPizzaOrderCart(0);
		
		System.out.println("Hawaiian:\n");
		order.printListOfToppingsByPizzaOrderID(1);
		System.out.println("\nVegetarian:\n");
		order.printListOfToppingsByPizzaOrderID(2);
		System.out.println("\nMargherita:\n");
		order.printListOfToppingsByPizzaOrderID(3);
		System.out.println("\nSupreme:\n");
		order.printListOfToppingsByPizzaOrderID(4);
		
		order.addNewToppingToPizza(2, Toppings.PINEAPPLE);
		
		System.out.println("\nVegetarian with Pineapple:\n");
		order.printListOfToppingsByPizzaOrderID(2);
		
		order.removeToppingFromPizza(2, Toppings.PINEAPPLE);
		
		System.out.println("\nVegetarian after removing Pineapple:\n");
		order.printListOfToppingsByPizzaOrderID(2);
		
		double totalPrice = 0;
		
		test = order.isThereAnyUncookedPizza();
		System.out.println("\nThere are some uncooked pizzas: " + test + "\n");
		
		test = order.selectCookingStrategyByPizzaOrderID(1, CookingStyleType.BRICK_OVEN);
		System.out.println(test);
		test = order.selectCookingStrategyByPizzaOrderID(2, CookingStyleType.CONVENTIONAL_OVEN);
		System.out.println(test);
		test = order.selectCookingStrategyByPizzaOrderID(3, CookingStyleType.MICROWAVE);
		System.out.println(test);
		test = order.selectCookingStrategyByPizzaOrderID(4, CookingStyleType.BRICK_OVEN);
		System.out.println(test);
		
		test = order.isThereAnyUncookedPizza();
		System.out.println("\nThere are some uncooked pizzas: " + test + "\n");
	
		
		totalPrice = order.checkout();
		
		order.printPizzaOrderCart(0);
		
		System.out.println("Total Price in Cart: " + totalPrice);
	}

}
