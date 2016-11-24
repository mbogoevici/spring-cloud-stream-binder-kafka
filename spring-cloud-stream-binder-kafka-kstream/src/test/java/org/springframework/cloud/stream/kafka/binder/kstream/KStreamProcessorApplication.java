package org.springframework.cloud.stream.kafka.binder.kstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;

/**
 * @author Marius Bogoevici
 */
@SpringBootApplication
@EnableBinding(KStreamProcessor.class)
public class KStreamProcessorApplication {


    @StreamListener("input")
    @SendTo("output")
    public KStream<String, String> process(KStream<String,String> input) {
        return input.map((k, v) -> KeyValue.pair(k, v.toUpperCase() + "-transformed"));
    }


    public static void main(String[] args) {
        SpringApplication.run(KStreamProcessorApplication.class, args);
    }

}
