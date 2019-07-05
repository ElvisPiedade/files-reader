package br.poa.ibm.webapp.service;

import org.springframework.stereotype.Service;

import br.poa.ibm.webapp.repository.SaleRepository;

@Service
public class SaleService {

	private final SaleRepository saleRepository;

	public SaleService(SaleRepository saleRepository) {
		this.saleRepository = saleRepository;
	}


}
