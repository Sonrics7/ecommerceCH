package com.edu.ecommercech.EcommerceCH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class EcommerceChApplication {
//public class EcommerceChApplication implements CommandLineRunner {
	/*@Autowired
	ClientRepository clientRepository;

	@Autowired
	InvoiceRepository invoiceRepository;

	@Autowired
	InvoiceDetailRepository invoiceDetailRepository;

	@Autowired
	ProductRepository productRepository;*/

	public static void main(String[] args) {

		SpringApplication.run(EcommerceChApplication.class, args);

	}

	/*@Override
	public void run(String... args) throws Exception {

		System.out.println("LISTA DE CLIENTES : " + clientRepository.findAll());
		System.out.println("LISTA DE PRODUCTOS : " + productRepository.findAll());
		System.out.println("LISTA DE FACTURAS : " + invoiceRepository.findAll());
		System.out.println("LISTA DE DETALLE DE FACTURAS : " + invoiceDetailRepository.findAll());

	}*/
}
