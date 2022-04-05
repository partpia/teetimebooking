package fi.projects.teetimebooking.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class GolfClub {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long golfClubId;
	private String golfClubName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "golfClub")
	@JsonIgnoreProperties({ "golfClub", "teeOffs" })
	private List<Course> courses;
	
	public GolfClub() {}

	public GolfClub(String golfClubName) {
		super();
		this.golfClubName = golfClubName;
	}
		
	public void setGolfClubId(Long golfClubId) {
		this.golfClubId = golfClubId;
	}
	public void setGolfClubName(String golfClubName) {
		this.golfClubName = golfClubName;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public Long getGolfClubId() {
		return golfClubId;
	}
	public String getGolfClubName() {
		return golfClubName;
	}
	public List<Course> getCourses() {
		return courses;
	}
	@Override
	public String toString() {
		return "GolfClub [golfClubId=" + golfClubId + ", golfClubName=" + golfClubName + "]";
	}
}
