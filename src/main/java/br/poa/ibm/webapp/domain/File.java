package br.poa.ibm.webapp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class File {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 2147483647)
	private byte[] content;

	private String contentType;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdOn;


}
