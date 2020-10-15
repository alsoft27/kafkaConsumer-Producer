package com.alsoft27.kafka.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface MessagesStreams {

	String INPUT = "messages-in";
	String OUTPUT = "messages-out";

	@Input(INPUT)
	SubscribableChannel messageIn();

	@Output(OUTPUT)
	SubscribableChannel messageOut();

}
