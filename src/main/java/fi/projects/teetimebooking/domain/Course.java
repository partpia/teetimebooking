package fi.projects.teetimebooking.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	private String name;
	private int holes;
	
	@ManyToOne
	@JsonIgnoreProperties("courses")
	@JoinColumn(name = "golfClubId", nullable = false)
	private GolfClub golfClub;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
	private List<TeeTime> teeOffs;

	public Course() {}
	
	public Course(String name, int holes, GolfClub golfClub) {
		super();
		this.name = name;
		this.holes = holes;
		this.golfClub = golfClub;
	}
	
	public Course(String name, int holes, GolfClub golfClub, List<TeeTime> teeOffs) {
		super();
		this.name = name;
		this.holes = holes;
		this.golfClub = golfClub;
		this.teeOffs = teeOffs;
	}
	
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHoles(int holes) {
		this.holes = holes;
	}
	public void setGolfClub(GolfClub golfClub) {
		this.golfClub = golfClub;
	}
	public void setTeeOffs(List<TeeTime> teeOffs) {
		this.teeOffs = teeOffs;
	}
	public Long getCourseId() {
		return courseId;
	}
	public String getName() {
		return name;
	}
	public int getHoles() {
		return holes;
	}
	public GolfClub getGolfClub() {
		return golfClub;
	}
	public List<TeeTime> getTeeOffs() {
		return teeOffs;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", holes=" + holes + ", golfClub=" + golfClub
				+ ", teeOffs=" + teeOffs + "]";
	}
}
