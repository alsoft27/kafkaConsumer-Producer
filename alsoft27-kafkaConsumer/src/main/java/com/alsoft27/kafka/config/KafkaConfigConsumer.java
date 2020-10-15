package com.alsoft27.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.alsoft27.kafka.model.Poll;

@Configuration
public class KafkaConfigConsumer {

	@Value("${servers-kafka}")
	private String servers;

	@Value("${sasl-jaas-config}")
	private String saslJaasConfig;

	@Value("${kafka-consumers}")
	private String consumers;

	public Map<String, Object> properties() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, consumers);
		props.put("security.protocol", "SASL_SSL");
		props.put("sasl.mechanism", "SCRAM-SHA-256");
		props.put("sasl.jaas.config", saslJaasConfig);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return props;
	}

	@Bean
	public ConsumerFactory<String, Poll> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(properties(), new StringDeserializer(),
				new JsonDeserializer<>(Poll.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Poll> kafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, Poll> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}
