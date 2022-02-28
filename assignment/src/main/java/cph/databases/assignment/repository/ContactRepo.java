package cph.databases.assignment.repository;

import cph.databases.assignment.entity.ContactInformation;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepo extends CrudRepository<ContactInformation, Integer> {
}
