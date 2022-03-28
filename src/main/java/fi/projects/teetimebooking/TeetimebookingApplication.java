package fi.projects.teetimebooking;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.projects.teetimebooking.domain.Course;
import fi.projects.teetimebooking.domain.CourseRepository;
import fi.projects.teetimebooking.domain.GolfClub;
import fi.projects.teetimebooking.domain.GolfClubRepository;
import fi.projects.teetimebooking.domain.Membership;
import fi.projects.teetimebooking.domain.MembershipRepository;
import fi.projects.teetimebooking.domain.Role;
import fi.projects.teetimebooking.domain.Status;
import fi.projects.teetimebooking.domain.TeeTime;
import fi.projects.teetimebooking.domain.TeeTimeBooking;
import fi.projects.teetimebooking.domain.TeeTimeBookingId;
import fi.projects.teetimebooking.domain.TeeTimeBookingRepository;
import fi.projects.teetimebooking.domain.TeeTimeRepository;
import fi.projects.teetimebooking.domain.User;
import fi.projects.teetimebooking.domain.UserRepository;

@SpringBootApplication
public class TeetimebookingApplication {
	
	private static final Logger log = LoggerFactory.getLogger(TeetimebookingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TeetimebookingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner teeTimeBookingDemo(GolfClubRepository golfClubRepository, CourseRepository 
			courseRepository, TeeTimeRepository teeTimeRepository, UserRepository userRepository,
			MembershipRepository membershipRepository, TeeTimeBookingRepository teeTimeBookingRepository) {
		return (args) -> {
			
			log.info("Save one golf club");
			GolfClub gc1 = new GolfClub("Runners' Golf Club");	
			golfClubRepository.save(gc1);
			
			log.info("Save one course");
			Course course1 = new Course("Holy Round", 18, gc1);
			Course course2 = new Course("Half of Joy", 9, gc1);
			courseRepository.save(course1);
			courseRepository.save(course2);
			
			log.info("Save one teetime");
			TeeTime teeTime1 = new TeeTime(new Date(), 110, course1);
			TeeTime teeTime2 = new TeeTime(new Date(), 110, course1);
			teeTimeRepository.save(teeTime1);
			teeTimeRepository.save(teeTime2);
			
			log.info("Save one membership-club");
			Membership member1 = new Membership("Sand Coast Golfers");
			membershipRepository.save(member1);
			
			log.info("Save one teetime");
			User user1 = new User("Sally", "Doe", "sallyd@mail.com", 27.8, Role.USER, member1);
			userRepository.save(user1);
			User user2 = new User("Geore", "Smith", "georgie@mail.com", 13.2, Role.USER, member1);
			userRepository.save(user2);
			
			log.info("Save some bookings");
			TeeTimeBooking booking1 = new TeeTimeBooking();
			booking1.setUser(user1);
			booking1.setTeeTime(teeTime1);
			teeTimeBookingRepository.save(booking1);
			
			TeeTimeBooking booking2 = new TeeTimeBooking();
			booking2.setUser(user2);
			booking2.setTeeTime(teeTime2);
			teeTimeBookingRepository.save(booking2);
			
			TeeTimeBooking booking3 = new TeeTimeBooking();
			booking3.setUser(user2);
			booking3.setTeeTime(teeTime1);
			teeTimeBookingRepository.save(booking3);
		};
	}

}
