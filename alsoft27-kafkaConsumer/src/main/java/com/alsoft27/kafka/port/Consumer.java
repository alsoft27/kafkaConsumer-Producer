package com.alsoft27.kafka.port;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.alsoft27.kafka.model.Poll;

@Component
public class Consumer {

	private static final Logger log = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "${kafka-topic}", groupId = "${kafka-consumers}", containerFactory = "kafkaListenerContainerFactory")
	public void processMessage(ConsumerRecord<String, Poll> poll) throws Exception {
		log.info("Message received {}, partition = {}, offset = {}, key = {} ", poll.value(), poll.partition(),
				poll.offset(), poll.key());
	}

}
