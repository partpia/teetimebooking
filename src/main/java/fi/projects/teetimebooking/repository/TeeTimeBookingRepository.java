package fi.projects.teetimebooking.repository;

import org.springframework.data.repository.CrudRepository;

import fi.projects.teetimebooking.domain.TeeTimeBooking;

public interface TeeTimeBookingRepository extends CrudRepository<TeeTimeBooking, Long>{

}
