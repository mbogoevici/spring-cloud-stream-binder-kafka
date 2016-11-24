package org.springframework.cloud.stream.kafka.binder.kstream;

import org.springframework.cloud.stream.binding.StreamListenerResultAdapter;

import org.apache.kafka.streams.kstream.KStream;

/**
 * @author Marius Bogoevici
 */
public class KStreamStreamListenerResultAdapter implements StreamListenerResultAdapter<KStream, KStream> {
    @Override
    public boolean supports(Class<?> resultType, Class<?> boundElement) {
        return KStream.class.isAssignableFrom(resultType) && KStream.class.isAssignableFrom(boundElement);
    }

    @Override
    public void adapt(KStream streamListenerResult, KStream boundElement) {
        ((KStreamDelegate<?,?>) boundElement).setDelegate(streamListenerResult);
    }
}
