package br.poa.ibm.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.poa.ibm.webapp.domain.Product;
import br.poa.ibm.webapp.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}



}
