package cph.databases.assignment.repository;

import cph.databases.assignment.entity.Pharmacist;
import org.springframework.data.repository.CrudRepository;

public interface PharmacistRepo extends CrudRepository<Pharmacist, Long> {
}
