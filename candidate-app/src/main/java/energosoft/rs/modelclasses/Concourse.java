package energosoft.rs.modelclasses;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class Concourse.
 */
@Entity
@Table(name="concourse")
public class Concourse{

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	/** The job. */
	@NotNull
	@Column(name = "job")
    private String job;

	/** The job code. */
	@NotNull
	@Column(name = "job_code")
    private String jobCode;

	/** The candidates. */
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "concourses")
	@JsonIgnore
    private Set<Candidate> candidates;

    /**
     * Instantiates a new concourse.
     */
    public Concourse(){}

    /**
     * Instantiates a new concourse.
     *
     * @param job the job
     * @param jobCode the job code
     */
    public Concourse(String job, String jobCode) {
        this.job = job;
        this.jobCode = jobCode;
    }

    /**
     * Gets the candidates.
     *
     * @return the candidates
     */
    public Set<Candidate> getCandidates() {
        return candidates;
    }

    /**
     * Sets the candidates.
     *
     * @param candidates the new candidates
     */
    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
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
     * Gets the job.
     *
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * Sets the job.
     *
     * @param job the new job
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * Gets the job code.
     *
     * @return the job code
     */
    public String getJobCode() {
        return jobCode;
    }

    /**
     * Sets the job code.
     *
     * @param jobCode the new job code
     */
    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Concourse [id=" + id + ", job=" + job + ", jobCode=" + jobCode + ", candidates=" + candidates + "]";
	}
    
    
    
}