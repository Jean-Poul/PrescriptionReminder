package cph.databases.assignment.repository;

import cph.databases.assignment.entity.Handout;
import org.springframework.data.repository.CrudRepository;

public interface HandoutRepo extends CrudRepository<Handout, Long> {
}
