package fi.projects.teetimebooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.projects.teetimebooking.repository.TeeTimeRepository;

@Service
public class TeeTimeService {
	
	@Autowired
	private TeeTimeRepository teeTimeRepository;
	
	

}
