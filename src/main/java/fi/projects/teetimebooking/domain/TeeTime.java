package fi.projects.teetimebooking.domain;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class TeeTime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teeTimeId;
	private Date startDateTime;
	private int maxHandicapSum;
	
	@ManyToOne
	@JsonIgnoreProperties("teeOffs")
	@JoinColumn(name = "courseId", nullable = false)
	private Course course;
	
	@OneToMany(mappedBy = "teeTime")
	private Set<TeeTimeBooking> golfers = new HashSet<TeeTimeBooking>();

	public TeeTime() {}
	
	public TeeTime(Date startDateTime, int maxHandicapSum, Course course) {
		super();
		this.startDateTime = startDateTime;
		this.maxHandicapSum = maxHandicapSum;
		this.course = course;
	}

	public void setTeeTimeId(Long teeTimeId) {
		this.teeTimeId = teeTimeId;
	}
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	public void setMaxHandicapSum(int maxHandicapSum) {
		this.maxHandicapSum = maxHandicapSum;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public void setGolfers(Set<TeeTimeBooking> golfers) {
		this.golfers = golfers;
	}
	public Long getTeeTimeId() {
		return teeTimeId;
	}
	public Date getStartDateTime() {
		return startDateTime;
	}
	public int getMaxHandicapSum() {
		return maxHandicapSum;
	}
	public Course getCourse() {
		return course;
	}
	public Set<TeeTimeBooking> getGolfers() {
		return golfers;
	}
	@Override
	public String toString() {
		return "TeeTime: teeTimeId: " + teeTimeId + ", startDateTime: " + startDateTime + ", maxHandicapSum: "
				+ maxHandicapSum + ", course: " + course + ", teeTimes: " + golfers;
	}
}
