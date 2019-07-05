package br.poa.ibm.webapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class File {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 2147483647)
	private byte[] content;



}
