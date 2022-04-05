package fi.projects.teetimebooking.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fi.projects.teetimebooking.domain.Membership;
import fi.projects.teetimebooking.repository.MembershipRepository;

@RestController
public class MembershipController {

	@Autowired
	private MembershipRepository membershipRepository;
	
	@GetMapping("/memberships")
	public List<Membership> getAllMembershipClubsAndUsers() {
		return (List<Membership>) membershipRepository.findAll();
	}
	
	@GetMapping("/memberships/{id}")
	public Membership getMembershipById(@PathVariable Long id) {
		return membershipRepository.findById(id).get();
	}
}
