package com.example.Order;

import com.example.Order.models.Order;
import com.example.Order.models.OrderEvent;
import com.example.Order.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApplication implements CommandLineRunner {
	private final OrderService orderService;

	public OrderApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order = orderService.createOrder("Sample Order");
		System.out.println("Initial state: " + order.getState());

		processAndPrint(order, OrderEvent.PROCESS);
		processAndPrint(order, OrderEvent.SHIP);
		processAndPrint(order, OrderEvent.DELIVER);

		// Valid transition from DELIVERED to CANCELLED
		processAndPrint(order, OrderEvent.CANCEL);

		// Invalid transition attempt
		try {
			processAndPrint(order, OrderEvent.PROCESS);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private void processAndPrint(Order order, OrderEvent event) {
		orderService.processEvent(order, event);
		System.out.println("After " + event + ": " + order.getState());
	}
}
