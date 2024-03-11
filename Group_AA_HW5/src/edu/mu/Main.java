package edu.mu;

import edu.mu.cooking.*;
import edu.mu.pizza.*;

public class Main {

	

	public static void main(String[] args) {
		PizzaOrder order = new PizzaOrder();
		order.addPizzaToCart(PizzaType.HAWAIIAN);
		order.printPizzaOrderCart(0);
		AbstractPizza pizza = order.getPizzaByOrderID(1);
		

	}

}
