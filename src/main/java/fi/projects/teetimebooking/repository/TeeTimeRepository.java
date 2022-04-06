package fi.projects.teetimebooking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fi.projects.teetimebooking.domain.TeeTime;

public interface TeeTimeRepository extends CrudRepository<TeeTime, Long>{
	
	List<TeeTime> findAllByStartDate(LocalDate datetime);
	
	@Query("select t from TeeTime t where t.startDate= ?1 and t.course.courseId in ?2")
	List<TeeTime> findAllByStartDateTimeAndCourse(LocalDate datetime, Long id);
}
