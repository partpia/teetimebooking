package fi.projects.teetimebooking.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fi.projects.teetimebooking.domain.GolfClub;
import fi.projects.teetimebooking.repository.GolfClubRepository;

@RestController
public class GolfClubController {
	
	@Autowired
	private GolfClubRepository golfClubRepository;
	
	@GetMapping("/golfclubs")
	public List<GolfClub> getGolfClubs() {
		return (List<GolfClub>) golfClubRepository.findAll();
	}
	
	@GetMapping("/golfclubs/{id}")
	public Optional<GolfClub> getGolfClubById(@PathVariable Long id) {
		return golfClubRepository.findById(id);
	}
	
	@PostMapping("/golfclubs")
	public GolfClub saveBook(@RequestBody GolfClub club) {
		return golfClubRepository.save(club);
	}
}
