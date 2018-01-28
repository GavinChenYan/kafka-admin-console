

package com.kafka.admin.topicfactory;


import com.kafka.admin.common.Utils;

import java.util.Map;
import java.util.Properties;


public class DefaultTopicFactory implements TopicFactory {

  /** This constructor is required by TopicFactory but does nothing. */
  public DefaultTopicFactory(Map<String, ?> config) {
  }

  @Override
  public int createTopicIfNotExist(String zkUrl, String topic, int replicationFactor, double partitionToBrokerRatio, Properties topicConfig) {
    return Utils.createTopicIfNotExists(zkUrl, topic, replicationFactor, partitionToBrokerRatio, 1, topicConfig);
  }
}
