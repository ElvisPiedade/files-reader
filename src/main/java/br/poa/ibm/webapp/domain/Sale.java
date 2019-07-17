package br.poa.ibm.webapp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Sale implements Comparable<Sale>{

	@Id
	@GeneratedValue
	private Long id;

	private Long number;

	@OneToMany(mappedBy = "sale")
	private List<Product> productList;

	@ManyToMany
    @JoinTable( name = "vendor_sale",
			joinColumns = @JoinColumn(name = "sale_id"),
			inverseJoinColumns = @JoinColumn(name = "vendor_id"))
	private List<Vendor> vendors;

	private Double amount;

	@Override
	public int compareTo(Sale o) {
		return this.getAmount().compareTo(o.getAmount());
	}

}
