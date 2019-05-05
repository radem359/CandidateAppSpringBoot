package energosoft.rs.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import energosoft.rs.modelclasses.Candidate;
import energosoft.rs.modelclasses.Concourse;
import energosoft.rs.services.impl.CandidateService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyTest {
	
	//https://www.javainuse.com/spring/springboot_testcases
	
	@Autowired
    private CandidateService candidateService;
    
    @Test
    public void run(String... args) throws Exception {

        // =======================================

        // Create a Candidate
        Candidate candidate = new Candidate("Radosav", "", "0112995810096", 1995, "email@gmail.com", "0652086053", "", true, "30.04.2019.");

        // Create two Concourse
        Concourse concourse1 = new Concourse("Java Developer", "JDev");
        Concourse concourse2 = new Concourse("ASP .NET Developer", "ASPNETDev");


        // Add tag references in the candidate
        candidate.getConcourses().add(concourse1);
        candidate.getConcourses().add(concourse2);

        // Add post reference in the tags
        concourse1.getCandidates().add(candidate);
        concourse2.getCandidates().add(candidate);

        candidateService.create(candidate);

        // =======================================

    }

}
