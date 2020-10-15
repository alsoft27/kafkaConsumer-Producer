package com.alsoft27.kafka.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.alsoft27.kafka.streams.MessagesStreams;

@EnableBinding(MessagesStreams.class)
public class StreamsConfig {

}
