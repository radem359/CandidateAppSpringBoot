package energosoft.rs.models;

import java.util.List;

public class Candidate{

    private int candidateId;

    private String name;

    private String surname;

    private String uniqueIdentificationNumber;

    private int yearOfBirth;

    private String email;

    private String telephoneNumber;

    private List<Concourse> concourses;

    private String note;

    private boolean isHired;

    private String lastChange;

    public Candidate() { }

    public Candidate(int candidateId, String name, String surname, String uniqueIdentificationNumber, int yearOfBirth, String email, String telephoneNumber, List<Concourse> concourses, String note, boolean isHired, String lastChange) {
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

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
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

    @Override
    public String toString() {
        if(this.surname != null)
            return this.name+" "+this.surname;
        else
            return this.name;
    }

}