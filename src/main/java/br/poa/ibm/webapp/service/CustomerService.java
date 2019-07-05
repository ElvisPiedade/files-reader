package br.poa.ibm.webapp.service;

import org.springframework.stereotype.Service;

import br.poa.ibm.webapp.repository.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	
}
