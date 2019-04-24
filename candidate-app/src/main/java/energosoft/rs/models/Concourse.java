package energosoft.rs.models;

import java.util.List;

public class Concourse{

    private int idConcourse;

    private String job;

    private String jobCode;

    private List<Candidate> candidates;

    public Concourse(){}

    public Concourse( int idConcourse, String job, String jobCode, List<Candidate> candidates) {
        this.idConcourse = idConcourse;
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

    public int getIdConcourse() {
        return idConcourse;
    }

    public void setIdConcourse(int idConcourse) {
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

    @Override
    public String toString() {
        return this.job+" - "+this.jobCode;
    }
}