package br.poa.ibm.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.poa.ibm.webapp.service.CustomerService;

@Controller
public class CustomerController {
	
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}



	@GetMapping("/list")
	public String list() {
		return "list";
	}
	

}
