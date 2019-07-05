package br.poa.ibm.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.poa.ibm.webapp.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
