package cph.databases.assignment.repository;

import cph.databases.assignment.entity.Doctor;
import cph.databases.assignment.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepo extends CrudRepository<Doctor, Long> {
}