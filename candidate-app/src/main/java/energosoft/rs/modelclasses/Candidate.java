package energosoft.rs.modelclasses;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "candidate")
public class Candidate{
	
	@Id
	@Column(name = "candidateId", unique=true)
    private Integer candidateId;
	
	@NotNull
	@Column(name = "name")
    private String name;

	@Column(name = "surname")
    private String surname;

	@NotNull
	@Column(name = "uniqueIdentificationNumber")
    private String uniqueIdentificationNumber;

	@NotNull
	@Column(name = "yearOfBirth")
    private int yearOfBirth;

	@NotNull
	@Column(name = "email")
    private String email;

	@NotNull
	@Column(name = "telephoneNumber")
    private String telephoneNumber;

	@ManyToMany
	@JoinTable(name = "candidate_concourse", 
			   joinColumns = {@JoinColumn(name = "candidateFk", referencedColumnName="candidateId")},
			   inverseJoinColumns = {@JoinColumn(name = "concourseFk",referencedColumnName = "concourseId")})
    private List<Concourse> concourses;

	@Column(name = "note")
    private String note;

	@NotNull
	@Column(name = "isHired")
    private boolean isHired;

	@NotNull
	@Column(name = "lastChange")
    private String lastChange;

    public Candidate() { }

    public Candidate(Integer candidateId, String name, String surname, String uniqueIdentificationNumber, int yearOfBirth, String email, String telephoneNumber, List<Concourse> concourses, String note, boolean isHired, String lastChange) {
        this.candidateId = candidateId;
        this.name = name;
        this.surname = surname;
        this.uniqueIdentificationNumber = uniqueIdentificationNumber;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.concourses = concourses;
        this.note = note;
        this.isHired = isHired;
        this.lastChange = lastChange;
    }

    public List<Concourse> getConcourses() {
        return concourses;
    }

    public void setConcourses(List<Concourse> concourses) {
        this.concourses = concourses;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
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

    public boolean isHired() {
        return isHired;
    }

    public void setHired(boolean hired) {
        isHired = hired;
    }

    public String getLastChange() {
        return lastChange;
    }

    public void setLastChange(String lastChange) {
        this.lastChange = lastChange;
    }

}