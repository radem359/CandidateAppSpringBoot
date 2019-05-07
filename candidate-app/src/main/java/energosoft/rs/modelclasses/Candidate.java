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

/**
 * The Class Candidate.
 */
@Entity
@Table(name = "candidate")
public class Candidate{
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	/** The name. */
	@NotNull
	@Column(name = "name")
    private String name;

	/** The surname. */
	@Column(name = "surname")
    private String surname;

	/** The unique identification number. */
	@NotNull
	@Column(name = "unique_identification_number")
    private String uniqueIdentificationNumber;

	/** The year of birth. */
	@NotNull
	@Column(name = "year_of_birth")
    private int yearOfBirth;

	/** The email. */
	@NotNull
	@Column(name = "email")
    private String email;

	/** The telephone number. */
	@NotNull
	@Column(name = "telephone_number")
    private String telephoneNumber;

	/** The note. */
	@Column(name = "note")
	@Size(max = 250)
    private String note;

	/** The is hired. */
	@NotNull
	@Column(name = "is_hired")
    private Boolean isHired;

	/** The last change. */
	@NotNull
	@Column(name = "last_change")
    private String lastChange;

	/** The concourses. */
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "candidate_concourse")
	@JsonIgnore
    private Set<Concourse> concourses;

	/**
	 * Instantiates a new candidate.
	 */
	public Candidate() { }

	/**
	 * Instantiates a new candidate.
	 *
	 * @param name the name
	 * @param surname the surname
	 * @param uniqueIdentificationNumber the unique identification number
	 * @param yearOfBirth the year of birth
	 * @param email the email
	 * @param telephoneNumber the telephone number
	 * @param note the note
	 * @param isHired the is hired
	 * @param lastChange the last change
	 */
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

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the surname.
	 *
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the surname.
	 *
	 * @param surname the new surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Gets the unique identification number.
	 *
	 * @return the unique identification number
	 */
	public String getUniqueIdentificationNumber() {
		return uniqueIdentificationNumber;
	}

	/**
	 * Sets the unique identification number.
	 *
	 * @param uniqueIdentificationNumber the new unique identification number
	 */
	public void setUniqueIdentificationNumber(String uniqueIdentificationNumber) {
		this.uniqueIdentificationNumber = uniqueIdentificationNumber;
	}

	/**
	 * Gets the year of birth.
	 *
	 * @return the year of birth
	 */
	public int getYearOfBirth() {
		return yearOfBirth;
	}

	/**
	 * Sets the year of birth.
	 *
	 * @param yearOfBirth the new year of birth
	 */
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the telephone number.
	 *
	 * @return the telephone number
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * Sets the telephone number.
	 *
	 * @param telephoneNumber the new telephone number
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	/**
	 * Gets the note.
	 *
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * Sets the note.
	 *
	 * @param note the new note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * Gets the checks if is hired.
	 *
	 * @return the checks if is hired
	 */
	public Boolean getIsHired() {
		return isHired;
	}

	/**
	 * Sets the checks if is hired.
	 *
	 * @param isHired the new checks if is hired
	 */
	public void setIsHired(Boolean isHired) {
		this.isHired = isHired;
	}

	/**
	 * Gets the last change.
	 *
	 * @return the last change
	 */
	public String getLastChange() {
		return lastChange;
	}

	/**
	 * Sets the last change.
	 *
	 * @param lastChange the new last change
	 */
	public void setLastChange(String lastChange) {
		this.lastChange = lastChange;
	}

	/**
	 * Gets the concourses.
	 *
	 * @return the concourses
	 */
	public Set<Concourse> getConcourses() {
		return concourses;
	}

	/**
	 * Sets the concourses.
	 *
	 * @param concourses the new concourses
	 */
	public void setConcourses(Set<Concourse> concourses) {
		this.concourses = concourses;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", surname=" + surname + ", uniqueIdentificationNumber="
				+ uniqueIdentificationNumber + ", yearOfBirth=" + yearOfBirth + ", email=" + email
				+ ", telephoneNumber=" + telephoneNumber + ", note=" + note + ", isHired=" + isHired + ", lastChange="
				+ lastChange + ", concourses=" + concourses + "]";
	}
	
	
	
}