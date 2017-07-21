/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.stream.binder.kstream.config;

import org.springframework.cloud.stream.binder.kafka.properties.KafkaConsumerProperties;

/**
 * @author Marius Bogoevici
 */
public class KStreamConsumerProperties extends KafkaConsumerProperties {

	private String keySerde;

	private String valueSerde;

	public String getKeySerde() {
		return keySerde;
	}

	public void setKeySerde(String keySerde) {
		this.keySerde = keySerde;
	}

	public String getValueSerde() {
		return valueSerde;
	}

	public void setValueSerde(String valueSerde) {
		this.valueSerde = valueSerde;
	}
}
