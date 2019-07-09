package br.poa.ibm.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.poa.ibm.webapp.domain.Customer;
import br.poa.ibm.webapp.domain.Vendor;
import br.poa.ibm.webapp.repository.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}


	public List<Customer> findAll() {
		return customerRepository.findAll();
	}


	public void save(List<String> list) {

		for (String string : list) {
			Customer customer = new Customer();
			String[] arr = string.split("ç");
			customer.setCnpj(arr[1]);
			customer.setName(arr[2]);
			customer.setBusinessArea(arr[3]);

			customerRepository.save(customer);
		}
	}


}