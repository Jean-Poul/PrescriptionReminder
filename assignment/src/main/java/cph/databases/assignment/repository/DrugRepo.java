package cph.databases.assignment.repository;

import cph.databases.assignment.entity.prescription.Drug;
import org.springframework.data.repository.CrudRepository;


public interface DrugRepo extends CrudRepository<Drug,Integer>{
}
