package com.microservices.github.service;



import com.microservices.github.model.GitHubResponse;


/**
 * The Interface GitHubService.
 */
public interface GitHubService {
	
	/**
	 * Gets the git hub repository details.
	 *
	 * @param owner the owner
	 * @param repositoryName the repository name
	 * @return the git hub repository details
	 */
	public GitHubResponse getGitHubRepositoryDetails(String owner, String repositoryName);
}
