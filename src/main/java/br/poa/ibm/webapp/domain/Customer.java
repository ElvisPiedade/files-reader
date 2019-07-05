package br.poa.ibm.webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String cnpj;
	
	private String name;
	
	private String businessArea;

}
