package br.poa.ibm.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.poa.ibm.webapp.domain.File;
import br.poa.ibm.webapp.service.CustomerService;
import br.poa.ibm.webapp.service.FileService;
import br.poa.ibm.webapp.service.ProductService;
import br.poa.ibm.webapp.service.SaleService;
import br.poa.ibm.webapp.service.VendorService;

@Controller
@RequestMapping("/file")
public class FileController {

	private final FileService fileService;
	private final CustomerService customerService;
	private final VendorService vendorService;
	private final SaleService saleService;
	private final ProductService productService;

	public FileController(FileService fileService, CustomerService customerService, VendorService vendorService,
			SaleService saleService, ProductService productService) {
		this.fileService = fileService;
		this.customerService = customerService;
		this.vendorService = vendorService;
		this.saleService = saleService;
		this.productService = productService;
	}

	@PostMapping("/upload")
	public ModelAndView uploadFiles(File file) {
		ModelAndView mav = new ModelAndView("");
		fileService.save(file);
		mav.addObject("customers", customerService.findAll());
		mav.addObject("vendors", vendorService.findAll());

		return mav;
	}

}
