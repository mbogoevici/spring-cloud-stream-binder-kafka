package org.springframework.cloud.stream.kafka.binder.kstream;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cloud.stream.binding.BindableTargetFactory;
import org.springframework.cloud.stream.config.ChannelBindingServiceProperties;

/**
 * @author Marius Bogoevici
 */
public class KStreamBindableTargetFactory implements BindableTargetFactory<KStream> {

    private final KStreamBuilder kStreamBuilder;


    private final ChannelBindingServiceProperties channelBindingServiceProperties;

    public KStreamBindableTargetFactory(KStreamBuilder streamBuilder, ChannelBindingServiceProperties channelBindingServiceProperties) {
        this.channelBindingServiceProperties = channelBindingServiceProperties;
        this.kStreamBuilder = streamBuilder;
    }

    @Override
    public KStream createInput(String name) {
        return kStreamBuilder.stream(channelBindingServiceProperties.getBindingDestination(name));
    }

    @Override
    public KStream createOutput(String name) {
        return new KStreamDelegate();
    }

}
