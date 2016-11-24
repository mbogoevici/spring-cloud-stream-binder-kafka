package org.springframework.cloud.stream.kafka.binder.kstream.config;

import org.springframework.cloud.stream.kafka.binder.kstream.KStreamBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Marius Bogoevici
 */
@Configuration
public class KStreamBinderConfiguration {

    @Bean
    public KStreamBinder kStreamBinder() {
        return new KStreamBinder();
    }
}
