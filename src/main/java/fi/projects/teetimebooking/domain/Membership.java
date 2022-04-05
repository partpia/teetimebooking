package fi.projects.teetimebooking.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Membership {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long membershipId;
	private String golfClubName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
	@JsonIgnoreProperties({ "username", "passwordHash", "firstName", "lastName", "email", "handicap", "role", "member", "teeTimes" })
	private List<User> members;
	
	public Membership() {}
	
	public Membership(String golfClubName) {
		super();
		this.golfClubName = golfClubName;
	}
	public void setMembershipId(Long membershipId) {
		this.membershipId = membershipId;
	}
	public void setGolfClubName(String golfClubName) {
		this.golfClubName = golfClubName;
	}
	public void setMembers(List<User> members) {
		this.members = members;
	}
	public Long getMembershipId() {
		return membershipId;
	}
	public String getGolfClubName() {
		return golfClubName;
	}
	public List<User> getMembers() {
		return members;
	}
	@Override
	public String toString() {
		return "MembershipId : " + membershipId + ", membership in: " + golfClubName;
	}
}
