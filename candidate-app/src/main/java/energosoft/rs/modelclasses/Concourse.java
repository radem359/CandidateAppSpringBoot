package energosoft.rs.modelclasses;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Concourse{

	@Id
	@Column(name = "idConcourse")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConcourse;

	@Column(name = "job")
    private String job;

	@Column(name = "jobCode")
    private String jobCode;

    //private List<Candidate> candidates;

    public Concourse(){}

    public Concourse( int idConcourse, String job, String jobCode/*, List<Candidate> candidates*/) {
        this.idConcourse = idConcourse;
        //this.candidates = candidates;
        this.job = job;
        this.jobCode = jobCode;
    }

    /*public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }*/

    public Integer getIdConcourse() {
        return idConcourse;
    }

    public void setIdConcourse(Integer idConcourse) {
        this.idConcourse = idConcourse;
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
}