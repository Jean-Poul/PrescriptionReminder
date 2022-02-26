package cph.databases.assignment.repository;

import cph.databases.assignment.entity.Prescription;
import org.springframework.data.repository.CrudRepository;

public interface PrescriptionRepo extends CrudRepository<Prescription, Long> {
}
