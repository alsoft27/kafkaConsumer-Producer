package com.alsoft27.kafka.port;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.alsoft27.kafka.model.Poll;

@Component
public class Producer {

	private static final Logger log = LoggerFactory.getLogger(Producer.class);

	@Autowired
	private KafkaTemplate<String, Poll> kafkaTemplate;

	@Value("${kafka-topic}")
	private String topic;

	Producer(KafkaTemplate<String, Poll> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void send(Poll poll) {
		ListenableFuture<SendResult<String, Poll>> future = this.kafkaTemplate.send(topic, String.valueOf(poll.getId()),
				poll);

		future.addCallback(new KafkaSendCallback<String, Poll>() {

			@Override
			public void onSuccess(SendResult<String, Poll> result) {
				log.info("Message sent {}", result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				log.error("Error sending message ", ex);
			}

			@Override
			public void onFailure(KafkaProducerException ex) {
				log.error("Error sending message ", ex);
			}
		});

		// log.info("Sent Poll {} to ", poll);

	}
}
