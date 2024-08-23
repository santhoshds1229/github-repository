package com.microservices.github.repository;


import com.microservices.github.entity.GitHubEntity;
import com.microservices.github.model.GitHubResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * The Interface GitHubRepository.
 */
public interface GitHubRepository extends JpaRepository<GitHubEntity, String> {

	/**
	 * Find by owner and repository name.
	 *
	 * @param owner the owner
	 * @param repositoryName the repository name
	 * @return the git hub response
	 */
	GitHubResponse findByOwnerAndRepositoryName(@Param("owner") String owner, @Param("repositoryName") String repositoryName);

}
