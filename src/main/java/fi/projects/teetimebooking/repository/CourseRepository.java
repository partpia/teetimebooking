package fi.projects.teetimebooking.repository;

import org.springframework.data.repository.CrudRepository;

import fi.projects.teetimebooking.domain.Course;

public interface CourseRepository extends CrudRepository<Course, Long>{

}
