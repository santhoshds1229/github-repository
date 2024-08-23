package com.microservices.github.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class GitHubResponse.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class GitHubResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String fullName;
	private String description;
	private String cloneUrl;
	private int stars;
	private Date createdAt;
	
}

