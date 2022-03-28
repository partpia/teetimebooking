package fi.projects.teetimebooking.domain;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class TeeTimeBooking {
	@EmbeddedId
	private TeeTimeBookingId bookingId = new TeeTimeBookingId();
	
	@ManyToOne
	@MapsId("userId")
	@JsonIgnoreProperties("teeTimes")
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne
	@JsonIgnoreProperties("golfers")
	@MapsId("teeTimeId")
	@JoinColumn(name = "teeTimeId")
	private TeeTime teeTime;
	
	private Status teeTimeStatus;
	private Date timestamp;

	public TeeTimeBooking() {}
	
	public TeeTimeBooking(TeeTimeBookingId bookingId, User user, TeeTime teeTime, Status teeTimeStatus,
			Date timestamp) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.teeTime = teeTime;
		this.teeTimeStatus = teeTimeStatus;
		this.timestamp = timestamp;
	}

	public void setBookingId(TeeTimeBookingId bookingId) {
		this.bookingId = bookingId;
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
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public TeeTimeBookingId getBookingId() {
		return bookingId;
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
	public Date getTimestamp() {
		return timestamp;
	}
	@Override
	public String toString() {
		return "TeeTimeBooking [bookingId=" + bookingId + ", user=" + user + ", teeTime=" + teeTime + ", teeTimeStatus="
				+ teeTimeStatus + ", timestamp=" + timestamp + "]";
	}
}
