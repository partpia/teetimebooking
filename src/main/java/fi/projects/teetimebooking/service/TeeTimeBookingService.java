package fi.projects.teetimebooking.service;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.projects.teetimebooking.domain.Status;
import fi.projects.teetimebooking.domain.TeeTime;
import fi.projects.teetimebooking.domain.TeeTimeBooking;
import fi.projects.teetimebooking.domain.User;
import fi.projects.teetimebooking.repository.TeeTimeBookingRepository;
import fi.projects.teetimebooking.repository.TeeTimeRepository;
import fi.projects.teetimebooking.repository.UserRepository;

@Service
public class TeeTimeBookingService {
	
	@Autowired
	private TeeTimeBookingRepository teeTimeBookingRepository;
	
	@Autowired
	private TeeTimeRepository teeTimeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public TeeTimeBooking bookTeeTime(TeeTimeBooking teeTimeBooking) {
		TeeTime teeTime = teeTimeRepository.findById(teeTimeBooking.getTeeTime().getTeeTimeId()).get();
		User user = userRepository.findById(teeTimeBooking.getUser().getUserId()).get();
		
		if (teeTime.getBookedTeeTimes().size() < 4 && isEqualOrUnderMaxHcpSum(user, teeTime)) {
			TeeTimeBooking booking = new TeeTimeBooking();
			booking.setUser(user);
			booking.setTeeTime(teeTime);
			booking.setTeeTimeStatus(Status.RESERVED);
			booking.setTimestamp(LocalDateTime.now());
			user.addTeeTimeBooking(booking);
			teeTime.addBookedTeeTime(booking);
			em.persist(booking);
			teeTimeBookingRepository.save(booking);
			return booking;
		}
		return null;
	}
	public boolean isEqualOrUnderMaxHcpSum(User user, TeeTime teeTime) {
		double currentSum = getCurrentTeeTimeHcpSum(teeTime);
		double userHcp = user.getHandicap();
		
		return (currentSum + userHcp <= teeTime.getMaxHandicapSum()) ? true : false;
	}
	// calculates current handicap sum of enrolled golfers
	public double getCurrentTeeTimeHcpSum(TeeTime teeTime) {
		double sum = 0;
		Set<TeeTimeBooking> currentBookings = teeTime.getBookedTeeTimes();
		for (TeeTimeBooking booking: currentBookings) {
			sum += booking.getUser().getHandicap();
		}
		return sum;
	}
	

}
