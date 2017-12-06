
package com.kafka.admin.producer;

import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * A base producer used to abstract different producer classes.
 *
 * Implementations of this class must have constructor with the following signature:
 *   Constructor(java.util.Properties properties).
 */
public interface KMBaseProducer {

  RecordMetadata send(BaseProducerRecord record, boolean sync) throws Exception;

  void close();

}