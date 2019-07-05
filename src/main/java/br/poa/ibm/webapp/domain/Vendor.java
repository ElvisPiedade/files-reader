package br.poa.ibm.webapp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Vendor {

	@Id
	@GeneratedValue
	private Long id;

	private String cpf;

	private String Name;

	private Double salary;

	@ManyToMany
    @JoinTable( name = "vendor_sale",
			joinColumns = @JoinColumn(name = "vendor_id"),
			inverseJoinColumns = @JoinColumn(name = "sale_id"))
	private List<Sale> vendorSales;

}
