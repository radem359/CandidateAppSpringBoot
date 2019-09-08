package humaresources.helper.com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import humaresources.helper.com.entities.Candidate;
import humaresources.helper.com.entities.Concourse;
import humaresources.helper.com.services.impl.CandidateService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyTest {
	
	//https://www.javainuse.com/spring/springboot_testcases
	
	@Autowired
    private CandidateService candidateService;
    
    @Test
    public void run(String... args) throws Exception {
    	
    }

}
