package com.alsoft27.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.alsoft27.kafka.model.Poll;
import com.alsoft27.kafka.streams.MessagesStreams;

@Service
public class MessagesService {

	private static final Logger log = LoggerFactory.getLogger(MessagesService.class);
	private final MessagesStreams messagesStreams;

	public MessagesService(final MessagesStreams messagesStreams) {
		this.messagesStreams = messagesStreams;
	}

	public void sendMessages(final Poll poll) {

		log.info("messages out {}", poll);
		final MessageChannel messageChannel = messagesStreams.messageOut();
		messageChannel.send(MessageBuilder.withPayload(poll)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
	}
}
