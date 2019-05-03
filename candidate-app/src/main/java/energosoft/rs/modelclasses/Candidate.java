package energosoft.rs.modelclasses;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "candidate")
public class Candidate{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@NotNull
	@Column(name = "name")
    private String name;

	@Column(name = "surname")
    private String surname;

	@NotNull
	@Column(name = "unique_identification_number")
    private String uniqueIdentificationNumber;

	@NotNull
	@Column(name = "year_of_birth")
    private int yearOfBirth;

	@NotNull
	@Column(name = "email")
    private String email;

	@NotNull
	@Column(name = "telephone_number")
    private String telephoneNumber;

	@Column(name = "note")
	@Size(max = 250)
    private String note;

	@NotNull
	@Column(name = "is_hired")
    private Boolean isHired;

	@NotNull
	@Column(name = "last_change")
    private String lastChange;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "candidate_concourse")
	@JsonIgnore
    private Set<Concourse> concourses;

	public Candidate() { }

	public Candidate(@NotNull String name, String surname,
			@NotNull String uniqueIdentificationNumber, @NotNull int yearOfBirth, @NotNull String email,
			@NotNull String telephoneNumber, String note, @NotNull Boolean isHired, @NotNull String lastChange) {
		super();
		this.name = name;
		this.surname = surname;
		this.uniqueIdentificationNumber = uniqueIdentificationNumber;
		this.yearOfBirth = yearOfBirth;
		this.email = email;
		this.telephoneNumber = telephoneNumber;
		this.note = note;
		this.isHired = isHired;
		this.lastChange = lastChange;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUniqueIdentificationNumber() {
		return uniqueIdentificationNumber;
	}

	public void setUniqueIdentificationNumber(String uniqueIdentificationNumber) {
		this.uniqueIdentificationNumber = uniqueIdentificationNumber;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getIsHired() {
		return isHired;
	}

	public void setIsHired(Boolean isHired) {
		this.isHired = isHired;
	}

	public String getLastChange() {
		return lastChange;
	}

	public void setLastChange(String lastChange) {
		this.lastChange = lastChange;
	}

	public Set<Concourse> getConcourses() {
		return concourses;
	}

	public void setConcourses(Set<Concourse> concourses) {
		this.concourses = concourses;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", surname=" + surname + ", uniqueIdentificationNumber="
				+ uniqueIdentificationNumber + ", yearOfBirth=" + yearOfBirth + ", email=" + email
				+ ", telephoneNumber=" + telephoneNumber + ", note=" + note + ", isHired=" + isHired + ", lastChange="
				+ lastChange + ", concourses=" + concourses + "]";
	}
	
	
	
}