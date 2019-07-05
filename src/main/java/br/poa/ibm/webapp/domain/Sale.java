package br.poa.ibm.webapp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Sale {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "sale")
	private List<Product> productList;

	@ManyToMany(mappedBy="vendorSales")
	private List<Vendor> vendors;

}
