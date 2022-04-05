package fi.projects.teetimebooking.repository;

import org.springframework.data.repository.CrudRepository;

import fi.projects.teetimebooking.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
