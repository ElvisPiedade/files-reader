package br.poa.ibm.webapp.controller;

import org.springframework.stereotype.Controller;

import br.poa.ibm.webapp.service.VendorService;

@Controller
public class VendorController {

	private final VendorService vendorService;

	public VendorController(VendorService vendorService) {
		this.vendorService = vendorService;
	}
}
