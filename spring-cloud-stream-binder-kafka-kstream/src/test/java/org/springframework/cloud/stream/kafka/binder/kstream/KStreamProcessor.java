package org.springframework.cloud.stream.kafka.binder.kstream;

import org.apache.kafka.streams.kstream.KStream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

/**
 * @author Marius Bogoevici
 */
public interface KStreamProcessor {

    @Input("input")
    KStream<?,?> input();

    @Output("output")
    KStream<?,?> output();
}
