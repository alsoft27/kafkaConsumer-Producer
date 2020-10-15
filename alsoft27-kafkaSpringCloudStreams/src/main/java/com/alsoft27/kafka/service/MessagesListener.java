package com.alsoft27.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.alsoft27.kafka.model.Poll;
import com.alsoft27.kafka.streams.MessagesStreams;

@Component
public class MessagesListener {

	private static final Logger log = LoggerFactory.getLogger(MessagesListener.class);

	@StreamListener(MessagesStreams.INPUT)
	public void manejarSaludos(@Payload final Poll poll) {
		log.info("messages in: {}", poll);
	}
}
