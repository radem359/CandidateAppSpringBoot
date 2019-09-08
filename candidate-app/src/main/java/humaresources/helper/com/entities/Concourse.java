package humaresources.helper.com.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="concourse")
public class Concourse{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@NotNull
	@Column(name = "job")
    private String job;

	@NotNull
	@Column(name = "job_code")
    private String jobCode;

	@ManyToMany
	@JoinTable(
			  name = "candidates_concourses", 
			  joinColumns = @JoinColumn(name = "candidate_id"), 
			  inverseJoinColumns = @JoinColumn(name = "concourse_id"))
    private Set<Candidate> candidates;

    public Concourse(){}

    public Concourse(String job, String jobCode) {
        this.job = job;
        this.jobCode = jobCode;
    }

    public Set<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

	@Override
	public String toString() {
		return "Concourse [id=" + id + ", job=" + job + ", jobCode=" + jobCode + ", candidates=" + candidates + "]";
	}
    
    
    
}