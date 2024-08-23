package com.microservices.github.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.github.model.GitHubResponse;
import com.microservices.github.repository.GitHubRepository;


/**
 * The Class GitHubServiceImpl.
 */
@Service
public class GitHubServiceImpl implements GitHubService {
	
	@Autowired
	GitHubRepository repository;
	
	/**
	 * Gets the git hub repository details.
	 *
	 * @param owner the owner
	 * @param repositoryName the repository name
	 * @return the git hub repository details
	 */
	@Override
	public GitHubResponse getGitHubRepositoryDetails(String owner, String repositoryName) {
		return repository.findByOwnerAndRepositoryName(owner, repositoryName);
	}

}
