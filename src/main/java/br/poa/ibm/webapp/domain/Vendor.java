package br.poa.ibm.webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
