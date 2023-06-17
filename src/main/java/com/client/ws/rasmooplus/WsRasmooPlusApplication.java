package com.client.ws.rasmooplus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableCaching
public class WsRasmooPlusApplication implements CommandLineRunner {
	
	

	/*
	 * @Autowired private WsRaspayIntegration integration;
	 */
	public static void main(String[] args) {
		SpringApplication.run(WsRasmooPlusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.err.println( new BCryptPasswordEncoder().encode("123456"));
		

		/*
		//CRIAÇÃO DDDO CLIENTE NO SISTEMA DE PAGAMENTO RASPAY
		CustomerDto customerDto = new CustomerDto();

		customerDto.setCpf("58440833008");
		customerDto.setEmail("wellington@hotmail.com");
		customerDto.setFirstName("Wellington");
		customerDto.setLastName("Xavier dos Santos");		
		integration.createCustomer(customerDto);
		*/
		
		
		/*
		 * //CRIAÇÃO DO PEDIDO NO SISTEMA DE PAGAMENTO RASPAY OrderDto orderdto = new
		 * OrderDto();
		 * 
		 * orderdto.setProductAcronym("MONTH22");
		 * orderdto.setCustomerId("6459713c0f44474a4d7171e3");
		 * orderdto.setDiscount(BigDecimal.ZERO); integration.createOrder(orderdto);
		 */
		
		
		
		
		/*
		 * CreditCardDto cardDto = new CreditCardDto(); cardDto.setCvv(123l);
		 * cardDto.setDocumentNumber("58440833008"); cardDto.setInstallments(0l);
		 * cardDto.setMonth(12l); cardDto.setNumber("12345678"); cardDto.setYear(2023l);
		 * 
		 * PaymentDto paymentDto = new PaymentDto(); paymentDto.setCreditCard(cardDto);
		 * paymentDto.setCustomerId("6459713c0f44474a4d7171e3");
		 * paymentDto.setOrderId("6459718a0f44474a4d7171e4");
		 * 
		 * integration.processPayment(paymentDto);
		 * 
		 */
		
		

	}

}
