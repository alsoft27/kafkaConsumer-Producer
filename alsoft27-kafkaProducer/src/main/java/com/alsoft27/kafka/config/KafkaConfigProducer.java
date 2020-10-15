package com.alsoft27.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.alsoft27.kafka.model.Poll;

@Configuration
public class KafkaConfigProducer {

	@Value("${servers-kafka}")
	private String servers;

	@Value("${sasl-jaas-config}")
	private String saslJaasConfig;

	public Map<String, Object> properties() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
		props.put(ProducerConfig.ACKS_CONFIG, "all");
		// props.put(ProducerConfig.BATCH_SIZE_CONFIG, "10");
		// props.put(ProducerConfig.LINGER_MS_CONFIG, "10");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		props.put("security.protocol", "SASL_SSL");
		props.put("sasl.mechanism", "SCRAM-SHA-256");
		props.put("sasl.jaas.config", saslJaasConfig);
		return props;
	}

	@Bean
	public KafkaTemplate<String, Poll> kafkaTemplate() {
		DefaultKafkaProducerFactory<String, Poll> producerFactory = new DefaultKafkaProducerFactory<>(properties());
		KafkaTemplate<String, Poll> template = new KafkaTemplate<>(producerFactory);
		return template;
	}

}
