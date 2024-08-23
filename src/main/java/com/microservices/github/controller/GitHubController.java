package com.microservices.github.controller;


import static com.microservices.github.constants.GitHubConstants.GITHUB_ENDPOINT;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.github.exception.ResourceNotFoundException;
import com.microservices.github.model.GitHubResponse;
import com.microservices.github.service.GitHubService;

/**
 * GitHubController.
 */
@RestController
public class GitHubController {

	private static final Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	private GitHubService gitHubService;
		
	
	/**
	 * Gets the git hub repository details.
	 *
	 * @param owner the owner
	 * @param repositoryName the repository name
	 * @return the git hub repository details
	 * @throws ResourceNotFoundException 
	 */
	@GetMapping(GITHUB_ENDPOINT)
	public ResponseEntity<?> getGitHubRepositoryDetails(@PathVariable String owner, @PathVariable String repositoryName) throws ResourceNotFoundException {
		LOGGER.info("Request to fetch GitHub Repository Details");
		GitHubResponse respone =null;
		if (StringUtils.isNotEmpty(owner) && StringUtils.isNotEmpty(repositoryName)) {
			respone= gitHubService.getGitHubRepositoryDetails(owner,repositoryName);
			if (respone!=null) {
				return new ResponseEntity<>(respone, HttpStatus.OK);				
			} else {
				LOGGER.error("No github repository details found for {}", owner);
				throw new ResourceNotFoundException("No github repository details found");
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
