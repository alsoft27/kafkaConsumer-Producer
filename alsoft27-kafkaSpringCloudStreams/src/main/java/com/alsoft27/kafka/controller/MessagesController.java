package com.alsoft27.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alsoft27.kafka.model.Poll;
import com.alsoft27.kafka.service.MessagesService;

@RestController
public class MessagesController {

	private static final Logger log = LoggerFactory.getLogger(MessagesController.class);

	private final MessagesService service;

	public MessagesController(final MessagesService service) {
		this.service = service;
	}

	@PostMapping(value = "/poll")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String createPoll(@RequestBody Poll poll) {
		log.info("Poll to create {} ", poll);
		service.sendMessages(poll);
		return poll.getId();
	}

}
