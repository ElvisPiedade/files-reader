package br.poa.ibm.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.poa.ibm.webapp.service.CustomerService;
import br.poa.ibm.webapp.service.ProductService;
import br.poa.ibm.webapp.service.SaleService;
import br.poa.ibm.webapp.service.VendorService;

@Controller
@RequestMapping("/")
public class HomeController {

	private final CustomerService customerService;
	private final ProductService productService;
	private final VendorService vendorService;
	private final SaleService saleService;


	public HomeController(CustomerService customerService, ProductService productService, VendorService vendorService, SaleService saleService) {
		this.customerService = customerService;
		this.productService = productService;
		this.vendorService = vendorService;
		this.saleService = saleService;
	}



	@GetMapping("")
    public ModelAndView dashboard(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("customers", customerService.findAll());
        mav.addObject("products", productService.findAll());
        mav.addObject("vendors", vendorService.findAll());
        mav.addObject("expensive", saleService.findMostExpensive());
        mav.addObject("worse", vendorService.findWorseVendor());

        return mav;
    }


}
