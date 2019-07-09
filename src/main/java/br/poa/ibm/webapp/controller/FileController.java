package br.poa.ibm.webapp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView uploadFiles(@ModelAttribute @Valid File file,
			@RequestParam(value="myFile", required=false) Set<MultipartFile> myFile) throws IOException {
		ModelAndView mav = new ModelAndView("redirect:/");
		Map<String, List<String>> values = fileService.save(file, myFile);

		vendorService.save(values.get("001"));
		customerService.save(values.get("002"));
		saleService.save(values.get("003"));
		mav.addObject("customers", customerService.findAll());
		mav.addObject("vendors", vendorService.findAll());

		return mav;
	}

}
