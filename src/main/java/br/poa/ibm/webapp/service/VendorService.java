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

	public void save(List<String> list) {

		for (String string : list) {
			Vendor vendor = new Vendor();
			String[] arr = string.split("ç");
			vendor.setCpf(arr[1]);
			vendor.setName(arr[2]);
			vendor.setSalary(Double.parseDouble(arr[3]));

			vendorRepository.save(vendor);
		}
	}


}
