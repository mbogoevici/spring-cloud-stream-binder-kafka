package org.springframework.cloud.stream.kafka.binder.kstream;

import org.springframework.cloud.stream.binder.AbstractBinder;
import org.springframework.cloud.stream.binder.Binding;
import org.springframework.cloud.stream.binder.ConsumerProperties;
import org.springframework.cloud.stream.binder.DefaultBinding;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.context.Lifecycle;

import org.apache.kafka.streams.kstream.KStream;

/**
 * @author Marius Bogoevici
 */
public class KStreamBinder extends AbstractBinder<KStream<?,?>, ConsumerProperties, ProducerProperties> {

    public static final Lifecycle ENDPOINT = new Lifecycle() {
        @Override
        public void start() {

        }

        @Override
        public void stop() {

        }

        @Override
        public boolean isRunning() {
            return false;
        }
    };


    @Override
    protected Binding<KStream<?, ?>> doBindConsumer(String name, String group, KStream<?, ?> inputTarget, ConsumerProperties properties) {
        return new DefaultBinding<>(name, group, inputTarget, ENDPOINT);
    }

    @Override
    protected Binding<KStream<?, ?>> doBindProducer(String name, KStream<?, ?> outboundBindTarget, ProducerProperties properties) {
        outboundBindTarget.to(name);
        return new DefaultBinding<>(name, null, outboundBindTarget, ENDPOINT);
    }



}
