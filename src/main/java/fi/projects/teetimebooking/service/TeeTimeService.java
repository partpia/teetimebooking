package fi.projects.teetimebooking.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.projects.teetimebooking.domain.TeeTime;
import fi.projects.teetimebooking.repository.TeeTimeRepository;

@Service
public class TeeTimeService {
	
	@Autowired
	private TeeTimeRepository teeTimeRepository;
	
	public List<TeeTime> getCurrentDayTeeTimes() {
		List<TeeTime> teeTimesOfTheDay = teeTimeRepository.findAllByStartDate(LocalDate.now());
		return teeTimesOfTheDay;
	}
	
	public List<TeeTime> getAllTeeTimesByCourseAndDate(Long id, String dateString) {
		LocalDate date = LocalDate.parse(dateString);
		List<TeeTime> teetimes = teeTimeRepository.findAllByStartDateTimeAndCourse(date, id);
		return teetimes;
	}
}
