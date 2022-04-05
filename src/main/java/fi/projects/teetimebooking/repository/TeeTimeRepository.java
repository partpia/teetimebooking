package fi.projects.teetimebooking.repository;

import org.springframework.data.repository.CrudRepository;

import fi.projects.teetimebooking.domain.TeeTime;

public interface TeeTimeRepository extends CrudRepository<TeeTime, Long>{

}
