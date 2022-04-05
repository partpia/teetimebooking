package fi.projects.teetimebooking.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", nullable = false, updatable = false)
	private Long userId;

	//@Column(name = "username", nullable = false, unique = true)
	private String username;

	//@Column(name = "password", nullable = false)
	private String passwordHash;

	private String firstName;
	private String lastName;
	private String email;
	private double handicap;
	private Role role;

	@ManyToOne
	@JsonIgnoreProperties("members")
	@JoinColumn(name = "membershipId")
	private Membership member;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<TeeTimeBooking> teeTimes = new HashSet<TeeTimeBooking>();

	public User() {
	}
	
	public User(String firstName, String lastName, String email,
			double handicap, Role role, Membership member) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.handicap = handicap;
		this.role = role;
		this.member = member;
	}

	public User(String username, String passwordHash, String firstName, String lastName, String email,
			double handicap, Role role, Membership member) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.handicap = handicap;
		this.role = role;
		this.member = member;
	}
	
	public void addTeeTimeBooking(TeeTimeBooking teeTimeBooking) {
		this.teeTimes.add(teeTimeBooking);
		teeTimeBooking.setUser(this);
	}
	
	// update, remove?

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setHandicap(double handicap) {
		this.handicap = handicap;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public void setMember(Membership member) {
		this.member = member;
	}
	public void setTeeTimes(Set<TeeTimeBooking> teeTimes) {
		this.teeTimes = teeTimes;
	}
	// getters
	public Long getUserId() {
		return userId;
	}
	public String getUsername() {
		return username;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public double getHandicap() {
		return handicap;
	}
	public Role getRole() {
		return role;
	}
	public Membership getMember() {
		return member;
	}
	public Set<TeeTimeBooking> getTeeTimes() {
		return teeTimes;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", handicap=" + handicap + ", role=" + role + "]";
	}
}
