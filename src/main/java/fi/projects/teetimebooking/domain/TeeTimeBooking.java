package fi.projects.teetimebooking.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class TeeTimeBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long teeTimeBookingId;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonIgnoreProperties({ "username", "passwordHash", "firstName", "lastName", "email", "role", "member", "teeTimes" })
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "teeTimeId")
	@JsonIgnoreProperties({ "startDate", "startTime", "teetimes", "bookedTeeTimes"})
	private TeeTime teeTime;
	
	private Status teeTimeStatus;
	private LocalDateTime timestamp;

	public TeeTimeBooking() {}
	
	public TeeTimeBooking(User user, TeeTime teeTime, Status teeTimeStatus,
			LocalDateTime timestamp) {
		super();
		this.user = user;
		this.teeTime = teeTime;
		this.teeTimeStatus = teeTimeStatus;
		this.timestamp = timestamp;
	}

	public void setTeeTimeBookingId(Long teeTimeBookingId) {
		this.teeTimeBookingId = teeTimeBookingId;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setTeeTime(TeeTime teeTime) {
		this.teeTime = teeTime;
	}
	public void setTeeTimeStatus(Status teeTimeStatus) {
		this.teeTimeStatus = teeTimeStatus;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public Long getTeeTimeBookingId() {
		return teeTimeBookingId;
	}
	public User getUser() {
		return user;
	}
	public TeeTime getTeeTime() {
		return teeTime;
	}
	public Status getTeeTimeStatus() {
		return teeTimeStatus;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	@Override
	public String toString() {
		return "TeeTimeBooking [bookingId=" + teeTimeBookingId + ", user=" + user.getUserId() + ", teeTime=" + teeTime.getTeeTimeId() + ", teeTimeStatus="
				+ teeTimeStatus + ", timestamp=" + timestamp + "]";
	}
}
