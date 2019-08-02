package com.deloitte.sample.microservice.api.rest;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * This class is used as a super class to be extended by all REST API
 * "controllers".
 */

public abstract class AbstractRestHandler implements ApplicationEventPublisherAware {

	protected ApplicationEventPublisher eventPublisher;
	protected static final String DEFAULT_PAGE_SIZE = "100";
	protected static final String DEFAULT_PAGE_NUM = "0";



	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;
	}



}
