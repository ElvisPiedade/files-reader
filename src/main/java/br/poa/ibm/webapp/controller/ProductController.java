package br.poa.ibm.webapp.controller;

import org.springframework.stereotype.Controller;

import br.poa.ibm.webapp.service.ProductService;

@Controller
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}



}
