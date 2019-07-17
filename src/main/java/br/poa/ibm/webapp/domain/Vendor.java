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
public class Vendor implements Comparable<Vendor>{

	@Id
	@GeneratedValue
	private Long id;

	private String cpf;

	private String name;

	private Double salary;

	private Double amount;

	@ManyToMany(mappedBy="vendors")
	private List<Sale> vendorSales;

	@Override
	public int compareTo(Vendor o) {
		return this.getAmount().compareTo(o.getAmount());
	}

}
