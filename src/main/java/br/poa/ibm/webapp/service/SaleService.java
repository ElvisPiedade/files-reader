package br.poa.ibm.webapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.poa.ibm.webapp.domain.Product;
import br.poa.ibm.webapp.domain.Sale;
import br.poa.ibm.webapp.domain.Vendor;
import br.poa.ibm.webapp.repository.ProductRepository;
import br.poa.ibm.webapp.repository.SaleRepository;
import br.poa.ibm.webapp.repository.VendorRepository;

@Service
public class SaleService {

	private final SaleRepository saleRepository;
	private final ProductRepository productRepository;
	private final VendorRepository vendorRepository;

	public SaleService(SaleRepository saleRepository, ProductRepository productRepository,
			VendorRepository vendorRepository) {
		this.saleRepository = saleRepository;
		this.productRepository = productRepository;
		this.vendorRepository = vendorRepository;
	}

	public void save(List<String> list) {

		for (String string : list) {
			Double amount = 0.0;
			String[] arr = string.split("ç");
			if (vendorRepository.findByName(arr[3]) != null && saleRepository.findByNumber(Long.parseLong(arr[1])) == null) {

				List<Vendor> vendorList = new ArrayList<Vendor>();
				Sale sale = new Sale();
				Vendor vendor = vendorRepository.findByName(arr[3]);
				vendorList.add(vendor);

				sale.setNumber(Long.parseLong(arr[1]));

				sale.setVendors(vendorList);

				arr[2] = arr[2].substring(1, arr[2].length() - 1);
				String[] items = arr[2].split(",");

				for (String s : items) {
					String[] values = s.split("-");

					if (values.length == 3) {
						try {
							Product product = new Product();
							product.setNumber(Long.parseLong(values[0]));
							product.setQuantity(Long.parseLong(values[1]));
							product.setPrice(Double.parseDouble(values[2]));
							product.setSale(sale);
							amount += product.getQuantity() * product.getPrice();
							productRepository.save(product);
						}catch(NumberFormatException e) {
							e.printStackTrace();
						}

					}

				}
				sale.setAmount(amount);
				saleRepository.save(sale);

				if (vendor.getAmount() != null) {
					vendor.setAmount(amount + vendor.getAmount());
				} else {
					vendor.setAmount(amount);
				}

				vendorRepository.save(vendor);
			}
		}
	}

	public Long findMostExpensive() {
		List<Sale> list = saleRepository.findAll();
		if (!list.isEmpty()) {
			Collections.sort(list);
			return list.get(list.size() - 1).getNumber();
		} else {
			return null;
		}

	}

}
