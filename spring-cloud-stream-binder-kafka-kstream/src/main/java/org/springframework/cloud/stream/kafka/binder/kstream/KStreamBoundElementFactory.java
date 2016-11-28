package org.springframework.cloud.stream.kafka.binder.kstream;

import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;

import org.springframework.cloud.stream.binding.AbstractBoundElementFactory;
import org.springframework.cloud.stream.binding.BoundElementFactory;
import org.springframework.cloud.stream.config.ChannelBindingServiceProperties;

/**
 * @author Marius Bogoevici
 */
public class KStreamBoundElementFactory extends AbstractBoundElementFactory<KStream> {

	private final KStreamBuilder kStreamBuilder;

	private final ChannelBindingServiceProperties channelBindingServiceProperties;

	public KStreamBoundElementFactory(KStreamBuilder streamBuilder,
			ChannelBindingServiceProperties channelBindingServiceProperties) {
		super(KStream.class);
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
