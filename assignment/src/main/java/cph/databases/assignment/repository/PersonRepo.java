package cph.databases.assignment.repository;

import cph.databases.assignment.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Long> {
}
