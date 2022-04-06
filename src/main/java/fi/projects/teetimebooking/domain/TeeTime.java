package fi.projects.teetimebooking.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class TeeTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teeTimeId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDate startDate;
	private LocalTime startTime;
	private double maxHandicapSum;

	@ManyToOne
	@JsonIgnoreProperties({ "teeOffs", "name", "holes", "golfClub" })
	@JoinColumn(name = "courseId")
	private Course course;

	@OneToMany(mappedBy = "teeTime", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"teeTime", "teeTimeStatus", "timestamp"})
	private Set<TeeTimeBooking> bookedTeeTimes = new HashSet<TeeTimeBooking>();

	public TeeTime() {
	}

	public TeeTime(LocalDate startDateTime, LocalTime startTime, int maxHandicapSum, Course course) {
		super();
		this.startDate = startDateTime;
		this.startTime = startTime;
		this.maxHandicapSum = maxHandicapSum;
		this.course = course;
	}
	
	public void addBookedTeeTime(TeeTimeBooking teeTimeBooking) {
		this.bookedTeeTimes.add(teeTimeBooking);
		teeTimeBooking.setTeeTime(this);
	}
	
	public void setTeeTimeId(Long teeTimeId) {
		this.teeTimeId = teeTimeId;
	}

	public void setStartDate(LocalDate startDateTime) {
		this.startDate = startDateTime;
	}
	
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public void setMaxHandicapSum(double maxHandicapSum) {
		this.maxHandicapSum = maxHandicapSum;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setBookedTeeTimes(Set<TeeTimeBooking> bookedTeeTimes) {
		this.bookedTeeTimes = bookedTeeTimes;
	}

	public Long getTeeTimeId() {
		return teeTimeId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}

	public double getMaxHandicapSum() {
		return maxHandicapSum;
	}

	public Course getCourse() {
		return course;
	}

	public Set<TeeTimeBooking> getBookedTeeTimes() {
		return bookedTeeTimes;
	}

	@Override
	public String toString() {
		return "TeeTime [teeTimeId=" + teeTimeId + ", startDate=" + startDate + ", maxHandicapSum="
				+ maxHandicapSum + "]";
	}
}
