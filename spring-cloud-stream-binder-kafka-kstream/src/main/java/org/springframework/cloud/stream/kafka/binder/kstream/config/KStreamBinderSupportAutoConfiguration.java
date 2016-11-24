package org.springframework.cloud.stream.kafka.binder.kstream.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.config.ChannelBindingServiceProperties;
import org.springframework.cloud.stream.kafka.binder.kstream.KStreamBindableTargetFactory;
import org.springframework.cloud.stream.kafka.binder.kstream.KStreamStreamListenerResultAdapter;
import org.springframework.context.annotation.Bean;

import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.processor.TopologyBuilder;

/**
 * @author Marius Bogoevici
 */
@EnableBinding
public class KStreamBinderSupportAutoConfiguration {

    @Bean
    public KStreamBuilder kStreamBuilder() {
        return new KStreamBuilder();
    }

    @Bean
    public KStreamStreamListenerResultAdapter kStreamStreamListenerResultAdapter() {
        return new KStreamStreamListenerResultAdapter();
    }

    @Bean
    public KStreamBindableTargetFactory kStreamBindableTargetFactory(KStreamBuilder kStreamBuilder, ChannelBindingServiceProperties channelBindingServiceProperties) {
        return new KStreamBindableTargetFactory(kStreamBuilder, channelBindingServiceProperties);
    }

    @Bean
    public KStreamLifecycle kStreamLifecycle(TopologyBuilder topologyBuilder) {
        return new KStreamLifecycle(topologyBuilder);
    }
}
