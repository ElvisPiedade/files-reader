package br.poa.ibm.webapp.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import br.poa.ibm.webapp.domain.Sale;
import br.poa.ibm.webapp.domain.Vendor;
import br.poa.ibm.webapp.repository.SaleRepository;
import br.poa.ibm.webapp.repository.VendorRepository;

@Service
public class VendorService {

	private final VendorRepository vendorRepository;
	private final SaleRepository saleRepository;

	public VendorService(VendorRepository vendorRepository, SaleRepository saleRepository) {
		this.vendorRepository = vendorRepository;
		this.saleRepository = saleRepository;
	}

	public List<Vendor> findAll() {
		return vendorRepository.findAll();
	}

	public void save(List<String> list) {


		for (String string : list) {

			String[] arr = string.split("ç");
			if(vendorRepository.findByCpf(arr[1]) == null) {
				Vendor vendor = new Vendor();

				vendor.setCpf(arr[1]);
				vendor.setName(arr[2]);
				vendor.setSalary(Double.parseDouble(arr[3]));

				vendorRepository.save(vendor);
			}

		}
	}

	public String findWorseVendor() {
		List<Vendor> vendorList = vendorRepository.findAll();

		if(!vendorList.isEmpty()) {
			Collections.sort(vendorList);
			return vendorList.get(0).getName();
		}else {
			return null;
		}


	}

}
