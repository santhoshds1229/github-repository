package com.microservices.github.test;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.microservices.github.GithubApplication;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = GithubApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GitHubControllerTest {
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }
    
    @Test
    public void contextLoads() {

    }
    @Test
    public void testGetAllUsers() {
         HttpHeaders headers = new HttpHeaders();
         Map<String, String> vars = new HashMap<>();
         vars.put("owner", "santhosh");
         vars.put("repositoryName", "github");
         HttpEntity<String> entity = new HttpEntity<String>(null, headers);
         ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/repositories/{owner}/{repositoryName}",
         HttpMethod.GET, entity, String.class, vars);
         assertNotNull(response.getBody());
    }

}
