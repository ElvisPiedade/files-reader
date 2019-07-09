package br.poa.ibm.webapp.service;

import java.util.ArrayList;
import java.util.List;

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

	public SaleService(SaleRepository saleRepository, ProductRepository productRepository, VendorRepository vendorRepository) {
		this.saleRepository = saleRepository;
		this.productRepository = productRepository;
		this.vendorRepository = vendorRepository;
	}

	public void save(List<String> list) {


		for (String string : list) {
			String[] arr = string.split("ç");
			List<Vendor> vendorList = new ArrayList<Vendor>();
			Sale sale = new Sale();
			vendorList.add(vendorRepository.findByName(arr[3]));

			sale.setId(Long.parseLong(arr[1]));
			sale.setVendors(vendorList);

			saleRepository.save(sale);

			arr[2] = arr[2].substring(1, arr[2].length()-1);
			String[] items = arr[2].split(",");

			for (String s : items) {
				String[] values = s.split("-");

				Product product = new Product();
				product.setId(Long.parseLong(values[0]));
				product.setQuantity(Long.parseLong(values[1]));
				product.setPrice(Double.parseDouble(values[2]));
				product.setSale(sale);

				productRepository.save(product);

			}



		}
	}


}
