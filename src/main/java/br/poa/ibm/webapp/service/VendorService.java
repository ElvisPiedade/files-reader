package br.poa.ibm.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.poa.ibm.webapp.domain.Vendor;
import br.poa.ibm.webapp.repository.VendorRepository;

@Service
public class VendorService {

	private final VendorRepository vendorRepository;

	public VendorService(VendorRepository vendorRepository) {
		this.vendorRepository = vendorRepository;
	}

	public List<Vendor> findAll() {
		return vendorRepository.findAll();
	}


}
