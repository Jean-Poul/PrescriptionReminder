package cph.databases.assignment.repository;

import cph.databases.assignment.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepo extends CrudRepository<Patient, Long> {
}
