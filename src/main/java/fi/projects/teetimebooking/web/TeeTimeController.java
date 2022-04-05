package fi.projects.teetimebooking.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fi.projects.teetimebooking.domain.TeeTime;
import fi.projects.teetimebooking.repository.TeeTimeRepository;

@RestController
public class TeeTimeController {
	
	@Autowired
	private TeeTimeRepository teeTimeRepository;
	
	@GetMapping("/teetimes")
	public List<TeeTime> getTeeTimes() {
		return (List<TeeTime>) teeTimeRepository.findAll();
	}
	
	@GetMapping("/teetimes/{id}")
	public TeeTime getTeeTimeById(@PathVariable Long id) {
		return teeTimeRepository.findById(id).get();
	}
	
	
	
}
