package fi.projects.teetimebooking.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.projects.teetimebooking.domain.TeeTimeBooking;
import fi.projects.teetimebooking.repository.TeeTimeBookingRepository;
import fi.projects.teetimebooking.repository.TeeTimeRepository;
import fi.projects.teetimebooking.repository.UserRepository;
import fi.projects.teetimebooking.service.TeeTimeBookingService;

@RestController
public class TeeTimeBookingController {
	
	@Autowired
	private TeeTimeBookingService teeTimeBookingService;
	
	@Autowired
	private TeeTimeBookingRepository teeTimeBookingRepository;
	
	@GetMapping("/teetimebookings")
	public List<TeeTimeBooking> getAllTeeTimeBookings() {
		return (List<TeeTimeBooking>) teeTimeBookingRepository.findAll();
	}
	
	@GetMapping("/teetimebookings/{id}")
	public TeeTimeBooking getTeeTimeBookingById(@PathVariable Long id) {
		return teeTimeBookingRepository.findById(id).get();
	}
	
	@PostMapping("/teetimebookings/teetimes/{teeTimeId}/users/{userId}")
	public TeeTimeBooking saveTeeTimeBooking(@PathVariable(name = "teeTimeId") Long teeTimeId, @PathVariable(name = "userId") Long userId) {
		return teeTimeBookingService.bookTeeTime(userId, teeTimeId);
	}	

}
