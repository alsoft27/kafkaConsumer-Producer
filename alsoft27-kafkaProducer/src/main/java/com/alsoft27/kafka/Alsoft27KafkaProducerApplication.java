package com.alsoft27.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Alsoft27KafkaProducerApplication {

	// private static final Logger log =
	// LoggerFactory.getLogger(Alsoft27KafkaProducerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Alsoft27KafkaProducerApplication.class, args);
	}

//	@Bean
//	public ApplicationRunner runner(Producer producer) {
//		return (args) -> {
//			long startTime = System.currentTimeMillis();
//			for (int i = 1; i < 10; i++) {
//				Faker faker = new Faker();
//				Poll poll = new Poll(String.valueOf(i), faker.name().firstName(), faker.address().fullAddress(),
//						faker.date().future(2, TimeUnit.HOURS), faker.lorem().characters(15, 25));
//
//				producer.send(poll);
//			}
//			log.info("Processing time = {}", System.currentTimeMillis() - startTime);
//		};
//	}
}
