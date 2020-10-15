package com.alsoft27.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alsoft27.kafka.model.Poll;
import com.alsoft27.kafka.port.Producer;

@RestController
public class ProducerController {

	private static final Logger log = LoggerFactory.getLogger(ProducerController.class);

	@Autowired
	private Producer producer;

	@PostMapping(value = "/poll")
	@ResponseStatus(HttpStatus.OK)
	public String createPoll(@RequestBody Poll poll) {
		log.info("Poll to create {} ", poll);
		producer.send(poll);
		return poll.getId();
	}
}
