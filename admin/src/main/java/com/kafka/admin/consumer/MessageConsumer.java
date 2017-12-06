
package com.kafka.admin.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;

/*
 * Wrap around the new consumer from Apache Kafka and implement the #KMBaseConsumer interface
 */
public class MessageConsumer implements KMBaseConsumer {

  private final KafkaConsumer<String, String> _consumer;
  private Iterator<ConsumerRecord<String, String>> _recordIter;

  public MessageConsumer(String topic, Properties consumerProperties) {
    _consumer = new KafkaConsumer<>(consumerProperties);
    _consumer.subscribe(Arrays.asList(topic));
  }

  @Override
  public BaseConsumerRecord receive() {
    if (_recordIter == null || !_recordIter.hasNext())
      _recordIter = _consumer.poll(Long.MAX_VALUE).iterator();

    ConsumerRecord<String, String> record = _recordIter.next();
    return new BaseConsumerRecord(record.topic(), record.partition(), record.offset(), record.key(), record.value());
  }

  @Override
  public void close() {
    _consumer.close();
  }

}
