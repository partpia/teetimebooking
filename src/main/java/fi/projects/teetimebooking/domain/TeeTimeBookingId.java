package fi.projects.teetimebooking.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
public class TeeTimeBookingId implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "userId")
	private Long userId;
	@Column(name = "teeTimeId")
	private Long teeTimeId;
	
	public TeeTimeBookingId() {}
	
	public TeeTimeBookingId(Long userId, Long teeTimeId) {
		super();
		this.userId = userId;
		this.teeTimeId = teeTimeId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setTeeTimeId(Long teeTimeId) {
		this.teeTimeId = teeTimeId;
	}
	public Long getUserId() {
		return userId;
	}
	public Long getTeeTimeId() {
		return teeTimeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((teeTimeId == null) ? 0 : teeTimeId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeeTimeBookingId other = (TeeTimeBookingId) obj;
		if (teeTimeId == null) {
			if (other.teeTimeId != null)
				return false;
		} else if (!teeTimeId.equals(other.teeTimeId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
}
