package energosoft.rs.modelclasses;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="concourse")
public class Concourse{

	@Id
	@Column(name = "concourseId", unique=true)
    private Integer concourseId;

	@NotNull
	@Column(name = "job")
    private String job;

	@NotNull
	@Column(name = "jobCode")
    private String jobCode;

	@ManyToMany(mappedBy = "concourses")
    private List<Candidate> candidates;

    public Concourse(){}

    public Concourse( int concourseId, String job, String jobCode, List<Candidate> candidates) {
        this.concourseId = concourseId;
        this.candidates = candidates;
        this.job = job;
        this.jobCode = jobCode;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Integer getConcourseId() {
        return concourseId;
    }

    public void setConcourseId(Integer concourseId) {
        this.concourseId = concourseId;
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