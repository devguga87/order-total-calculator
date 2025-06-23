package com.devsuperior.aula1;

import com.devsuperior.aula1.entities.Order;
import com.devsuperior.aula1.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Aula1Application implements CommandLineRunner {
	@Autowired
	OrderService orderService;

	public static void main(String[] args) {

		SpringApplication.run(Aula1Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("ENTRADA");

		System.out.print("Digite o código do pedido: ");
		Integer codigoPedido = sc.nextInt();

		System.out.print("Digite o valor básico do pedido:");
		Double valorBasico = sc.nextDouble();

		System.out.print("Digite o desconto do pedido ou 0.0 se não houver:");
		Double desconto = sc.nextDouble();

		Order order = new Order(codigoPedido, valorBasico, desconto);
		System.out.printf("Pedido código %d%n", order.getCode());
		System.out.printf("Valor total: R$ %.2f", orderService.total(order));

		sc.close();
	}
}
