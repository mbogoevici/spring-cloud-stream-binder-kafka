package org.springframework.cloud.stream.kafka.binder.kstream.config;

import java.util.Properties;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.processor.TopologyBuilder;

import org.springframework.context.SmartLifecycle;

/**
 * @author Marius Bogoevici
 */
public class KStreamLifecycle implements SmartLifecycle {

	private KafkaStreams kafkaStreams;

	private TopologyBuilder topologyBuilder;

	public KStreamLifecycle(TopologyBuilder topologyBuilder) {
		this.topologyBuilder = topologyBuilder;
	}

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable runnable) {
		this.kafkaStreams.close();
		if (runnable != null) {
			runnable.run();
		}
	}

	@Override
	public void start() {

		Properties props = new Properties();
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG,
				Serdes.StringSerde.class.getName());
		props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG,
				Serdes.StringSerde.class.getName());
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "test");
		this.kafkaStreams = new KafkaStreams(topologyBuilder, props);
		this.kafkaStreams.start();

	}

	@Override
	public void stop() {
		stop(null);
	}

	@Override
	public boolean isRunning() {
		return false;
	}

	@Override
	public int getPhase() {
		return Integer.MAX_VALUE - 500;
	}
}
