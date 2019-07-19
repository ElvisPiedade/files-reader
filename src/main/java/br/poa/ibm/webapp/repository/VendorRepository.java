package br.poa.ibm.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.poa.ibm.webapp.domain.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long>{

	Vendor findByName(String name);

	Vendor findByCpf(String string);

}
