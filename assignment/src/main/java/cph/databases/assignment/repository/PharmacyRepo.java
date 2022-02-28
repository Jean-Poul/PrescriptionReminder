package cph.databases.assignment.repository;

import cph.databases.assignment.entity.Pharmacy;
import org.springframework.data.repository.CrudRepository;

public interface PharmacyRepo extends CrudRepository<Pharmacy, Integer> {
}
