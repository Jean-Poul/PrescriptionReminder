package cph.databases.assignment.repository;

import cph.databases.assignment.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address, Integer> {
}
