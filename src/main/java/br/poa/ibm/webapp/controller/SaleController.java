package br.poa.ibm.webapp.controller;

import org.springframework.stereotype.Controller;

import br.poa.ibm.webapp.service.SaleService;

@Controller
public class SaleController {

	private final SaleService saleService;

	public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}



}
