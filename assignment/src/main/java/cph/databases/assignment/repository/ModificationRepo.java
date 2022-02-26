package cph.databases.assignment.repository;

import cph.databases.assignment.entity.PrescriptionModification;
import org.springframework.data.repository.CrudRepository;

public interface ModificationRepo extends CrudRepository<PrescriptionModification, Long> {
}
