package br.poa.ibm.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.poa.ibm.webapp.domain.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
