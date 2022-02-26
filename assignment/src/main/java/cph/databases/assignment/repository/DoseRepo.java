package cph.databases.assignment.repository;

import cph.databases.assignment.entity.Dose;
import org.springframework.data.repository.CrudRepository;

public interface DoseRepo extends CrudRepository<Dose,Integer> {
}
