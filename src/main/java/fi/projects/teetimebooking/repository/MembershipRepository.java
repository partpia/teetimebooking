package fi.projects.teetimebooking.repository;

import org.springframework.data.repository.CrudRepository;

import fi.projects.teetimebooking.domain.Membership;

public interface MembershipRepository extends CrudRepository<Membership, Long>{

}
