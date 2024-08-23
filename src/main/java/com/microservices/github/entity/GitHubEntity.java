package com.microservices.github.entity;

import java.util.Date;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The Class GitHubEntity.
 */
@Entity
@Table(name = "github")
@EntityListeners(AuditingEntityListener.class)
public class GitHubEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String fullName;
	private String description;
	private String cloneUrl;
	private int stars;
	private Date createdAt;
	@Column(name = "owner_name", nullable = false)
	private String owner;
	@Column(name = "repository_name", nullable = false)
	private String repositoryName;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCloneUrl() {
		return cloneUrl;
	}
	public void setCloneUrl(String cloneUrl) {
		this.cloneUrl = cloneUrl;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getRepositoryName() {
		return repositoryName;
	}
	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
}
