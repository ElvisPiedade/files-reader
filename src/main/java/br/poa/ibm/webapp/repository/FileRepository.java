package br.poa.ibm.webapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.poa.ibm.webapp.domain.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long>{

}
