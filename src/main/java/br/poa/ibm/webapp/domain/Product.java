package br.poa.ibm.webapp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	private Long quantity;

	private Double price;

	@ManyToOne(cascade=CascadeType.ALL)
	private Sale sale;

}
