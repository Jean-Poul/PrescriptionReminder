package cph.databases.assignment.repository;

import cph.databases.assignment.entity.Lookup;
import org.springframework.data.repository.CrudRepository;

public interface LookupRepo extends CrudRepository<Lookup, Long> {
}
