package br.poa.ibm.webapp.service;

import org.springframework.stereotype.Service;

import br.poa.ibm.webapp.repository.VendorRepository;

@Service
public class VendorService {

	private final VendorRepository vendorRepository;

	public VendorService(VendorRepository vendorRepository) {
		this.vendorRepository = vendorRepository;
	}


}
